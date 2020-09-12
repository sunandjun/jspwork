package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.model.Post;

//http://localhost:8080/blog/ffidfdf.do
//모든 .do 요청은 FrontController를 탄다.
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
       
    }
    //http://localhost:8080/post/list.do
     void route(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String uri = request.getRequestURI();
		
 		if(uri.equals("/post/list.do")) { //메인 페이지
 			//모델 (DB 연결 - 데이터 가져와서
 			Post post = new Post(1,"제목1","내용1",1,null,2); //DB에서 들고왔다고 가정
 			
 			request.setAttribute("post",post);
 		
 			//페이지 이동시에 request, response 가 새로만들어지는데
 			//RequestDispatcher는 request, response를 유지시킨다.
 			RequestDispatcher dis = request.getRequestDispatcher("/post/list.jsp");
 			dis.forward(request, response);
 			
 			//response.sendRedirect("list.jsp");  //상대 경로라서 이렇게 해도 된다.
 		}else if(uri.equals("/post/detail.do")) {
 			response.sendRedirect("/post/detail.jsp");
 		}else if(uri.equals("/post/saveForm.do")) {
 			response.sendRedirect("/post/saveForm.jsp");
 		}else if(uri.equals("/post/updateForm.do")) {
 			response.sendRedirect("/post/updateForm.jsp");
 		}else if(uri.equals("/user/joinForm.do")) {
 			response.sendRedirect("/user/joinForm.jsp");
 		}else if(uri.equals("/user/loginForm.do")) {
 			response.sendRedirect("/user/loginForm.jsp");
 		}else if(uri.equals("/user/updateForm.do")) {
 			response.sendRedirect("/user/updateForm.jsp");
 		}else if(uri.equals("/user/detailForm.do")) {
 			response.sendRedirect("/user/detailForm.jsp");
 		}
 		
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		route(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		route(request, response);
	}

}
