package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.pojo.User;
import services.iml.AccountServiceIml;
import services.itf.AccountService;
import utilities.Encoder;
import utilities.RequestForward;

/**
 * Servlet implementation class UserController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("webview", "LoginPage");
        RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		password = Encoder.MD5(password);
		AccountService as = new AccountServiceIml();
		if(as.authenticationUser(username, password)){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			User user = as.getUser(username);
			if(!user.getDisplayName().equals("")){
				session.setAttribute("displayname", user.getDisplayName());
			}
			else{
				session.setAttribute("displayname", username);
			}
			response.sendRedirect(request.getContextPath() + "/");
		}
		else{
			request.setAttribute("webview", "LoginPage");
			request.setAttribute("LoginError", "Login failed !!!");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
		}
	}

}
