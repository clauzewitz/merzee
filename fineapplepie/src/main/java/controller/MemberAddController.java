package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.AjaxResult;
import vo.MerzeeMember;
import dao.MemberDao;

@Controller
@RequestMapping("/merzeejoin")
public class MemberAddController {
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	public AjaxResult join(MerzeeMember member, HttpServletRequest	request,
			HttpServletResponse response, Model m) {		
		try {
			System.out.println(member.toString());			
			memberDao.add(member);
			return new AjaxResult()
			.setStatus("ok")
			.setResult(member.getName()+"님 가입을 축하드립니다.");			
		} catch (Exception e) {
			return new AjaxResult()
			.setStatus("error")
			.setResult(e.getMessage());
		}	
	}
}







