package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.pojo.User;
import services.iml.AccountServiceIml;
import services.itf.AccountService;
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
		request.setAttribute("webview", "LoginPage");
        RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("username");
		String password = request.getParameter("password");
		AccountService acc = new AccountServiceIml();
		if (acc.authenticationUser(userID, password)){
			User user = acc.getUser(userID);
			request.getSession().setAttribute("username", user.getUsername());
			if (user.getDisplayName() != null)
				request.getSession().setAttribute("displayName", user.getDisplayName());
			else
				request.getSession().setAttribute("displayName", user.getUsername());
			String url = request.getContextPath();
			response.sendRedirect(url);
			return;
		}
		else{
			request.setAttribute("error", "Password is incorrect");
			request.setAttribute("webview", "LoginPage");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
			return;
		}
	}

}
