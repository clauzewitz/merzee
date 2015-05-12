package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.StudentService;
import vo.Student;

@Controller
@RequestMapping("/add")
public class StudentAddController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "student/studentform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(Student student, Model m) {
		try {
			studentService.add(student);
			m.addAttribute("student", student);
			return "student/add";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
	
}







