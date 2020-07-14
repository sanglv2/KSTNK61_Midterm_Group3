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
@XmlRootElement(name = "Resident")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resident {
    
    @XmlElement(name = "ResidentId")
    private int residentId;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Gender")
    private int gender;
    @XmlElement(name = "DOB")
    private String dob;
    @XmlElement(name = "Phone")
    private String phone;
    @XmlElement(name = "PeopleId")
    private String peopleId;
    @XmlElement(name = "RoomId")
    private String roomId;
    @XmlElement(name = "Status")
    private int status;

    public Resident() {
    }

    public Resident(int residentId, String name, int gender, String dob, String phone, String peopleId, String roomId, int status) {
        this.residentId = residentId;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.peopleId = peopleId;
        this.roomId = roomId;
        this.status = status;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
