package controller02;


import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import vo.Student;
import dao.StudentDao;

@Controller
@RequestMapping("/login")
//모델에 담겨있는 데이터중에서 세션 어트리뷰트에 있는것은 세션에 보관해라.. 리퀘스트에 보관하지 않는다.
@SessionAttributes({"userNo","userName","userEmail","userMobile"})  
public class LoginController {
		
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.GET)   //로그인폼..
	public String form(@CookieValue(required=false,defaultValue="") String useremail, Model m ) {
		m.addAttribute("useremail", useremail);
		if(useremail.length() > 0){
			m.addAttribute("checked", "checked");
		}
		return "auth/loginForm";   //앞에 뷰가 붙어 있다..!!  끝에 jsp가  붙혀진다..
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(String email, String passwd, String saveid ,
			HttpServletResponse response,Model m) {
		try {
			
			HashMap<String,String> params = new HashMap<String,String>();
			params.put("email", email);
			params.put("passwd", passwd);
			
			
			String view = null;
			if (studentDao.exist(params)) {
				Student student = studentDao.getStudentByEmail(email);
				
				//세션에 담기 위한    Model삽입..
				m.addAttribute("userNo", student.getNo());
				m.addAttribute("userName", student.getName());
				m.addAttribute("userEmail", student.getEmail());
				m.addAttribute("userMobile", student.getMobile());
				
				view = "auth/login";
				
			} else {  //exist 학생정보가 없었을때.. 로그인 폼으로 뛰어라..				
				view = "auth/loginForm";
			}
						
			System.out.println(saveid);
			Cookie cookie = null;
			if(saveid != null){
				cookie = new Cookie("useremail", email);
				cookie.setMaxAge(300);
			}else{
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