package com.cos.blog.config.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;

public class PostListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 0;
		if(request.getParameter("page")== null) {
			page = 0;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PostDao postDao =  PostDao.getInstance();
		List<Post> posts = postDao.글목록(page); 
		
		//SELECT count(*) FROM post;
		
		request.setAttribute("posts", posts);
		
		RequestDispatcher rd = request.getRequestDispatcher("/post/list.jsp");
		rd.forward(request, response);
		
	}

}
