package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.bean.Message;
import com.factory.MessageDaoImplFactory;

/**
 * Servlet implementation class PublishNewMsg
 */
@WebServlet("/PublishNewMsg")
public class PublishNewMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishNewMsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String title = (String) request.getParameter("title");
		String content = (String) request.getParameter("content");
		System.out.println(title);
		System.out.println(content);
		System.out.println(request.getCharacterEncoding());
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = null;
		Message message = new Message();
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee==null){
			request.setAttribute("error", "需要登陆才能发布消息！");
		    dispatcher = context.getRequestDispatcher("/publishNewMeg.jsp");  
		}else {
			if(title==null||title.equals("")){
				request.setAttribute("error", "消息标题不能为空！");
				dispatcher = context.getRequestDispatcher("/publishNewMeg.jsp");
			}else{
				message.setEmployeeId(employee.getEmployeeId());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				message.setPublishTime(new java.sql.Date(System.currentTimeMillis()));
				MessageDaoImplFactory.getMessageDaoImpl().addNewMsg(message);
				request.setAttribute("message",message);
				response.sendRedirect("/company/publishMegSuccess.jsp");
				return;
			}
		}
		dispatcher.forward(request, response);
	}

}
