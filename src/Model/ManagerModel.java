
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.List.ManagerList;
import Entity.Manager;
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
public class ManagerModel {
    
    private List<Manager> listManager;
    
    public static ManagerModel INST = new ManagerModel();
    
    private ManagerModel() {
        warmup();
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(ManagerList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ManagerList list = (ManagerList) jaxbUnmarshaller.unmarshal(new File("resource/manager.xml"));

            this.listManager = list.getListManager();
        } catch (JAXBException e) {
            this.listManager = new ArrayList<>();
        }
    }
    
    public List<Manager> getListAll() {
        return this.listManager;
    }
    
}
