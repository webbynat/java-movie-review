package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.pojo.User;
import services.iml.AccountServiceIml;
import services.itf.AccountService;
import utilities.Encoder;
import utilities.RequestForward;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("webview", "RegisterPage");
        RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("display-name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		password = Encoder.MD5(password);
		User user = new User(username, password, fullname ,null, email, phone, null);
		AccountService as = new AccountServiceIml();
		boolean res = as.createUser(user);
		
		if(res == true) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		else{
			request.setAttribute("webview", "RegisterPage");
			request.setAttribute("RegisterError", "Register failed !!!");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
		}
	}

}
