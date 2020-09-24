/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelReservationProgram_V2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdussamet
 */
@Entity
@Table(name = "YONETICI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yonetici.findAll", query = "SELECT y FROM Yonetici y")
    , @NamedQuery(name = "Yonetici.findByAd", query = "SELECT y FROM Yonetici y WHERE y.ad = :ad")
    , @NamedQuery(name = "Yonetici.findBySoyad", query = "SELECT y FROM Yonetici y WHERE y.soyad = :soyad")
    , @NamedQuery(name = "Yonetici.findByKullaniciadi", query = "SELECT y FROM Yonetici y WHERE y.kullaniciadi = :kullaniciadi")
    , @NamedQuery(name = "Yonetici.findBySifre", query = "SELECT y FROM Yonetici y WHERE y.sifre = :sifre")})
public class Yonetici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "AD")
    private String ad;
    @Column(name = "SOYAD")
    private String soyad;
    @Id
    @Basic(optional = false)
    @Column(name = "KULLANICIADI")
    private String kullaniciadi;
    @Column(name = "SIFRE")
    private String sifre;

    public Yonetici() {
    }

    public Yonetici(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciadi != null ? kullaniciadi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yonetici)) {
            return false;
        }
        Yonetici other = (Yonetici) object;
        if ((this.kullaniciadi == null && other.kullaniciadi != null) || (this.kullaniciadi != null && !this.kullaniciadi.equals(other.kullaniciadi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abdussamet_kac\u0131_1721221007_bp2_odev2.Yonetici[ kullaniciadi=" + kullaniciadi + " ]";
    }
    
}
