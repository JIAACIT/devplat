package view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import exception.ParentalException;

import controller.UserController;
import model.User;

@Named
public class CreateUserMb {

	@Inject
	private UserController userController;

	private User user = new User();

	public String create() throws ParentalException {
		// System.out.println("USUARIO: " + user.toString());
		try {
			if (user.getAge() < 18) {
				throw new ParentalException("Error");
			} else {
				userController.create(user);
				user = null;
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario registrado con exito", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "login?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;

		}

		// mensaje "Usuario creado con exito
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}