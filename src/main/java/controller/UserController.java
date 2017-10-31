package controller;

import java.util.List;

//import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import model.User;

@Stateless
public class UserController {

	@PersistenceContext(unitName="postuser")
    private EntityManager entityMgr;

    public void create(User user)
    {
      entityMgr.persist(user);
    }
    //Lista de Usuarios
    public List<User> all()
    { 
        CriteriaQuery<User> cq = entityMgr.getCriteriaBuilder().createQuery(User.class);
        cq.select(cq.from(User.class));
        return entityMgr.createQuery(cq).getResultList();
    }
    // Retorna Usuario x ID
    public User byId(int id){
        return entityMgr.find(User.class, id);
   }
   
    // 
    public List<User> adults()
    { 
    	String hql = "Select u from User u where u.age > :age";
		TypedQuery<User> q = entityMgr.createQuery(hql,User.class);
		q.setParameter("age", 18);
        return q.getResultList();
    }
    
    // revisar metodo
	public User getAuthUser(String username, String password) {
		for(User user: all()){
			if(user.getEmail().equals(username) && (user.getPwd().equals(password))){
				return user;
			}
		}
		return null;
	}
   
}
