
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
public class ManagerModel {
    
    public static ManagerModel INST = new ManagerModel();
    public static Map<Integer, Manager> MAP;
    
    private ManagerModel() {
        warmup();
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(ManagerList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ManagerList list = (ManagerList) jaxbUnmarshaller.unmarshal(new File("resource/manager.xml"));
            
            Map<Integer, Manager> map = new HashMap<>();
            list.getListManager().forEach(manager -> map.put(manager.getManagerId(), manager));
            
            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
    
    public List<Manager> getListAll() {
        return new ArrayList<>(MAP.values());
    }
    
}
