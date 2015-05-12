package controller01;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.Student;

import dao.StudentDao;

@Controller
public class StudentListController {
	@Autowired
	StudentDao studentDao;
	
	/*
	@Autowired // 기본이 required
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	*/
	
	@RequestMapping(value="/list")
	public ModelAndView execute() {
		try {
			Collection<Student> list = studentDao.getStudentList();
			return new ModelAndView("/list.jsp", "list", list);
			
		} catch (Exception e) {
			ModelAndView m = new ModelAndView();
			m.addObject("error", e);
			m.setViewName("/error.jsp");
			return m;
		}
	}
}







