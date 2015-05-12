package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;

import controller.StudentListController;

public class MyDispatcherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WebApplicationContext ctx = 
				ContextLoaderListener.getCurrentWebApplicationContext();
		
		HandlerInterceptor interceptor = null;// 설정되었다고 가정하자.
		
		// 인터셉터가 있다면 사전 작업 수행
		try {
			interceptor.preHandle(request, response, null);
		} catch (Exception e) {}

		// 페이지 컨트롤러를 찾아서 실행한다.
		StudentListController pageController = 
				(StudentListController) ctx.getBean("studentListController");
		String viewUrl = pageController.execute(null);
		
		// 인터셉터가 있다면 사후 작업 수행
		try {
			interceptor.postHandle(request, response, null, null);
		} catch (Exception e) {}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
		rd.include(request, response);
		
		// 인터셉터가 있다면 클라이언트로 콘텐츠를 보내기 전에 최종 마무리 작업 
		try {
			interceptor.afterCompletion(request, response, null, null);
		} catch (Exception e) {}
		
	}
}









