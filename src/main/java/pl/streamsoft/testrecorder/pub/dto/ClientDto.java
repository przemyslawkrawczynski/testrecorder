package pl.streamsoft.testrecorder.pub.dto;

import java.io.Serializable;

public class ClientDto implements Serializable {

    private Long id;
    private String clientName;
    private String mail;
    private Long pesel;
    private Long phoneNumber;
    private String decision;

    public ClientDto() {}

    public ClientDto(Long id, String clientName, String mail, Long pesel, Long phoneNumber, String decision) {
        this.clientName = clientName;
        this.mail = mail;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.decision = decision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "clientName='" + clientName + '\'' +
                ", mail='" + mail + '\'' +
                ", pesel=" + pesel +
                ", phoneNumber=" + phoneNumber +
                ", decision='" + decision + '\'' +
                '}';
    }
}
