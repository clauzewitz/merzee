package controller.ajax;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.AjaxResult;
import vo.Student;
import dao.StudentDao;

@Controller("StudentAddControllerForAjax")
@RequestMapping("/student/add")
public class StudentAddController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public AjaxResult execute(Student student) {
		try {
			
			studentDao.add(student);
			return new AjaxResult()
			.setStatus("ok")
			.setResult("success");			

		} catch (Exception e) {
			return new AjaxResult()
			.setStatus("error")
			.setResult(e.getMessage());
		}
	}
}