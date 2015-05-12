package controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.DiaryService;
import vo.AjaxResult;
import vo.MerzeeDiary;
import dao.DiaryDao;

@Controller
public class CopyOfDiaryAddController {
	@Autowired
	//DiaryService diaryService;
	DiaryService diaryService;
	
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public AjaxResult add(MerzeeDiary diary, HttpServletRequest	request,
			HttpServletResponse response, Model m) {		
		try {
			System.out.println(diary.toString());
			diaryService.add(diary);
			return new AjaxResult()
			.setStatus("ok")
			.setResult("다이어리가 생성 되었습니다.");			
		} catch (Exception e) {
			return new AjaxResult()
			.setStatus("error")
			.setResult(e.getMessage());
		}	
	}
}