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
@javax.persistence.Table(name = "notifications")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Notifications.findAll", query = "SELECT n FROM Notifications n"),
    @javax.persistence.NamedQuery(name = "Notifications.findByIdNotification", query = "SELECT n FROM Notifications n WHERE n.idNotification = :idNotification"),
    @javax.persistence.NamedQuery(name = "Notifications.findByLeido", query = "SELECT n FROM Notifications n WHERE n.leido = :leido"),
    @javax.persistence.NamedQuery(name = "Notifications.findByTimestamp", query = "SELECT n FROM Notifications n WHERE n.timestamp = :timestamp")})
public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_notification")
    private Integer idNotification;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Lob
    @javax.persistence.Column(name = "message")
    private String message;
    @javax.persistence.Column(name = "leido")
    private Boolean leido;
    @javax.persistence.Column(name = "timestamp")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date timestamp;
    @javax.persistence.JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser;

    public Notifications() {
    }

    public Notifications(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Notifications(Integer idNotification, String message) {
        this.idNotification = idNotification;
        this.message = message;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notifications)) {
            return false;
        }
        Notifications other = (Notifications) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netgenius.v3_meet_up_agl.entidades.Notifications[ idNotification=" + idNotification + " ]";
    }
    
}
