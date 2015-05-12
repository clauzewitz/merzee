package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.StudentService;
import vo.Student;

@Controller
public class StudentUpdateController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String form(long no, Model m) {
		try {
			List<Student> list = studentService.getStudent(
					StudentService.NO, new Long(no));
			m.addAttribute("student", list.get(0));
			return "student/updateform";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		} 
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Student student, Model m) {
		try {
			studentService.change(student);
			return "student/update";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
}







