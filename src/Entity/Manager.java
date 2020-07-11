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
@XmlRootElement(name = "Manager")
@XmlAccessorType(XmlAccessType.FIELD)
public class Manager {

    @XmlElement(name = "ManagerId")
    private int managerId;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "DOB")
    private String dob;
    @XmlElement(name = "Gender")
    private boolean gender;
    @XmlElement(name = "Phone")
    private String phone;
    @XmlElement(name = "Address")
    private String address;
    @XmlElement(name = "Username")
    private String username;
    @XmlElement(name = "Password")
    private String password;

    public Manager() {
    }

    public Manager(int managerId, String name, String dob, boolean gender, String phone, String address, String username, String password) {
        this.managerId = managerId;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
