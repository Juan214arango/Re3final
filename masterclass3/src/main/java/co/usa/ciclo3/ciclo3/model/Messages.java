package co.usa.ciclo3.ciclo3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;


    @ManyToOne
    @JoinColumn(name="farmId")
    @JsonIgnoreProperties({ "messages", "reservations","client" })
    private Farms farms;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({ "messages", "reservations","client"})
    private Client client;
    

    public Integer getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public Farms getFarms() {
        return farms;
    }
    public void setFarms(Farms farms) {
        this.farms = farms;
    }  
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    } 
 
    
}