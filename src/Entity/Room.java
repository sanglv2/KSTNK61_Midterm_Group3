/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement(name = "Room")
@XmlAccessorType(XmlAccessType.FIELD)
public class Room {
    
    @XmlElement(name = "RoomId")
    private String roomId;
    @XmlElement(name = "Description")
    private String description;

    public Room() {
    }

    public Room(String roomId, String description) {
        this.roomId = roomId;
        this.description = description;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.roomId;
    }
}
