/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_zad2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
@Table(name = "MERCH_INVENTORY", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "MerchInventory.findAll", query = "SELECT m FROM MerchInventory m"),
    @NamedQuery(name = "MerchInventory.findByItemId", query = "SELECT m FROM MerchInventory m WHERE m.itemId = :itemId"),
    @NamedQuery(name = "MerchInventory.findByItemName", query = "SELECT m FROM MerchInventory m WHERE m.itemName = :itemName"),
    @NamedQuery(name = "MerchInventory.findByQuan", query = "SELECT m FROM MerchInventory m WHERE m.quan = :quan"),
    @NamedQuery(name = "MerchInventory.findByDateVal", query = "SELECT m FROM MerchInventory m WHERE m.dateVal = :dateVal")})
public class MerchInventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ITEM_ID", nullable = false)
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "ITEM_NAME", nullable = false, length = 20)
    private String itemName;
    @Basic(optional = false)
    @Column(nullable = false)
    private int quan;
    @Basic(optional = false)
    @Column(name = "DATE_VAL", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVal;
    @JoinColumn(name = "SUP_ID", referencedColumnName = "SUP_ID", nullable = false)
    @ManyToOne(optional = false)
    private Suppliers supId;

    public MerchInventory() {
    }

    public MerchInventory(Integer itemId) {
        this.itemId = itemId;
    }

    public MerchInventory(Integer itemId, String itemName, int quan, Date dateVal) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quan = quan;
        this.dateVal = dateVal;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public Date getDateVal() {
        return dateVal;
    }

    public void setDateVal(Date dateVal) {
        this.dateVal = dateVal;
    }

    public Suppliers getSupId() {
        return supId;
    }

    public void setSupId(Suppliers supId) {
        this.supId = supId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerchInventory)) {
            return false;
        }
        MerchInventory other = (MerchInventory) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab3_zad2.MerchInventory[ itemId=" + itemId + " ]";
    }
    
}
