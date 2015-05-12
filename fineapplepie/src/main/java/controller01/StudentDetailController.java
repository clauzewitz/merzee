package controller01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vo.Student;

import dao.StudentDao;

@Controller
@RequestMapping("/detail")
public class StudentDetailController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView execute(@RequestParam("no")long studentNo) {
		try {
			Student s = studentDao.getStudent(studentNo);
			return new ModelAndView("/detail.jsp", "student", s);
			
		} catch (Exception e) {
			return new ModelAndView("/error.jsp", "error", e);
			
		}
	}

}





