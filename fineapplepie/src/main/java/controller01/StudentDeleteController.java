package controller01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.StudentDao;

@Controller
@RequestMapping("/delete")
public class StudentDeleteController {
	@Autowired
	StudentDao studentDao;

	@RequestMapping
	public ModelAndView delete(@RequestParam("no")long studentNo){
		
		try {
			studentDao.remove(studentNo);
			return new ModelAndView("/delete.jsp");
		} catch (Exception e) {
			return new ModelAndView("/error.jsp", "error", e);
		}
	}
}
