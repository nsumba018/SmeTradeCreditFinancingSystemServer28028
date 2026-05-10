
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
    
    public User login(User user){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        User result = (User)ss.createQuery("select u from User u where u.username= :uname and u.password = :pwd")
        .setParameter("unmae", user.getUsername())
        .setParameter("pwd", user.getPassword())
        .uniqueResult();
        ss.close();
        return result;
    }
    
    public String verifyOtp(User user, String enteredOtp) {
    Session ss = HibernateUtil.getSessionFactory().openSession();
    User u = (User) ss.get(User.class, user.getUserId());
    ss.close();

    if (u == null) return "User not found";

    // Check expiry
    if (u.getOtpExpiry() == null || 
        new java.util.Date().after(u.getOtpExpiry())) {
        return "OTP has expired. Please request a new one";
    }

    // Check code
    if (u.getOtpCode().equals(enteredOtp)) {
        // Clear OTP after successful verification
        Session ss2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss2.beginTransaction();
        u.setOtpCode(null);
        u.setOtpExpiry(null);
        ss2.update(u);
        tr.commit();
        ss2.close();
        return "SUCCESS";
    } else {
        return "Invalid OTP code. Please try again";
    }
}

public String resendOtp(User user) {
    // Generate new OTP
    String newOtp = String.valueOf(
        (int)(Math.random() * 900000) + 100000
    );

    // Set expiry 5 minutes from now
    java.util.Date expiry = new java.util.Date(
        System.currentTimeMillis() + 5 * 60 * 1000
    );

    Session ss = HibernateUtil.getSessionFactory().openSession();
    Transaction tr = ss.beginTransaction();
    User u = (User) ss.get(User.class, user.getUserId());
    u.setOtpCode(newOtp);
    u.setOtpExpiry(expiry);
    ss.update(u);
    tr.commit();
    ss.close();

    // TODO: send email — we add JavaMail next
    System.out.println("OTP for " + u.getEmail() + ": " + newOtp);

    return "New OTP sent to " + u.getEmail();
}
    
    
}
