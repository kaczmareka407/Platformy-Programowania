/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_zad2;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Coffees.findAll", query = "SELECT c FROM Coffees c"),
    @NamedQuery(name = "Coffees.findByCofName", query = "SELECT c FROM Coffees c WHERE c.cofName = :cofName"),
    @NamedQuery(name = "Coffees.findByPrice", query = "SELECT c FROM Coffees c WHERE c.price = :price"),
    @NamedQuery(name = "Coffees.findBySales", query = "SELECT c FROM Coffees c WHERE c.sales = :sales"),
    @NamedQuery(name = "Coffees.findByTotal", query = "SELECT c FROM Coffees c WHERE c.total = :total")})
public class Coffees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COF_NAME", nullable = false, length = 32)
    private String cofName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    @Basic(optional = false)
    @Column(nullable = false)
    private int sales;
    @Basic(optional = false)
    @Column(nullable = false)
    private int total;
    @JoinColumn(name = "SUP_ID", referencedColumnName = "SUP_ID", nullable = false)
    @ManyToOne(optional = false)
    private Suppliers supId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "coffees")
    private CoffeeDescriptions coffeeDescriptions;

    public Coffees() {
    }

    public Coffees(String cofName) {
        this.cofName = cofName;
    }

    public Coffees(String cofName, BigDecimal price, int sales, int total) {
        this.cofName = cofName;
        this.price = price;
        this.sales = sales;
        this.total = total;
    }

    public String getCofName() {
        return cofName;
    }

    public void setCofName(String cofName) {
        this.cofName = cofName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Suppliers getSupId() {
        return supId;
    }

    public void setSupId(Suppliers supId) {
        this.supId = supId;
    }

    public CoffeeDescriptions getCoffeeDescriptions() {
        return coffeeDescriptions;
    }

    public void setCoffeeDescriptions(CoffeeDescriptions coffeeDescriptions) {
        this.coffeeDescriptions = coffeeDescriptions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cofName != null ? cofName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coffees)) {
            return false;
        }
        Coffees other = (Coffees) object;
        if ((this.cofName == null && other.cofName != null) || (this.cofName != null && !this.cofName.equals(other.cofName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab3_zad2.Coffees[ cofName=" + cofName + " ]";
    }
    
}
