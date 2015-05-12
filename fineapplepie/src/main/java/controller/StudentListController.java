package controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.StudentService;
import vo.Student;

@Controller
public class StudentListController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/list")
	public String execute(Model m) {
		System.out.println("StudentListController..호출");
		try {
			Collection<Student> list = studentService.getStudentList();
			m.addAttribute("list", list);
			return "student/list";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
}







