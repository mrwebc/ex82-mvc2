package com.study.jsp.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.conf.Factory;
import com.study.jsp.model.UserDTO;
import com.study.jsp.srv.UserService;

@WebServlet("/loginCtrl")
public class LoginController extends HttpServlet{

  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    String userid = request.getParameter("userid");
    String userpw = request.getParameter("userpw");
  
    Map<String, String> loginInfo = new HashMap<String, String>();
    loginInfo.put("userid",userid);
    loginInfo.put("userpw",userpw);
  
    UserService userService = Factory.INSTANCE.getUserService();
    UserDTO dto = userService.getOne(loginInfo);
    
    HttpSession session = request.getSession();
    
    if(dto != null) {
      session.setAttribute("userid", dto.getUserid());
      session.setAttribute("name", dto.getName());
      
      response.sendRedirect("./listCtrl");
    }else{
      response.sendRedirect("./login.jsp");
    }
  }

}
