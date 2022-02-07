package ru.mals.springboot.simbirsoftspringboot.entity;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class RequestUrlAddress {

    private long id;

    @NotEmpty (message = "Это поле не может быть пустым!")
    private String address;

    @NotEmpty(message = "И это поле не может быть пустым!")
    @Size(min = 2, max = 20, message = "Это поле должно содержать от 2-х до 20-ти символов!")
    private String userName;
    private String timeDate;

    public long getId () {
        return id;
    }
    public void setId (long id) {
        this.id=id;
    }
    public String getAddress () {
        return address;
    }
    public void setAddress (String address) {
        this.address=address;
    }

    public String getUserName () {
        return userName;
    }
    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getTimeDate () {
        return timeDate;
    }
    public void setTimeDate (String timeDate) {
        this.timeDate = timeDate;
    }
}
