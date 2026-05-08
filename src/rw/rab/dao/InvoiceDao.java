
package rw.rab.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.rab.model.Invoice;

/**
 *
 * @author nsumba
 */
public class InvoiceDao {
    public String createInvoice(Invoice invoice){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(invoice);
        tr.commit();
        ss.close();
        return "Invoice Saved Successfully";
    }
    
    public String updateInvoice(Invoice invoice){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(invoice);
        tr.commit();
        ss.close();
        return "Invoice Updated Successfully";
    }
    
    public String deleteInvoice(Invoice invoice){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(invoice);
        tr.commit();
        ss.close();
        return "Invoice Deleted Successfully";
    }
    
    public List<Invoice> getAllInvoices(){
         Session ss = HibernateUtil.getSessionFactory().openSession();
         List<Invoice> invoicesList = ss.createQuery("select invc from Invoice invc").list();
         ss.close();
         return invoicesList;
    }
    
    public Invoice getInvoiceById(Invoice invoice){
         Session ss = HibernateUtil.getSessionFactory().openSession();
         Invoice invc= (Invoice)ss.get(Invoice.class, invoice.getInvoiceId());
         ss.close();
         return invc;
    }
    
    
}
