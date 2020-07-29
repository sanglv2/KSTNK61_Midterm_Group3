/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement(name = "InvoiceDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceDetail {
    
    @XmlElement(name = "InvoiceDetailId")
    private int invoiceDetailId;
    @XmlElement(name = "InvoiceId")
    private int invoiceId;
    @XmlElement(name = "ServiceId")
    private int serviceId;
    @XmlElement(name = "Quantity")
    private int quantity;
    @XmlElement(name = "Price")
    private int price;
    
    public InvoiceDetail() {
    }

    public InvoiceDetail(int invoiceDetailId, int invoiceId, int serviceId, int quantity, int price) {
        this.invoiceDetailId = invoiceDetailId;
        this.invoiceId = invoiceId;
        this.serviceId = serviceId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(int invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
