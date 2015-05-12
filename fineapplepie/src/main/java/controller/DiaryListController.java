package controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.DiaryService;
import vo.AjaxResult;
import vo.Student;

import dao.StudentDao;

@Controller
public class DiaryListController {
	@Autowired
	DiaryService diaryService;
	
	@RequestMapping(value="/merzeelist", produces="application/json")
	public AjaxResult execute(HttpServletRequest	request, HttpServletResponse response) {
		
		response.setHeader("Access-Control-Allow-Origin","*");
		System.out.println("리스트");
		try{
		return new AjaxResult()
			.setStatus("ok")
			.setResult(diaryService.getDiaryList((String)request.getSession().getAttribute("userEmail")));
		} catch (Exception e) {
			return new AjaxResult()
			.setStatus("error")
			.setResult(e.getMessage());
		}
	}
}