package view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import model.Post;
	
@Named
	public class PostMb {

		@Inject
		private PostController postCntr;
		
		@Inject
		private AuthMb authMb;
		
		private String title;
		private String content;
		
		
		public String create(){
			postCntr.createPost(title, content, authMb.getCurrentUser());
			return "home";
		}
		
		public List<Post> listPostUser(){
			return postCntr.getUserPosts(authMb.getCurrentUserId());
		}
		public List<Post> getAllPost(){
			try{
				return postCntr.all(0, 10);
			} catch (Exception e){
				e.printStackTrace();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error interno", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}
	}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}	

	}
