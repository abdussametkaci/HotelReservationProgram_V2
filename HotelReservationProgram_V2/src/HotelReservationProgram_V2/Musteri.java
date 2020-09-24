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
@Table(name = "MUSTERI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musteri.findAll", query = "SELECT m FROM Musteri m")
    , @NamedQuery(name = "Musteri.findByAd", query = "SELECT m FROM Musteri m WHERE m.ad = :ad")
    , @NamedQuery(name = "Musteri.findBySoyad", query = "SELECT m FROM Musteri m WHERE m.soyad = :soyad")
    , @NamedQuery(name = "Musteri.findByTc", query = "SELECT m FROM Musteri m WHERE m.tc = :tc")
    , @NamedQuery(name = "Musteri.findByEmail", query = "SELECT m FROM Musteri m WHERE m.email = :email")
    , @NamedQuery(name = "Musteri.findByCinsiyet", query = "SELECT m FROM Musteri m WHERE m.cinsiyet = :cinsiyet")
    , @NamedQuery(name = "Musteri.findByTel", query = "SELECT m FROM Musteri m WHERE m.tel = :tel")
    , @NamedQuery(name = "Musteri.findByYas", query = "SELECT m FROM Musteri m WHERE m.yas = :yas")
    , @NamedQuery(name = "Musteri.findByKullaniciadi", query = "SELECT m FROM Musteri m WHERE m.kullaniciadi = :kullaniciadi")
    , @NamedQuery(name = "Musteri.findBySifre", query = "SELECT m FROM Musteri m WHERE m.sifre = :sifre")
    , @NamedQuery(name = "Musteri.findByOtel", query = "SELECT m FROM Musteri m WHERE m.otel = :otel")
    , @NamedQuery(name = "Musteri.findByOda", query = "SELECT m FROM Musteri m WHERE m.oda = :oda")
    , @NamedQuery(name = "Musteri.findByAldigihizmetler", query = "SELECT m FROM Musteri m WHERE m.aldigihizmetler = :aldigihizmetler")
    , @NamedQuery(name = "Musteri.findByFatura", query = "SELECT m FROM Musteri m WHERE m.fatura = :fatura")})
public class Musteri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "AD")
    private String ad;
    @Column(name = "SOYAD")
    private String soyad;
    @Id
    @Basic(optional = false)
    @Column(name = "TC")
    private String tc;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CINSIYET")
    private String cinsiyet;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "YAS")
    private Integer yas;
    @Column(name = "KULLANICIADI")
    private String kullaniciadi;
    @Column(name = "SIFRE")
    private String sifre;
    @Column(name = "OTEL")
    private String otel;
    @Column(name = "ODA")
    private Integer oda;
    @Column(name = "ALDIGIHIZMETLER")
    private String aldigihizmetler;
    @Column(name = "FATURA")
    private Integer fatura;

    public Musteri() {
    }

    public Musteri(String tc) {
        this.tc = tc;
    }
    
     public Musteri(String ad, String soyad, String tc, String email, String cinsiyet, String tel, int yas, String kullaniciadi, String sifre){
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.email = email;
        this.cinsiyet = cinsiyet;
        this.tel = tel;
        this.yas = yas;
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
    }
     
    public Musteri(String ad, String soyad, String tc, String email, String cinsiyet, String tel, int yas, String kullaniciadi, String sifre, String otel, int oda, String aldigihizmetler, int fatura){
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.email = email;
        this.cinsiyet = cinsiyet;
        this.tel = tel;
        this.yas = yas;
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
        this.otel = otel;
        this.oda = oda;
        this.aldigihizmetler = aldigihizmetler;
        this.fatura = fatura;
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

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
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

    public String getOtel() {
        return otel;
    }

    public void setOtel(String otel) {
        this.otel = otel;
    }

    public Integer getOda() {
        return oda;
    }

    public void setOda(Integer oda) {
        this.oda = oda;
    }

    public String getAldigihizmetler() {
        return aldigihizmetler;
    }

    public void setAldigihizmetler(String aldigihizmetler) {
        this.aldigihizmetler = aldigihizmetler;
    }

    public Integer getFatura() {
        return fatura;
    }

    public void setFatura(Integer fatura) {
        this.fatura = fatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tc != null ? tc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musteri)) {
            return false;
        }
        Musteri other = (Musteri) object;
        if ((this.tc == null && other.tc != null) || (this.tc != null && !this.tc.equals(other.tc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "abdussamet_kac\u0131_1721221007_bp2_odev2.Musteri[ tc=" + tc + " ]";
    }
    
}
