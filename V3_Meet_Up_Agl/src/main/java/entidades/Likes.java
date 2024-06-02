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
@javax.persistence.Table(name = "likes")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Likes.findAll", query = "SELECT l FROM Likes l"),
    @javax.persistence.NamedQuery(name = "Likes.findByIdLike", query = "SELECT l FROM Likes l WHERE l.idLike = :idLike"),
    @javax.persistence.NamedQuery(name = "Likes.findByCreatedAt", query = "SELECT l FROM Likes l WHERE l.createdAt = :createdAt")})
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id_like")
    private Integer idLike;
    @javax.persistence.Column(name = "created_at")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdAt;
    @javax.persistence.JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idUser;
    @javax.persistence.JoinColumn(name = "id_liked_user", referencedColumnName = "id_user")
    @javax.persistence.ManyToOne(optional = false)
    private Users idLikedUser;

    public Likes() {
    }

    public Likes(Integer idLike) {
        this.idLike = idLike;
    }

    public Integer getIdLike() {
        return idLike;
    }

    public void setIdLike(Integer idLike) {
        this.idLike = idLike;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Users getIdLikedUser() {
        return idLikedUser;
    }

    public void setIdLikedUser(Users idLikedUser) {
        this.idLikedUser = idLikedUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLike != null ? idLike.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Likes)) {
            return false;
        }
        Likes other = (Likes) object;
        if ((this.idLike == null && other.idLike != null) || (this.idLike != null && !this.idLike.equals(other.idLike))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.netgenius.v3_meet_up_agl.entidades.Likes[ idLike=" + idLike + " ]";
    }
    
}
