package controller.ajax;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.AjaxResult;
import vo.Student;

import dao.StudentDao;

@Controller("StudentListControllerForAjax")
public class StudentListController {
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value="/student/list", produces="application/json")
	public AjaxResult execute(HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin","*");
		
		try{
		return new AjaxResult()
			.setStatus("ok")
			.setResult(studentDao.getStudentList());
		} catch (Exception e) {
			return new AjaxResult()
			.setStatus("error")
			.setResult(e.getMessage());
		}
	}
	
//	@RequestMapping(value="/student/list")
//	public ResponseEntity<String> execute() {
//		HttpHeaders responsHeaders = new HttpHeaders();
//		responsHeaders.set("Content-Type","text/plain; charset=UTF-8");
//		
//		try {
//			Collection<Student> list = studentDao.getStudentList();
//			return  new ResponseEntity<String>(
//					new Gson().toJson(list), responsHeaders, HttpStatus.CREATED);
//			
//		} catch (Exception e) {
//			return  new ResponseEntity<String>(
//					"error", responsHeaders, HttpStatus.CREATED);
//		}
//	}
	
	
//	@RequestMapping(value="/student/list")
//	@ResponseBody
//	public String execute(Model m) {
//		try {
//			Collection<Student> list = studentDao.getStudentList();
//			
//			return new Gson().toJson(list);
//			
//		} catch (Exception e) {
//			return "error";
//		}
//	}
	
//	@RequestMapping(value="/student/list")
//	public String execute(Model m) {
//		System.out.println("StudentListController..호출");
//		try {
//			Collection<Student> list = studentDao.getStudentList();
//			m.addAttribute("list",list);
//			return "ajax/list";
//			
//		} catch (Exception e) {
//			m.addAttribute("error", e);
//			return "error";
//		}
//	}
}