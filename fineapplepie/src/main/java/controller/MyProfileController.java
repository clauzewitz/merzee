package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import vo.Student;

import dao.StudentDao;

public class MyProfileController extends org.apache.struts.action.Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getSession().getAttribute("userNo") != null) {
			WebApplicationContext ctx = 
					WebApplicationContextUtils.getWebApplicationContext(
							request.getServletContext()); 			
			StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
			Student s = studentDao.getStudent(
					(Long)request.getSession().getAttribute("userNo"));
			request.setAttribute("student", s);
			return mapping.findForward("success");
		} else {
			return mapping.findForward("fail");
		}
	}

}
