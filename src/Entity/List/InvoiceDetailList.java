/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.List;

import Entity.Invoice;
import Entity.InvoiceDetail;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement(name = "InvoiceDetailList")
@XmlAccessorType (XmlAccessType.FIELD)
public class InvoiceDetailList {
    
    @XmlElement(name = "Invoice")
    private List<InvoiceDetail> listInvoiceDetail;
    
    public InvoiceDetailList() {
        listInvoiceDetail = new ArrayList<>();
    }

    public List<InvoiceDetail> getListInvoiceDetail() {
        return listInvoiceDetail;
    }

    public void setListInvoiceDetail(List<InvoiceDetail> listInvoiceDetail) {
        this.listInvoiceDetail = listInvoiceDetail;
    }
}
