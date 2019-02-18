/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencelaboratorysystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Sadiqeen
 */
@Entity
@Table(name = "chemicals", catalog = "sciencedata", schema = "")
@NamedQueries({
    @NamedQuery(name = "Chemicals.findAll", query = "SELECT c FROM Chemicals c")
    , @NamedQuery(name = "Chemicals.findByChemicalsID", query = "SELECT c FROM Chemicals c WHERE c.chemicalsID = :chemicalsID")
    , @NamedQuery(name = "Chemicals.findByChemicalsName", query = "SELECT c FROM Chemicals c WHERE c.chemicalsName = :chemicalsName")
    , @NamedQuery(name = "Chemicals.findByOrderDate", query = "SELECT c FROM Chemicals c WHERE c.orderDate = :orderDate")
    , @NamedQuery(name = "Chemicals.findByManufacturedDate", query = "SELECT c FROM Chemicals c WHERE c.manufacturedDate = :manufacturedDate")
    , @NamedQuery(name = "Chemicals.findByExpiredDate", query = "SELECT c FROM Chemicals c WHERE c.expiredDate = :expiredDate")
    , @NamedQuery(name = "Chemicals.findByQuanlity", query = "SELECT c FROM Chemicals c WHERE c.quanlity = :quanlity")})
public class Chemicals implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chemicals_ID")
    private Integer chemicalsID;
    @Column(name = "chemicals_Name")
    private String chemicalsName;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "manufactured_date")
    @Temporal(TemporalType.DATE)
    private Date manufacturedDate;
    @Column(name = "expired_date")
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    @Column(name = "quanlity")
    private Integer quanlity;

    public Chemicals() {
    }

    public Chemicals(Integer chemicalsID) {
        this.chemicalsID = chemicalsID;
    }

    public Integer getChemicalsID() {
        return chemicalsID;
    }

    public void setChemicalsID(Integer chemicalsID) {
        Integer oldChemicalsID = this.chemicalsID;
        this.chemicalsID = chemicalsID;
        changeSupport.firePropertyChange("chemicalsID", oldChemicalsID, chemicalsID);
    }

    public String getChemicalsName() {
        return chemicalsName;
    }

    public void setChemicalsName(String chemicalsName) {
        String oldChemicalsName = this.chemicalsName;
        this.chemicalsName = chemicalsName;
        changeSupport.firePropertyChange("chemicalsName", oldChemicalsName, chemicalsName);
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        Date oldOrderDate = this.orderDate;
        this.orderDate = orderDate;
        changeSupport.firePropertyChange("orderDate", oldOrderDate, orderDate);
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(Date manufacturedDate) {
        Date oldManufacturedDate = this.manufacturedDate;
        this.manufacturedDate = manufacturedDate;
        changeSupport.firePropertyChange("manufacturedDate", oldManufacturedDate, manufacturedDate);
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        Date oldExpiredDate = this.expiredDate;
        this.expiredDate = expiredDate;
        changeSupport.firePropertyChange("expiredDate", oldExpiredDate, expiredDate);
    }

    public Integer getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(Integer quanlity) {
        Integer oldQuanlity = this.quanlity;
        this.quanlity = quanlity;
        changeSupport.firePropertyChange("quanlity", oldQuanlity, quanlity);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chemicalsID != null ? chemicalsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chemicals)) {
            return false;
        }
        Chemicals other = (Chemicals) object;
        if ((this.chemicalsID == null && other.chemicalsID != null) || (this.chemicalsID != null && !this.chemicalsID.equals(other.chemicalsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sciencelaboratorysystem.Chemicals[ chemicalsID=" + chemicalsID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
