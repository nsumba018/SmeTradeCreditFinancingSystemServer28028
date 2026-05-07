
package rw.rab.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author nsumba
 */
@Entity
public class Invoice implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    private String invoiceNumber;
    private double amount;
    private String status;
    private Date issueDate;
    private Date dueDate;
    @ManyToOne
    private Sme sme;
    @OneToMany(mappedBy="invoice")
    private List<Funding> fundings;

    public Invoice() {
    }

    public Invoice(int invoiceId, String invoiceNumber, double amount, String status, Date issueDate, Date dueDate, Sme sme, List<Funding> fundings) {
        this.invoiceId = invoiceId;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.status = status;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.sme = sme;
        this.fundings = fundings;
    }

    
    

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Sme getSme() {
        return sme;
    }

    public void setSme(Sme sme) {
        this.sme = sme;
    }

    public List<Funding> getFundings() {
        return fundings;
    }

    public void setFundings(List<Funding> fundings) {
        this.fundings = fundings;
    }
    
    

    public int getInvoiveId() {
        return invoiceId;
    }

    public void setInvoiveId(int invoiveId) {
        this.invoiceId = invoiveId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    
}
