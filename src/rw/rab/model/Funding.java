
package rw.rab.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author nsumba
 */
@Entity
public class Funding implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fundingId;
    private double fundedAmount;
    private Date fundedDate;
    
    @ManyToOne
    private Invoice invoice;
    @ManyToOne
    private Investor investor;

    public Funding() {
    }

    public Funding(int fundingId, double fundedAmount, Date fundedDate, Invoice invoice, Investor investor) {
        this.fundingId = fundingId;
        this.fundedAmount = fundedAmount;
        this.fundedDate = fundedDate;
        this.invoice = invoice;
        this.investor = investor;
    }

    

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
    

    public int getFundingId() {
        return fundingId;
    }

    public void setFundingId(int fundingId) {
        this.fundingId = fundingId;
    }

    public double getFundedAmount() {
        return fundedAmount;
    }

    public void setFundedAmount(double fundedAmount) {
        this.fundedAmount = fundedAmount;
    }

    public Date getFundedDate() {
        return fundedDate;
    }

    public void setFundedDate(Date fundedDate) {
        this.fundedDate = fundedDate;
    }
    
    
    
}
