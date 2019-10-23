package org.zerock.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicController
 */
public abstract class BasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse res) throws ServletException, IOException {
		
		String path = req.getRequestURI(); //PATH: /board/register 
		
		System.out.println("PATH: " + path);
		
		String methodType = req.getMethod(); // Method: GET 
		
		System.out.println("Method: " + methodType);
		
		Method[] methods = this.getClass().getDeclaredMethods(); //Service
		
		Method targetMethod = null;
		
		for (int i = 0; i < methods.length; i++) {
			Method m = methods[i]; //service
			RequestMapping anno =
					m.getDeclaredAnnotation(RequestMapping.class); //ReqM의 anno
			
			String annoPath = anno.value();
			String annoType = anno.type();
			
			if (path.equals(annoPath) && (annoType.equals(methodType))) {
				targetMethod = m; //Service
				break; //메소드 다 찾으면 탈출
			}
			
		}
		
		try {
			String result = (String)targetMethod.invoke(this, req, res); //메소드 호출 service 호출
			
			if(result.startsWith("redirect:")) { 
				res.sendRedirect(result.substring(10)); //redirect: 날림
				
			} else {
				req.getRequestDispatcher("/WEB-INF/views" + result + ".jsp")
				.forward(req, res);
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
