/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity.List;

import Entity.Manager;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement(name = "ManagerList")
@XmlAccessorType (XmlAccessType.FIELD)
public class ManagerList {
    @XmlElement(name = "Manager")
    private List<Manager> listManager = null;

    public ManagerList() {
    }

    public List<Manager> getListManager() {
        return listManager;
    }

    public void setListManager(List<Manager> listManager) {
        this.listManager = listManager;
    }
}

