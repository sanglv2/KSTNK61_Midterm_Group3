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
@XmlRootElement(name = "Invoice")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {
    
    @XmlElement(name = "InvoiceId")
    private int invoiceId;
    @XmlElement(name = "Date")
    private String date;
    @XmlElement(name = "PaymentDate")
    private String paymentDate;
    @XmlElement(name = "PaymentMethodId")
    private int paymentMethodId;
    @XmlElement(name = "ManagerId")
    private int managerId;
    @XmlElement(name = "ResidentId")
    private int residentId;

    public Invoice() {
    }

    public Invoice(int invoiceId, String date, String paymentDate, int paymentMethodId, int managerId, int residentId) {
        this.invoiceId = invoiceId;
        this.date = date;
        this.paymentDate = paymentDate;
        this.paymentMethodId = paymentMethodId;
        this.managerId = managerId;
        this.residentId = residentId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }
}
