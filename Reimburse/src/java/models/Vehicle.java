/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yuyun
 */
@Entity
@Table(name = "VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    
    @Basic(optional = false)
    @Column(name = "VEHICLE_TYPE")
    private String vehicleType;
    
    @Basic(optional = false)
    @Column(name = "STNK_OWNER")
    private String stnkOwner;
    
    @Basic(optional = false)
    @Column(name = "PHOTO_STNK")
    private String photoStnk;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Reimburse> reimburseList;

    public Vehicle() {
    }

    public Vehicle(String id) {
        this.id = id;
    }

    public Vehicle(String id, String vehicleType, String stnkOwner, String photoStnk) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.stnkOwner = stnkOwner;
        this.photoStnk = photoStnk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getStnkOwner() {
        return stnkOwner;
    }

    public void setStnkOwner(String stnkOwner) {
        this.stnkOwner = stnkOwner;
    }

    public String getPhotoStnk() {
        return photoStnk;
    }

    public void setPhotoStnk(String photoStnk) {
        this.photoStnk = photoStnk;
    }

    @XmlTransient
    public List<Reimburse> getReimburseList() {
        return reimburseList;
    }

    public void setReimburseList(List<Reimburse> reimburseList) {
        this.reimburseList = reimburseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Vehicle[ id=" + id + " ]";
    }
    
}
