package controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.StudentService;
import vo.Student;

@Controller
@RequestMapping("/detail")
public class StudentDetailController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String execute(@RequestParam("no")long studentNo, Model m) {
		try {
			List<Student> list = studentService.getStudent(
							StudentService.NO, studentNo);
			m.addAttribute("student", list.get(0));
			return "student/detail";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
			
		}
	}
	
	@RequestMapping(value="/{no}", method=RequestMethod.GET)
	public String execute2(@PathVariable("no") long studentNo, Model m) {
		try {
			List<Student> list = studentService.getStudent(
					StudentService.NO, studentNo);
			m.addAttribute("student", list.get(0));
			return "student/detail";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
			
		}
	}
}





