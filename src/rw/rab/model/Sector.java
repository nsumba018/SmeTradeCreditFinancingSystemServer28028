
package rw.rab.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author nsumba
 */
@Entity
public class Sector implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int sectoId;
    private String sectorName;
    private String description;
    
    @ManyToMany(mappedBy="sectors")
    private List<Investor> investors;
    
    
    public Sector() {
    }

    public Sector(int sectoId, String sectorName, String description, List<Investor> investors) {
        this.sectoId = sectoId;
        this.sectorName = sectorName;
        this.description = description;
        this.investors = investors;
    }

    public List<Investor> getInvestors() {
        return investors;
    }

    public void setInvestors(List<Investor> investors) {
        this.investors = investors;
    }
    

    public int getSectoId() {
        return sectoId;
    }

    public void setSectoId(int sectoId) {
        this.sectoId = sectoId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
