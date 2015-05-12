package controller02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vo.Student;
import dao.StudentDao;

@Controller
@RequestMapping("/detail")
public class StudentDetailController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String execute(@RequestParam("no")long studentNo,Model m) {
		try {
			Student s = studentDao.getStudent(studentNo);
			m.addAttribute("student", s);
			return "student/detail";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";			
		}
	}	
	
	@RequestMapping(value="/{no}", method=RequestMethod.GET)
	public String execute2(@PathVariable("no")long studentNo,Model m) {
		try {
			Student s = studentDao.getStudent(studentNo);
			m.addAttribute("student", s);
			return "student/detail";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";			
		}
	}
}