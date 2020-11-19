package ch.zhaw.gpi.creditorprocess.erp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Creditor {
    //CREDITOR_ID, INVOICING_RECLAMATION_CNT, CR_NAME, ORDERS_CNT
    
    @Id
    private String creditorId;  // oder referenceNr
    private Long invoicingReclamationCnt;
    private String crName;
    private Long ordersCnt;

    public String getCreditorId() {
        return creditorId;
    }

    public void setCreditorId(String creditorId) {
        this.creditorId = creditorId;
    }



    public String getCrName() {
        return crName;
    }

    public void setCrName(String crName) {
        this.crName = crName;
    }

    public Long getOrdersCnt() {
        return ordersCnt;
    }

    public void setOrdersCnt(Long ordersCnt) {
        this.ordersCnt = ordersCnt;
    }

    public Long getInvoicingReclamationCnt() {
        return invoicingReclamationCnt;
    }

    public void setInvoicingReclamationCnt(Long invoicingReclamationCnt) {
        this.invoicingReclamationCnt = invoicingReclamationCnt;
    }

    

    
    


}
