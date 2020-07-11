/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.List.ServiceList;
import Entity.Service;
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
public class ServiceModel {
    
    public static ServiceModel INST = new ServiceModel();
    public static Map<Integer, Service> MAP;
    
    private ServiceModel() {
        warmup();
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(ServiceList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ServiceList list = (ServiceList) jaxbUnmarshaller.unmarshal(new File("resource/service.xml"));

            Map<Integer, Service> map = new HashMap<>();
            list.getListService().forEach(service -> map.put(service.getServiceId(), service));
            
            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
    
    public List<Service> getListAll() {
        return new ArrayList<>(MAP.values());
    }
    
}
