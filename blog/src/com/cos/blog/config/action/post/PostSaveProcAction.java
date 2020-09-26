package com.cos.blog.config.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;

public class PostSaveProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1세션확인
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("principal");   
		int userId = Integer.parseInt( request.getParameter("userId"));
		
		if(user == null) {
			return;
		}else if(user.getId() != userId) {
			return;
		}
		//2공백 null 확인
		//3값 검증
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		System.out.println("title = " + title);
		System.out.println("content = " + content);
		System.out.println("userId = " + userId);
		
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		
		Post post = new Post(title,content,0,userId);
		
		PostDao dao = new PostDao();
		int n = dao.글쓰기(post);
		
		if(n == 1) {
			response.sendRedirect("/post/list.jsp");
		}
		
	}

}
