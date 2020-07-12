/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.List.ResidentList;
import Entity.Resident;
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
public class ResidentModel {
    
    public static ResidentModel INST = new ResidentModel();
    public static Map<Integer, Resident> MAP;
    
    private ResidentModel() {
        warmup();
    }
    
    public List<Resident> getListAll() {
        return new ArrayList<>(MAP.values());
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(ResidentList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ResidentList list = (ResidentList) jaxbUnmarshaller.unmarshal(new File("resource/resident.xml"));
            
            Map<Integer, Resident> map = new HashMap<>();
            list.getListResident().forEach(resident -> map.put(resident.getResidentId(), resident));
            
            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
}
