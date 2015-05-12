package controller01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.Student;

import dao.StudentDao;

@Controller
public class StudentUpdateController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView form(long no) {
		try {
			Student s = studentDao.getStudent(no);
			return new ModelAndView("/updateform.jsp", "student", s);
		} catch (Exception e) {
			return new ModelAndView("/error.jsp", "error", e);
		} 
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView update(Student student) {
		try {
			studentDao.change(student);
			return new ModelAndView("/update.jsp");
		} catch (Exception e) {
			return new ModelAndView("/error.jsp", "error", e);
		}
	}
}







