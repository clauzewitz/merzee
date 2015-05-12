package controller02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.Student;

import dao.StudentDao;

@Controller
public class StudentUpdateController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String form(long no, Model m) {
		try {
			Student s = studentDao.getStudent(no);
			m.addAttribute("student", s);
			return "student/updateform";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		} 
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Student student, Model m) {
		try {
			studentDao.change(student);
			return "student/update";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
}