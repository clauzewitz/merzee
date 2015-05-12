package controller.ajax;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vo.AjaxResult;
import dao.StudentDao;

@Controller("StudentDeleteControllerForAjax")
@RequestMapping("/student/delete")
public class StudentDeleteController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public AjaxResult execute(@RequestParam("no")long studentNo) {
		try {
			studentDao.remove(studentNo);
			return new AjaxResult()
			.setStatus("ok")
			.setResult("delete_done");			
		} catch (Exception e) {
			return new AjaxResult()
			.setStatus("error")
			.setResult(e.getMessage());
		}
	}
}