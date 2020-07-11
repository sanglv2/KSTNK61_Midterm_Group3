/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Common.Constants;
import Entity.List.ServiceList;
import Entity.Service;
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
public class ServiceModel {

    public static ServiceModel INST = new ServiceModel();
    public static Map<Integer, Service> MAP;

    private ServiceModel() {
        warmup();
    }

    public List<Service> getListAll() {
        return MAP.values().stream()
                .filter(service -> (service.getStatus() & Constants.SERVICE_STATUS_DELETED) == 0)
                .collect(Collectors.toList());
    }

    public int addService(String name, int price, int status) {
        JAXBContext jaxbContext;

        try {
            List<Service> listService = getListAll();

            int serviceId = MAP.keySet().stream().collect(Collectors.maxBy(Integer::compare)).orElse(0) + 1;
            Service service = new Service(serviceId, name, price, status);
            listService.add(service);

            ServiceList serviceList = new ServiceList();
            serviceList.setListService(listService);

            jaxbContext = JAXBContext.newInstance(ServiceList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(serviceList, new File("resource/service.xml"));

            return serviceId;
        } catch (JAXBException e) {
            return 0;
        } finally {
            warmup();
        }
    }

    public boolean updateService(int serviceId, String name, int price, int status) {
        JAXBContext jaxbContext;

        try {
            Map<Integer, Service> map = MAP;

            if (map.containsKey(serviceId)) {
                map.put(serviceId, new Service(serviceId, name, price, status));
            }

            List<Service> listService = new ArrayList<>(map.values());

            ServiceList serviceList = new ServiceList();
            serviceList.setListService(listService);

            jaxbContext = JAXBContext.newInstance(ServiceList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(serviceList, new File("resource/service.xml"));

            return true;
        } catch (JAXBException e) {
            return false;
        } finally {
            warmup();
        }
    }

    public boolean removeService(int serviceId) {
        Service service = MAP.get(serviceId);
        return updateService(serviceId, service.getName(), service.getPrice(), Constants.SERVICE_STATUS_DELETED);
    }

    private void warmup() {
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(ServiceList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ServiceList list = (ServiceList) jaxbUnmarshaller.unmarshal(new File("resource/service.xml"));

            Map<Integer, Service> map = new HashMap<>();
            list.getListService().forEach(service -> map.put(service.getServiceId(), service));

            MAP = map;
        } catch (JAXBException e) {
            MAP = new HashMap<>();
        }
    }
}
