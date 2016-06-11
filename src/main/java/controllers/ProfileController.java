package controllers;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * Servlet implementation class ProfileController
 */

public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username != null && !username.equals("")){
			AccountService as = new AccountServiceIml();
			User user = as.getUser(username);
			
			if(user != null){
				request.setAttribute("user", user);
				request.setAttribute("webview", "ProfilePage");
				RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
			}
			else{
				request.setAttribute("webview", "403Page");
				RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
			}
		}
		else{
			request.setAttribute("webview", "403Page");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username != null && !username.equals("")){
			String password = request.getParameter("password");
			String oldPassword = request.getParameter("old-password");
			String fullname = request.getParameter("display-name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			AccountService as = new AccountServiceIml();
			User user = as.getUser(username);
			
			if(!password.equals("888888888888888")){
				oldPassword = Encoder.MD5(oldPassword);
				boolean res = as.authenticationUser(username, oldPassword);
				if(res){
					as.changePassword(username,Encoder.MD5(password));
				}
				else{
					request.setAttribute("webview", "403Page");
					RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
					return;
				}
			}
					
			User updatedUser = new User(username,password,fullname ,false, email, phone,
					null);
			
			boolean res = as.updateUserInformation(updatedUser);
			if(res){
				request.setAttribute("ProfileSuccess", "Update successful !!!");
			}
			else{
				request.setAttribute("ProfileError", "Update failed !!!");
			}
			request.setAttribute("webview", "ProfilePage");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
		}
		else{
			request.setAttribute("webview", "403Page");
			RequestForward.forward(request, response, "/WEB-INF/views/pages/webview.jsp");
		}
	}

}
