package view;
import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import model.User;
@Named
public class CreateUserMb {

    @Inject
    private UserController userController;

    private User user = new User();
   
    
    public String create(){
    	System.out.println("USUARIO: " + user.toString());
    	userController.create(user);
    	return "index";
    	
    	//mensaje "Usuario creado con exito
    }
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}