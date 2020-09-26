package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.config.action.post.PostListAction;
import com.cos.blog.config.action.post.PostSaveFormAction;
import com.cos.blog.config.action.post.PostSaveProcAction;
import com.cos.blog.config.action.user.UserJoinFormAction;
import com.cos.blog.config.action.user.UserJoinProcAction;
import com.cos.blog.config.action.user.UserLoginFormAction;
import com.cos.blog.config.action.user.UserLoginProcAction;
import com.cos.blog.config.action.user.UserLogoutAction;
import com.cos.blog.config.action.user.UserUpdateFormAction;
import com.cos.blog.config.action.user.UserUpdateProcAction;
import com.cos.blog.model.Post;

//http://localhost:8080/blog/ffidfdf.do
//모든 .do 요청은 FrontController를 탄다.
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostController() {
        super();
       
    }
    //http://localhost:8080/post/list.do
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 System.out.println("/post 요청됨");
		String cmd = request.getParameter("cmd");
		//System.out.println("cmd = " + cmd);
		 		
		Action action = route(cmd);
		if(action != null)action.execute(request, response);
   }
    
    private Action route(String cmd) {
    	if(cmd.equals("list")) {
 			return new PostListAction();
 		}else if(cmd.equals("saveForm")) {
 			return new PostSaveFormAction();
 		}else if(cmd.equals("saveProc")) {
 			return new PostSaveProcAction();
 		} 
   	 return null;
    }
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
