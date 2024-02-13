package com.study.jsp.ctrl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.conf.Factory;
import com.study.jsp.model.BoardDTO;
import com.study.jsp.srv.BoardService;

@WebServlet("/listCtrl")
public class ListController extends HttpServlet{

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    
    System.out.println("ListCtrl~!");
    
    //login page를 거쳐오면 session에 id와 name 속성이 존재한다
    if(session.getAttribute("userid") == null) {
        response.sendRedirect("./login.jsp");
        return;
    }

    BoardService boardService = Factory.INSTANCE.getBoardService();
    List<BoardDTO> list = boardService.findAll();
    
    request.setAttribute("list", list);
    
    //getRequestDispatcher()는 contextPath를 기준으로 자원을 구한다.
    RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
    dispatcher.forward(request, response);
    
  }

}
