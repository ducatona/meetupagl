/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "conversations")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Conversations.findAll", query = "SELECT c FROM Conversations c"),
    @javax.persistence.NamedQuery(name = "Conversations.findByIdConversation", query = "SELECT c FROM Conversations c WHERE c.idConversation = :idConversation"),
    @javax.persistence.NamedQuery(name = "Conversations.findByStartedAt", query = "SELECT c FROM Conversations c WHERE c.startedAt = :startedAt")})
public class Conversations implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_conversation")
    private Integer idConversation;
    @javax.persistence.Column(name = "started_at")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startedAt;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "idConversation")
    private Collection<Messages> messagesCollection;
    @javax.persistence.JoinColumn(name = "id_user1", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser1;
    @javax.persistence.JoinColumn(name = "id_user2", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser2;

    public Conversations() {
    }

    public Conversations(Integer idConversation) {
        this.idConversation = idConversation;
    }

    public Integer getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(Integer idConversation) {
        this.idConversation = idConversation;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Collection<Messages> getMessagesCollection() {
        return messagesCollection;
    }

    public void setMessagesCollection(Collection<Messages> messagesCollection) {
        this.messagesCollection = messagesCollection;
    }

    public Users getIdUser1() {
        return idUser1;
    }

    public void setIdUser1(Users idUser1) {
        this.idUser1 = idUser1;
    }

    public Users getIdUser2() {
        return idUser2;
    }

    public void setIdUser2(Users idUser2) {
        this.idUser2 = idUser2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConversation != null ? idConversation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversations)) {
            return false;
        }
        Conversations other = (Conversations) object;
        if ((this.idConversation == null && other.idConversation != null) || (this.idConversation != null && !this.idConversation.equals(other.idConversation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netgenius.v3_meet_up_agl.entidades.Conversations[ idConversation=" + idConversation + " ]";
    }
    
}
