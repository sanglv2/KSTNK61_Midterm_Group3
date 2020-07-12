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
@XmlRootElement(name = "PaymentMethod")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethod {
    
    @XmlElement(name = "PaymentMethodId")
    private int paymentMethodId;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Status")
    private int status;

    public PaymentMethod() {
    }

    public PaymentMethod(int paymentMethodId, String name, int status) {
        this.paymentMethodId = paymentMethodId;
        this.name = name;
        this.status = status;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
