package org.zerock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ogr.zerock.service.SampleService;

/**
 * Servlet implementation class SampleController
 */
@WebServlet("/SampleA")
public class SampleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SampleController() {
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET.......................");
		
		req.getRequestDispatcher("/WEB-INF/views/input.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("POST......");
		String str = req.getParameter("text");
		
		System.out.println("str : "+str);
		
		SampleService.INSTANCE.add(str);
		//get방식임 redirect(url 변경)
		//1. url 심기
		resp.sendRedirect("/list?msg=success");
		
//		req.setAttribute("list", SampleService.INSTANCE.getList());
//		
//		req.getRequestDispatcher("/WEB-INF/views/list.jsp")
//		.forward(req, resp);
	}

	



}
