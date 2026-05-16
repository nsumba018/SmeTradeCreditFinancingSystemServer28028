
package rw.rab.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author nsumba
 */
@Entity
public class Investor implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investorId;
    private String fullName;
    private String phone;
    private double availableBalance;
    
    @OneToOne
    private User user;
    @ManyToMany
    @JoinTable(
    name = "investor_sector",
    joinColumns = @JoinColumn(name = "investor_id"),
    inverseJoinColumns = @JoinColumn(name = "sector_id"))
    private List<Sector> sectors;
    @OneToMany(mappedBy="investor")
    private List<Funding> fundings;

    public Investor() {
    }

    public Investor(int investorId, String fullName, String phone, double availableBalance, User user, List<Sector> sectors, List<Funding> fundings) {
        this.investorId = investorId;
        this.fullName = fullName;
        this.phone = phone;
        this.availableBalance = availableBalance;
        this.user = user;
        this.sectors = sectors;
        this.fundings = fundings;
    }

    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    public List<Funding> getFundings() {
        return fundings;
    }

    public void setFundings(List<Funding> fundings) {
        this.fundings = fundings;
    }
     
    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
    
    
}
