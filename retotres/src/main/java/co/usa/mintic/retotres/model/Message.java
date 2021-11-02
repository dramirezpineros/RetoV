package co.usa.mintic.retotres.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="message_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private audience audience;

    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private client client;

    

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

    public audience getAudience() {
        return audience;
    }

    public void setAudience(audience audience) {
        this.audience = audience;
    }

    public client getClient() {
        return client;
    }

    public void setClient(client client) {
        this.client = client;
    }

    

    
    
    
}
