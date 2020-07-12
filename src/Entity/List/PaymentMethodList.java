/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.List;

import Entity.PaymentMethod;
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
@XmlRootElement(name = "PaymentMethodList")
@XmlAccessorType (XmlAccessType.FIELD)
public class PaymentMethodList {
    @XmlElement(name = "PaymentMethod")
    private List<PaymentMethod> listPaymentMethod;

    public PaymentMethodList() {
        listPaymentMethod = new ArrayList<>();
    }

    public List<PaymentMethod> getListPaymentMethod() {
        return listPaymentMethod;
    }

    public void setListPaymentMethod(List<PaymentMethod> listPaymentMethod) {
        this.listPaymentMethod = listPaymentMethod;
    }
}
