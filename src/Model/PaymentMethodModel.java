/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.List.PaymentMethodList;
import Entity.PaymentMethod;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author User
 */
public class PaymentMethodModel {
    
    public static PaymentMethodModel INST = new PaymentMethodModel();
    public static Map<Integer, PaymentMethod> MAP;
    
    private PaymentMethodModel() {
        warmup();
    }
    
    public List<PaymentMethod> getListAll() {
        return new ArrayList<>(MAP.values());
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(PaymentMethodList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PaymentMethodList list = (PaymentMethodList) jaxbUnmarshaller.unmarshal(new File("resource/paymentmethod.xml"));
            
            Map<Integer, PaymentMethod> map = new HashMap<>();
            list.getListPaymentMethod().forEach(paymentMethod -> map.put(paymentMethod.getPaymentMethodId(), paymentMethod));
            
            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
}
