package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.MemberService;
import vo.MerzeeMember;

@Controller
@RequestMapping("/merzeelogin")
@SessionAttributes({"userEmail","userName","userNickname","userGender"})
public class MerzeeLoginController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(String email, String passwd,
			HttpServletRequest	request,
			HttpServletResponse response, Model m) {		
		try {
			//로그인 성공/실패시 이동할 url
			String view = null;
			if(memberService.exist(email, passwd)) {
				List<MerzeeMember> list = memberService.getMember(memberService.EMAIL, email);
				MerzeeMember merzeeMember = list.get(0);
				m.addAttribute("userEmail", merzeeMember.getEmail());
				m.addAttribute("userName", merzeeMember.getName());
				m.addAttribute("userNickname", merzeeMember.getNickname());
				m.addAttribute("userGender", merzeeMember.getGender());
				view = "select_diary";
			} else {
				view = "error";
			}
			return view;
		} catch (Exception e) {
			m.addAttribute("error", e);
			return "error";
		}
		
	}
}
