package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Post;
import model.User;
import view.AuthMb;


@Stateless
public class PostController {

	@PersistenceContext(unitName="postuser")
	private EntityManager entityManager;
	
	@Inject
	private AuthMb authMb;
	
	
	public void createPost(String title, String content, User user) {
		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post.setDate(new Date());
		post.setUser(user);
		entityManager.persist(post);
	}
	
	public List<Post> getUserPosts(int userId) {
		User u = entityManager.find(User.class, userId);
				
		TypedQuery<Post> q = entityManager.createQuery("select p from Post p where p.user = :u", Post.class);
		q.setParameter("u", u);
		return q.getResultList();
		
		/*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Post> cq = entityManager.getCriteriaBuilder().createQuery(Post.class);
		Root<Post> p = cq.from(Post.class);
		cq.select(cq.from(Post.class)).where(cb.equal(p.get("user"), u));
		return entityManager.createQuery(cq).getResultList();*/
	}
/*	
	public List<Post> getAllPosts() {
		Post p = new Post();
		entityManager.
		User u = entityManager.find(User.class, userId);
		return
	}
*/
	
	
/*	protected List<Post> userPostsList = new ArrayList<>();
	
	public void createPost(Post post){
		post.setId(db.nextPostId());
		post.setusrId(authMb.getCurrentUserId());
		db.posts.add(post);
	}
	public List<Post> getUserPost(int userId){
		List<Post> postList = db.getPosts();
		
		userPostsList.clear();
		for(Post post : postList){
			
			if(post.getusrId() == userId){
				this.userPostsList.add(post);
			}
		} 
		return userPostsList;
	}*/
	
}
