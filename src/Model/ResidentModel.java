/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Common.Constants;
import Entity.List.ResidentList;
import Entity.Resident;
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
public class ResidentModel {
    
    public static ResidentModel INST = new ResidentModel();
    public static Map<Integer, Resident> MAP;
    
    private ResidentModel() {
        warmup();
    }
    
    public List<Resident> getListAll() {
        return MAP.values().stream()
                .filter(resident -> (resident.getStatus() & Constants.RESIDENT_STATUS_NOTLIVE) == 0)
                .collect(Collectors.toList());
    }
    
    public int addResident(String name, int gender, String dob, String phone, String peopleId, String roomId) {
        JAXBContext jaxbContext;

        try {
            List<Resident> listResident = getListAll();

            int residentId = MAP.keySet().stream().collect(Collectors.maxBy(Integer::compare)).orElse(0) + 1;
            Resident resident = new Resident(residentId, name, gender, dob, phone, peopleId, roomId, Constants.RESIDENT_STATUS_LIVE);
            listResident.add(resident);

            ResidentList residentList = new ResidentList();
            residentList.setListResident(listResident);

            jaxbContext = JAXBContext.newInstance(ResidentList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(residentList, new File("resource/resident.xml"));

            return residentId;
        } catch (JAXBException e) {
            return 0;
        } finally {
            warmup();
        }
    }

    public boolean updateResident(int residentId, String name, int gender, String dob, String phone, String peopleId, String roomId, int status) {
        JAXBContext jaxbContext;

        try {
            Map<Integer, Resident> map = MAP;

            if (map.containsKey(residentId)) {
                map.put(residentId, new Resident(residentId, name, gender, dob, phone, peopleId, roomId, status));
            }

            List<Resident> listResident = new ArrayList<>(map.values());

            ResidentList residentList = new ResidentList();
            residentList.setListResident(listResident);

            jaxbContext = JAXBContext.newInstance(ResidentList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(residentList, new File("resource/resident.xml"));

            return true;
        } catch (JAXBException e) {
            return false;
        } finally {
            warmup();
        }
    }

    public boolean removeResident(int residentId) {
        Resident resident = MAP.get(residentId);
        return updateResident(residentId, resident.getName(), resident.getGender(), resident.getDob(), resident.getPhone(), resident.getPeopleId(), resident.getRoomId(), Constants.RESIDENT_STATUS_NOTLIVE);
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
