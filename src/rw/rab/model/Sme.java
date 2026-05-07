
package rw.rab.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author nsumba
 */
@Entity
public class Sme implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int smeId;
    private String businessName;
    private String registrationNumber;
    private String phone;
    private double creditLimit;
    @OneToOne
    private User user;
    @OneToMany(mappedBy="sme")
    private List<Invoice> invoices;

    public Sme() {
    }

    public Sme(int smeId, String businessName, String registrationNumber, String phone, double creditLimit, User user, List<Invoice> invoices) {
        this.smeId = smeId;
        this.businessName = businessName;
        this.registrationNumber = registrationNumber;
        this.phone = phone;
        this.creditLimit = creditLimit;
        this.user = user;
        this.invoices = invoices;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }


    public int getSmeId() {
        return smeId;
    }

    public void setSmeId(int smeId) {
        this.smeId = smeId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    
    
}
