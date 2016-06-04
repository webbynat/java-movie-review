package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
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
		request.setAttribute("webview", "RegisterPage");
        RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		AccountService acc = new AccountServiceIml();
		if(acc.checkExistsUser(username) || acc.checkExistsUser(email)){
			request.setAttribute("error", "username or email is already exist");
			request.setAttribute("webview", "RegisterPage");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
			return;
		}
		String password = request.getParameter("password");
		password = Encoder.MD5(password);
		String displayName = request.getParameter("displayName");
		String phone = request.getParameter("phone");
		User user = new User(username, password, displayName, null, email, phone, null);
		
		if(acc.createUser(user)){
			request.getSession().setAttribute("username", user.getUsername());
			if (user.getDisplayName() != null){
				request.getSession().setAttribute("displayName", user.getDisplayName());
			}
			else{
				request.getSession().setAttribute("displayName", user.getUsername());
				String url = request.getContextPath();
				response.sendRedirect(url);
				return;
			}
		}
		else{
			request.setAttribute("error", "cannot create user at this time. Try later");
			request.setAttribute("webview", "RegisterPage");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
			return;
		}
	}

}
