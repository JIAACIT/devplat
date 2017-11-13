package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Post;
import model.User;

@Stateless
public class PostController {

	@PersistenceContext(unitName = "postuser")
	private EntityManager entityManager;


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

	}

	public List<Post> all(int from, int max) {
		TypedQuery<Post> q = entityManager.createQuery("Select p from Post p", Post.class);
		q.setFirstResult(from);
		q.setMaxResults(max);
		return q.getResultList();
	}

}
