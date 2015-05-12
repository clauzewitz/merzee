package controller02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.StudentDao;

@Controller
@RequestMapping("/delete")
public class StudentDeleteController {
	@Autowired
	StudentDao studentDao;

	@RequestMapping
	public String delete(@RequestParam("no")long studentNo, Model m){
		
		try {
			studentDao.remove(studentNo);
			return "student/delete";
			
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
	}
}
