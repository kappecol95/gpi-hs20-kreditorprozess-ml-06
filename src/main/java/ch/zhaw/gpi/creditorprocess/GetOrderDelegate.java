package ch.zhaw.gpi.creditorprocess;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import ch.zhaw.gpi.creditorprocess.erp.ErpService;

@Named("getOrderAdapter")
public class GetOrderDelegate implements JavaDelegate {

    @Autowired
    private ErpService erpService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        
        // «referenceNr» als Input verwendet und folgende Prozessvariablen 
        // sollen in diesem Delegate gesetzt werden: 
        // orderFound, orderNr, orderAmount, costCenterMgr, creditorOrderCount und creditorInvoiceReclamationCount.

        Long orderNumber = (Long) execution.getVariable("referenceNr");

        String orderAsJsonString = erpService.getOrder(orderNumber);
        System.out.println(orderAsJsonString);

        if ("404".equals(orderAsJsonString)) {

        execution.setVariable("orderFound", false);

        } else {

        JSONObject orderAJsonObject = new JSONObject(orderAsJsonString);

        execution.setVariable("orderFound", true);
        execution.setVariable("orderNr", orderAJsonObject.getLong("orderId"));
        execution.setVariable("orderAmount", orderAJsonObject.getLong("amount"));
        execution.setVariable("costCenterMgr", orderAJsonObject.getString("cstCtMgr"));
        execution.setVariable("creditorOrderCount", orderAJsonObject.getJSONObject("creditor").getLong("ordersCnt"));
        execution.setVariable("creditorInvoiceReclamationCount", orderAJsonObject.getJSONObject("creditor").getLong("invoicingReclamationCnt"));


        }

    }
    
}
