/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "messages")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @javax.persistence.NamedQuery(name = "Messages.findByIdMessage", query = "SELECT m FROM Messages m WHERE m.idMessage = :idMessage"),
    @javax.persistence.NamedQuery(name = "Messages.findByTimestamp", query = "SELECT m FROM Messages m WHERE m.timestamp = :timestamp")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_message")
    private Integer idMessage;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Lob
    @javax.persistence.Column(name = "content")
    private String content;
    @javax.persistence.Column(name = "timestamp")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timestamp;
    @javax.persistence.JoinColumn(name = "id_conversation", referencedColumnName = "id_conversation")
    @javax.persistence.ManyToOne(optional = false)
    private Conversations idConversation;
    @javax.persistence.JoinColumn(name = "id_sender", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idSender;

    public Messages() {
    }

    public Messages(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Messages(Integer idMessage, String content) {
        this.idMessage = idMessage;
        this.content = content;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Conversations getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(Conversations idConversation) {
        this.idConversation = idConversation;
    }

    public Users getIdSender() {
        return idSender;
    }

    public void setIdSender(Users idSender) {
        this.idSender = idSender;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netgenius.v3_meet_up_agl.entidades.Messages[ idMessage=" + idMessage + " ]";
    }
    
}
