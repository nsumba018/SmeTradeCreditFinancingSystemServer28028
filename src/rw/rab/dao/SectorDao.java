
package rw.rab.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import rw.rab.model.Sector;

/**
 *
 * @author nsumba
 */
public class SectorDao {
    public String createSector(Sector sector){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.save(sector);
        tr.commit();
        ss.close();
        return "Sector Saved Successfully";
    }
    
    public String updateSector(Sector sector){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.update(sector);
        tr.commit();
        ss.close();
        return "Sector Updated Successfully";
    }
    
    public String deleteSector(Sector sector){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = ss.beginTransaction();
        ss.delete(sector);
        tr.commit();
        ss.close();
        return "Sector Deleted Successfully";
    }
    
    public List<Sector> getAllSectors(){
         Session ss = HibernateUtil.getSessionFactory().openSession();
         List<Sector> sectorsList = ss.createQuery("select sec from Sector sec").list();
         ss.close();
         return sectorsList;
    }
    
    public Sector getSectorById(Sector sector){
         Session ss = HibernateUtil.getSessionFactory().openSession();
         Sector sec= (Sector)ss.get(Sector.class, sector.getSectoId());
         ss.close();
         return sec;
    }
    
    
}
