package view;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import model.User;

@Named
public class UserMb {

    @Inject
    private UserController userController;

    public List<User> all(){
		return userController.all();
    }

}