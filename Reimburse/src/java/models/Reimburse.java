/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yuyun
 */
@Entity
@Table(name = "REIMBURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reimburse.findAll", query = "SELECT r FROM Reimburse r")})
public class Reimburse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "HISTORY")
    private int history;
    
    @Basic(optional = false)
    @Column(name = "PHOTO_KARCIS")
    private String photoKarcis;
    
    @Basic(optional = false)
    @Column(name = "UPLOAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    
    @Basic(optional = false)
    @Column(name = "PRICE")
    private int price;
    
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    
    @JoinColumn(name = "PARKING_LOT", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ParkingLot parkingLot;
    
    @JoinColumn(name = "VEHICLE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehicle vehicle;

    public Reimburse() {
    }

    public Reimburse(Integer id) {
        this.id = id;
    }

    public Reimburse(Integer id, int history, String photoKarcis, Date uploadDate, int price) {
        this.id = id;
        this.history = history;
        this.photoKarcis = photoKarcis;
        this.uploadDate = uploadDate;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public String getPhotoKarcis() {
        return photoKarcis;
    }

    public void setPhotoKarcis(String photoKarcis) {
        this.photoKarcis = photoKarcis;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
        if (!(object instanceof Reimburse)) {
            return false;
        }
        Reimburse other = (Reimburse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Reimburse[ id=" + id + " ]";
    }
    
}
