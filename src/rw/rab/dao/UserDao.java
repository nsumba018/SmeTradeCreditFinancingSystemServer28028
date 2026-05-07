
package rw.rab.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.rab.model.User;

/**
 *
 * @author nsumba
 */
public class UserDao {
    public String createUser(User user){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(user);
        tr.commit();
        ss.close();
        return "User Saved Successfully";
    }
    
    public String updateUser(User user){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(user);
        tr.commit();
        ss.close();
        return "User Updated Successfully";
    }
    
    public String deleteUser(User user){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(user);
        tr.commit();
        ss.close();
        return "User Deleted Successfully";
    }
    
    public List<User> getAllUsers(){
         Session ss = HibernateUtil.getSessionFactory().openSession();
         List<User> usersList = ss.createQuery("select usr from User usr").list();
         ss.close();
         return usersList;
    }
    
    public User getUserById(User user){
         Session ss = HibernateUtil.getSessionFactory().openSession();
         User usr= (User)ss.get(User.class, user.getUserId());
         ss.close();
         return usr;
    }
    
    
}
