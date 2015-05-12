package controller.ajax;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vo.AjaxResult;
import dao.StudentDao;

@Controller("StudentDetailControllerForAjax")
@RequestMapping("/student/detail")
public class StudentDetailController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public AjaxResult execute(@RequestParam("no")long studentNo) {
		try {
			return new AjaxResult()
			.setStatus("ok")
			.setResult(studentDao.getStudent(studentNo));			
		} catch (Exception e) {
			return new AjaxResult()
			.setStatus("error")
			.setResult(e.getMessage());
		}
	}
}