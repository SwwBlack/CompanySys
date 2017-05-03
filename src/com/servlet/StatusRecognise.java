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
import com.factory.EmployeeDaoImplFactory;

/**
 * Servlet implementation class StatusRecognise
 */
@WebServlet("/StatusRecognise")
public class StatusRecognise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusRecognise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();//获得servletcontext
		RequestDispatcher dispatcher = null;
		String employeeId = request.getParameter("employeeId");
		String password = request.getParameter("password");
		if(employeeId==null||employeeId.equals("")){
			request.setAttribute("error", "请输入员工编号!");
			dispatcher = context.getRequestDispatcher("/login.jsp");//设置跳转页面
		}else{
			 if(password==null||"".equals(password)){
				 request.setAttribute("error", "系统口令未输入，请输入系统口令!");
				 dispatcher = context.getRequestDispatcher("/login.jsp");
			 }
			 else {
				Employee employee = EmployeeDaoImplFactory.getEmployeeDaoImpl().findEmployeeById(Integer.parseInt(employeeId));
				if(employee==null){
					request.setAttribute("error", "编号不存在！");
					dispatcher = context.getRequestDispatcher("/login.jsp");//设置跳转页面
				}else {
					if(!employee.getPassword().equals(password)){
						request.setAttribute("error", "系统口令错误！");
						dispatcher = context.getRequestDispatcher("/login.jsp");//设置跳转页面
					}else {
						request.getSession().setAttribute("employee",employee);
						response.sendRedirect("/company/mainpage.jsp");
					    return;
					}
				}
					
			}
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
