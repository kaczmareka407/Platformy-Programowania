/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject3;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "COFFEE_DESCRIPTIONS")
@NamedQueries({
    @NamedQuery(name = "CoffeeDescriptions.findAll", query = "SELECT c FROM CoffeeDescriptions c"),
    @NamedQuery(name = "CoffeeDescriptions.findByCofName", query = "SELECT c FROM CoffeeDescriptions c WHERE c.cofName = :cofName")})
public class CoffeeDescriptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COF_NAME")
    private String cofName;
    @Basic(optional = false)
    @Lob
    @Column(name = "COF_DESC")
    private String cofDesc;
    @JoinColumn(name = "COF_NAME", referencedColumnName = "COF_NAME", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Coffees coffees;

    public CoffeeDescriptions() {
    }

    public CoffeeDescriptions(String cofName) {
        this.cofName = cofName;
    }

    public CoffeeDescriptions(String cofName, String cofDesc) {
        this.cofName = cofName;
        this.cofDesc = cofDesc;
    }

    public String getCofName() {
        return cofName;
    }

    public void setCofName(String cofName) {
        this.cofName = cofName;
    }

    public String getCofDesc() {
        return cofDesc;
    }

    public void setCofDesc(String cofDesc) {
        this.cofDesc = cofDesc;
    }

    public Coffees getCoffees() {
        return coffees;
    }

    public void setCoffees(Coffees coffees) {
        this.coffees = coffees;
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
        if (!(object instanceof CoffeeDescriptions)) {
            return false;
        }
        CoffeeDescriptions other = (CoffeeDescriptions) object;
        if ((this.cofName == null && other.cofName != null) || (this.cofName != null && !this.cofName.equals(other.cofName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.CoffeeDescriptions[ cofName=" + cofName + " ]";
    }
    
}
