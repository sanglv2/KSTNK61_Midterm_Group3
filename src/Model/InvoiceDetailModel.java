/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.InvoiceDetail;
import Entity.List.InvoiceDetailList;
import java.io.File;
import java.util.ArrayList;
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
public class InvoiceDetailModel {
    
    public static InvoiceDetailModel INST = new InvoiceDetailModel();
    public static Map<Integer, InvoiceDetail> MAP;
    
    private InvoiceDetailModel() {
        warmup();
    }
    
    public List<InvoiceDetail> getListAll() {
        return new ArrayList<>(MAP.values());
    }
    
    public int addService(int invoiceId, int serviceId, int quantity, int price) {
        JAXBContext jaxbContext;

        try {
            List<InvoiceDetail> listInvoiceDetail = getListAll();

            int invoiceDetailId = MAP.keySet().stream().collect(Collectors.maxBy(Integer::compare)).orElse(0) + 1;
            InvoiceDetail invoiceDetail = new InvoiceDetail(invoiceDetailId, invoiceId, serviceId, quantity, price);
            listInvoiceDetail.add(invoiceDetail);

            InvoiceDetailList invoiceDetailList = new InvoiceDetailList();
            invoiceDetailList.setListInvoiceDetail(listInvoiceDetail);

            jaxbContext = JAXBContext.newInstance(InvoiceDetailList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(invoiceDetailList, new File("resource/invoicedetail.xml"));

            return invoiceDetailId;
        } catch (JAXBException e) {
            return 0;
        } finally {
            warmup();
        }
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(InvoiceDetailList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            InvoiceDetailList list = (InvoiceDetailList) jaxbUnmarshaller.unmarshal(new File("resource/invoicedetail.xml"));
            
            Map<Integer, InvoiceDetail> map = new HashMap<>();
            list.getListInvoiceDetail().forEach(invoiceDetail -> map.put(invoiceDetail.getInvoiceDetailId(), invoiceDetail));
            
            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
    
}
