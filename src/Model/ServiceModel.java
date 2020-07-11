/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.List.ManagerList;
import Entity.List.ServiceList;
import Entity.Manager;
import Entity.Service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author User
 */
public class ServiceModel {
    
    private List<Service> listService;
    
    public static ServiceModel INST = new ServiceModel();
    
    private ServiceModel() {
        warmup();
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(ServiceList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ServiceList list = (ServiceList) jaxbUnmarshaller.unmarshal(new File("resource/service.xml"));

            this.listService = list.getListService();
        } catch (JAXBException e) {
            this.listService = new ArrayList<>();
        }
    }
    
    public List<Service> getListAll() {
        return this.listService;
    }
    
}
