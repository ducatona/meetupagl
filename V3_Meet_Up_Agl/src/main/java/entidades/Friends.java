/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "friends")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Friends.findAll", query = "SELECT f FROM Friends f"),
    @javax.persistence.NamedQuery(name = "Friends.findByIdFriendship", query = "SELECT f FROM Friends f WHERE f.idFriendship = :idFriendship"),
    @javax.persistence.NamedQuery(name = "Friends.findByStatus", query = "SELECT f FROM Friends f WHERE f.status = :status")})
public class Friends implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_friendship")
    private Integer idFriendship;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "status")
    private String status;
    @javax.persistence.JoinColumn(name = "id_user1", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser1;
    @javax.persistence.JoinColumn(name = "id_user2", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser2;

    public Friends() {
    }

    public Friends(Integer idFriendship) {
        this.idFriendship = idFriendship;
    }

    public Friends(Integer idFriendship, String status) {
        this.idFriendship = idFriendship;
        this.status = status;
    }

    public Integer getIdFriendship() {
        return idFriendship;
    }

    public void setIdFriendship(Integer idFriendship) {
        this.idFriendship = idFriendship;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash += (idFriendship != null ? idFriendship.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friends)) {
            return false;
        }
        Friends other = (Friends) object;
        if ((this.idFriendship == null && other.idFriendship != null) || (this.idFriendship != null && !this.idFriendship.equals(other.idFriendship))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netgenius.v3_meet_up_agl.entidades.Friends[ idFriendship=" + idFriendship + " ]";
    }
    
}
