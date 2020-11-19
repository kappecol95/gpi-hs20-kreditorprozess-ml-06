package ch.zhaw.gpi.creditorprocess.erp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne; 

@Entity(name = "OrderTable")
public class Order {

    //ORDER_ID, CST_CT_MGR, AMOUNT, REFERENCE_NUMBER, CREDITOR_CREDITOR_ID, INVOICE_INVOICE_ID

    @Id
    private Long orderId; 
    private String cstCtMgr;
    private Long amount; 
    private Long referenceNumber;
    // private long referenceNumber;     

    @OneToOne (cascade = CascadeType.ALL)
    private Invoice invoice; 

    @ManyToOne
    private Creditor creditor;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCstCtMgr() {
        return cstCtMgr;
    }

    public void setCstCtMgr(String cstCtMgr) {
        this.cstCtMgr = cstCtMgr;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }


    

    


    
}
