package controller02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.Student;

import dao.StudentDao;

@Controller
@RequestMapping("/add")
public class StudentAddController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "student/studentform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String add(Student student, Model m) {
		try {
			studentDao.add(student);
			m.addAttribute("student", student);
			return "student/add";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
	
}

