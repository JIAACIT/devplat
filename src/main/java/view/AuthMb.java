package view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import exception.AuthenticationFailure;
import model.User;

@Named
@SessionScoped
public class AuthMb implements Serializable {
	private static final long serialVersionUID = 791515424619865689L;

	@Inject
	private UserController userCntr;

	private String username;
	private String password;

	private User currentUser;

	public boolean isLogged() {
		return currentUser != null;
	}

	public String login() throws AuthenticationFailure{
		try{
			currentUser = userCntr.getAuthUser(username, password);
			username = null;
			password = null;
			
			if(isLogged())
				return "home?faces-redirect=true";
			else 
				return null;
			}catch(Exception e){
				throw new AuthenticationFailure(e);
		}
	}

	public String logout() {
		currentUser = null;
		return "index?faces-redirect=true";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public int getCurrentUserId() {
		return currentUser.getId();
	}
	/*
	 * public User getUser() { return currentUser; }
	 * 
	 * public void setUser(User user) { this.currentUser = user; }
	 * 
	 */
}
