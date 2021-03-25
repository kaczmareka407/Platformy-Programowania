/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_zad2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "RSS_FEEDS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "RssFeeds.findAll", query = "SELECT r FROM RssFeeds r"),
    @NamedQuery(name = "RssFeeds.findByRssName", query = "SELECT r FROM RssFeeds r WHERE r.rssName = :rssName"),
    @NamedQuery(name = "RssFeeds.findByRssFeedXml", query = "SELECT r FROM RssFeeds r WHERE r.rssFeedXml = :rssFeedXml")})
public class RssFeeds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RSS_NAME", nullable = false, length = 32)
    private String rssName;
    @Basic(optional = false)
    @Column(name = "RSS_FEED_XML", nullable = false)
    private Serializable rssFeedXml;

    public RssFeeds() {
    }

    public RssFeeds(String rssName) {
        this.rssName = rssName;
    }

    public RssFeeds(String rssName, Serializable rssFeedXml) {
        this.rssName = rssName;
        this.rssFeedXml = rssFeedXml;
    }

    public String getRssName() {
        return rssName;
    }

    public void setRssName(String rssName) {
        this.rssName = rssName;
    }

    public Serializable getRssFeedXml() {
        return rssFeedXml;
    }

    public void setRssFeedXml(Serializable rssFeedXml) {
        this.rssFeedXml = rssFeedXml;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rssName != null ? rssName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RssFeeds)) {
            return false;
        }
        RssFeeds other = (RssFeeds) object;
        if ((this.rssName == null && other.rssName != null) || (this.rssName != null && !this.rssName.equals(other.rssName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lab3_zad2.RssFeeds[ rssName=" + rssName + " ]";
    }
    
}
