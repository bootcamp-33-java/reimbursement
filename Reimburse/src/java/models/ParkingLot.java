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
@Table(name = "PARKING_LOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParkingLot.findAll", query = "SELECT p FROM ParkingLot p")})
public class ParkingLot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    
    @Basic(optional = false)
    @Column(name = "LOCATION")
    private String location;
    
    @Basic(optional = false)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parkingLot", fetch = FetchType.LAZY)
    private List<Reimburse> reimburseList;

    public ParkingLot() {
    }

    public ParkingLot(Integer id) {
        this.id = id;
    }

    public ParkingLot(Integer id, String name, String location, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        if (!(object instanceof ParkingLot)) {
            return false;
        }
        ParkingLot other = (ParkingLot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ParkingLot[ id=" + id + " ]";
    }
    
}
