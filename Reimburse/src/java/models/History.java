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
@Table(name = "HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")})
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "PERIOD_MONTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodMonth;
    
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private long total;
    
    @Basic(optional = false)
    @Column(name = "IS_APPROV1")
    private short isApprov1;
    
    @Basic(optional = false)
    @Column(name = "IS_APPROV2")
    private short isApprov2;
    
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    
    @Basic(optional = false)
    @Column(name = "KETERANGAN")
    private String keterangan;
    
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public History() {
    }

    public History(Integer id) {
        this.id = id;
    }

    public History(Integer id, Date period, long total, short isApprov1, short idApprov2, String status, String keterangan) {
        this.id = id;
        this.periodMonth = period;
        this.total = total;
        this.isApprov1 = isApprov1;
        this.isApprov2 = idApprov2;
        this.status = status;
        this.keterangan = keterangan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(Date periodMonth) {
        this.periodMonth = periodMonth;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public short getIsApprov1() {
        return isApprov1;
    }

    public void setIsApprov1(short isApprov1) {
        this.isApprov1 = isApprov1;
    }

    public short getIsApprov2() {
        return isApprov2;
    }

    public void setIsApprov2(short isApprov2) {
        this.isApprov2 = isApprov2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.History[ id=" + id + " ]";
    }
    
}
