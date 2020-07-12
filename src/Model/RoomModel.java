/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.List.RoomList;
import Entity.Room;
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
public class RoomModel {
    
    public static RoomModel INST = new RoomModel();
    public static Map<String, Room> MAP;
    
    private RoomModel() {
        warmup();
    }
    
    public List<Room> getListAll() {
        return new ArrayList<>(MAP.values());
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(RoomList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            RoomList list = (RoomList) jaxbUnmarshaller.unmarshal(new File("resource/room.xml"));
            
            Map<String, Room> map = new HashMap<>();
            list.getListRoom().forEach(room -> map.put(room.getRoomId(), room));
            
            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
    
    public static void main(String[] args) {
        List<Room> listAll = INST.getListAll();
    }
}
