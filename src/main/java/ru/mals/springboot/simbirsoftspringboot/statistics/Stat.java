package ru.mals.springboot.simbirsoftspringboot.statistics;

import org.springframework.stereotype.Component;
import ru.mals.springboot.simbirsoftspringboot.entity.RequestUrlAddress;
import java.util.*;

@Component
public class Stat {
    Date nowDate = new Date();
    List<RequestUrlAddress> requestUrlAddressList = new ArrayList<>();

    public void newSeance (RequestUrlAddress requestUrlAddress) {
        requestUrlAddress.setTimeDate(nowDate.toString());
        requestUrlAddressList.add(requestUrlAddress);
    }
    public RequestUrlAddress getLastSeance () {
        System.out.println(requestUrlAddressList.size()-1);
        return requestUrlAddressList.get(requestUrlAddressList.size()-1);
    }
    public List<RequestUrlAddress> gerAllSeance() {
        return requestUrlAddressList;
    }
}
