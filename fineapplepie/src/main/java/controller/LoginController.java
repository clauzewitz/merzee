package controller;


import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.StudentService;
import vo.Student;

@Controller
@RequestMapping("/login")
@SessionAttributes({"userNo","userName","userEmail","userMobile"})
public class LoginController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(@CookieValue(required=false,defaultValue="") String useremail, Model m) {
		m.addAttribute("useremail", useremail);
		if (useremail.length() > 0) {
			m.addAttribute("checked", "checked");
		}
		return "auth/loginForm";
	}
	
	//로그인을 요청한다..  POST로..
	@RequestMapping(method=RequestMethod.POST)
	public String login(String email, String passwd, String saveid, 
			HttpServletResponse response, Model m) {		
		try {
			String view = null;	
			if (studentService.exist(email, passwd)) {
				List<Student> list = studentService.getStudent(
						StudentService.EMAIL, email);
				Student student = list.get(0);
				m.addAttribute("userNo", student.getNo());
				m.addAttribute("userName", student.getName());
				m.addAttribute("userEmail", student.getEmail());
				m.addAttribute("userMobile", student.getMobile());
				view = "auth/login";
			} else {
				view = "auth/loginForm";
			}

			Cookie cookie = null;
			if (saveid != null) {
				cookie = new Cookie("useremail", email);
				cookie.setMaxAge(300);
			} else {
				cookie = new Cookie("useremail", "");
			}
			response.addCookie(cookie);			
			return view;
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
	
	
}
