package controller01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.Student;

import dao.StudentDao;

@Controller
@RequestMapping("/add")
public class StudentAddController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form() {
		return new ModelAndView("/studentform.html");
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView add(Student student) {
		try {
			studentDao.add(student);
			return new ModelAndView("/add.jsp", "student", student);
			
		} catch (Exception e) {
			return new ModelAndView("/error.jsp", "error", e);
		}
	}
	
}







