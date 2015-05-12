package controller02;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.Student;
import dao.StudentDao;

@Controller
public class StudentListController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value="/list")
	public String execute(Model m) {
		System.out.println("StudentListController..호출");
		try {
			Collection<Student> list = studentDao.getStudentList();
			m.addAttribute("list",list);
			return "student/list";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
}