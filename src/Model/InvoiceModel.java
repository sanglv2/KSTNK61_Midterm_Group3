/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Invoice;
import Entity.List.InvoiceList;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author User
 */
public class InvoiceModel {
    
    public static InvoiceModel INST = new InvoiceModel();
    public static Map<Integer, Invoice> MAP;
    
    private InvoiceModel() {
        warmup();
    }
    
    public List<Invoice> getListAll() {
        return new ArrayList<>(MAP.values());
    }
    
    public int addInvoice(String date, String paymentDate, int paymentMethodId, int managerId, int residentId) {
        JAXBContext jaxbContext;

        try {
            List<Invoice> listInvoice = getListAll();

            int invoiceId = MAP.keySet().stream().collect(Collectors.maxBy(Integer::compare)).orElse(0) + 1;
            Invoice invoice = new Invoice(invoiceId, date, paymentDate, paymentMethodId, managerId, residentId);
            listInvoice.add(invoice);

            InvoiceList invoiceList = new InvoiceList();
            invoiceList.setListInvoice(listInvoice);

            jaxbContext = JAXBContext.newInstance(InvoiceList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(invoiceList, new File("resource/invoice.xml"));

            return invoiceId;
        } catch (JAXBException e) {
            return 0;
        } finally {
            warmup();
        }
    }

    public boolean updateInvoice(int invoiceId, String date, String paymentDate, int paymentMethodId, int managerId, int residentId) {
        JAXBContext jaxbContext;

        try {
            Map<Integer, Invoice> map = MAP;

            if (map.containsKey(invoiceId)) {
                map.put(invoiceId, new Invoice(invoiceId, date, paymentDate, paymentMethodId, managerId, residentId));
            }

            List<Invoice> listInvoice = new ArrayList<>(map.values());

            InvoiceList serviceList = new InvoiceList();
            serviceList.setListInvoice(listInvoice);

            jaxbContext = JAXBContext.newInstance(InvoiceList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(serviceList, new File("resource/invoice.xml"));

            return true;
        } catch (JAXBException e) {
            return false;
        } finally {
            warmup();
        }
    }

    public boolean removeInvoice(int invoiceId) {
        JAXBContext jaxbContext;
        
        try {
            Map<Integer, Invoice> map = MAP;
            map.remove(invoiceId);

            List<Invoice> listInvoice = new ArrayList<>(map.values());
            
            InvoiceList serviceList = new InvoiceList();
            serviceList.setListInvoice(listInvoice);

            jaxbContext = JAXBContext.newInstance(InvoiceList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(serviceList, new File("resource/invoice.xml"));

            return true;
        } catch (JAXBException e) {
            return false;
        } finally {
            warmup();
        }
    }
    
    public boolean payInvoice(int invoiceId, int paymentMethodId) {
        Invoice invoice = MAP.get(invoiceId);
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return updateInvoice(invoiceId, invoice.getDate(), format.format(new Date()), paymentMethodId, invoice.getManagerId(), invoice.getResidentId());
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(InvoiceList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InvoiceList list = (InvoiceList) jaxbUnmarshaller.unmarshal(new File("resource/invoice.xml"));
            
            Map<Integer, Invoice> map = new HashMap<>();
            list.getListInvoice().forEach(invoice -> map.put(invoice.getInvoiceId(), invoice));
            
            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
}
