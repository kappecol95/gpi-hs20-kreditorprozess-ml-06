package ch.zhaw.gpi.creditorprocess.erp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne; 
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.json.JSONPropertyIgnore;

@Entity
public class Invoice {

    //INVOICE_ID, DATE_DUE, INVOICE_AMOUNT, DATE_OF_INVOICE, CREDITOR_CREDITOR_ID

    @Id
    private Long invoiceId;
    @Temporal(TemporalType.DATE)
    private Date dateDue; 
    private Long invoiceAmount;
    @Temporal(TemporalType.DATE)
    private Date dateOfInvoice;

    @OneToOne (mappedBy = "invoice")
    private Order order; 

    @ManyToOne
    private Creditor creditor;

    @JSONPropertyIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public Long getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Long invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Date getDateOfInvoice() {
        return dateOfInvoice;
    }

    public void setDateOfInvoice(Date dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
    }

    public Creditor getCreditor() {
        return creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

	


    
}
