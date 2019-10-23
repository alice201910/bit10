package org.zerock.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.dao.BoardDAO;
import org.zerock.dao.BoardDAOImpl;
import org.zerock.dto.PageMaker;
import org.zerock.dto.PagingDTO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/*")	// board로 시작하는 모든 애들 다받음
public class BoardController extends BasicController {
	private static final long serialVersionUID = 1L;
    
	private BoardDAO dao;
	
	public BoardController() {
		dao = new BoardDAOImpl();
	}

	@RequestMapping(value = "/board/register", type = "GET")
	public String add(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//파라미터 수집 -> pageDTO 변환
		PagingDTO dto = new PagingDTO(req.getParameter("page"), req.getParameter("amount"));
		//Model 완성
		req.setAttribute("list", dao.getList(dto));
		req.setAttribute("pm", new PageMaker(dao.getCount(),dto));
		System.out.println("list...............");
		return "/board/list";
	}
	
	@RequestMapping(value = "/board/list", type = "GET")
	public String list(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		System.out.println("list...............");
		return "/board/list";
	}

	


}
