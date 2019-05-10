/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rafael Barro
 */
@Entity
@Table(name = "cidade")
@XmlRootElement
@NamedNativeQueries({
@NamedNativeQuery(name = "Cidade.findQtdCidadeporEstado",query = "SELECT COUNT(c) FROM Cidade c", resultClass = Cidade.class)})


@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findByIbgeId", query = "SELECT c FROM Cidade c WHERE c.ibgeId = :ibgeId"),
    @NamedQuery(name = "Cidade.findByUf", query = "SELECT c FROM Cidade c WHERE c.uf = :uf"),
    @NamedQuery(name = "Cidade.findByName", query = "SELECT c FROM Cidade c WHERE c.name = :name"),
    @NamedQuery(name = "Cidade.findCidadeporEstado", query = "SELECT c FROM Cidade c WHERE c.uf = :uf"),
    @NamedQuery(name = "Cidade.findByCapital", query = "SELECT c FROM Cidade c WHERE c.capital = :capital"),
    @NamedQuery(name = "Cidade.findAllCapital", query = "SELECT c FROM Cidade c WHERE c.capital = 'true' order by c.name"),
    @NamedQuery(name = "Cidade.findByLon", query = "SELECT c FROM Cidade c WHERE c.lon = :lon"),
    @NamedQuery(name = "Cidade.findByLat", query = "SELECT c FROM Cidade c WHERE c.lat = :lat"),
    @NamedQuery(name = "Cidade.findByNoAccents", query = "SELECT c FROM Cidade c WHERE c.noAccents = :noAccents"),
    @NamedQuery(name = "Cidade.findByAlternativeNames", query = "SELECT c FROM Cidade c WHERE c.alternativeNames = :alternativeNames"),
    @NamedQuery(name = "Cidade.findByMicroregion", query = "SELECT c FROM Cidade c WHERE c.microregion = :microregion"),
    @NamedQuery(name = "Cidade.findByMesoregion", query = "SELECT c FROM Cidade c WHERE c.mesoregion = :mesoregion")})
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ibge_id")
    private Integer ibgeId;
    @Size(max = 2147483647)
    @Column(name = "uf")
    private String uf;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "capital")
    private String capital;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lon")
    private Float lon;
    @Column(name = "lat")
    private Float lat;
    @Size(max = 2147483647)
    @Column(name = "no_accents")
    private String noAccents;
    @Size(max = 2147483647)
    @Column(name = "alternative_names")
    private String alternativeNames;
    @Size(max = 2147483647)
    @Column(name = "microregion")
    private String microregion;
    @Size(max = 2147483647)
    @Column(name = "mesoregion")
    private String mesoregion;

    public Cidade() {
    }

    public Cidade(Integer ibgeId, String uf, String name, String capital, Float lon, Float lat, String noAccents, String alternativeNames, String microregion, String mesoregion) {
        this.ibgeId = ibgeId;
        this.uf = uf;
        this.name = name;
        this.capital = capital;
        this.lon = lon;
        this.lat = lat;
        this.noAccents = noAccents;
        this.alternativeNames = alternativeNames;
        this.microregion = microregion;
        this.mesoregion = mesoregion;
    }
    

    public Cidade(Integer ibgeId) {
        this.ibgeId = ibgeId;
    }

    public Integer getIbgeId() {
        return ibgeId;
    }

    public void setIbgeId(Integer ibgeId) {
        this.ibgeId = ibgeId;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public String getNoAccents() {
        return noAccents;
    }

    public void setNoAccents(String noAccents) {
        this.noAccents = noAccents;
    }

    public String getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(String alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public String getMicroregion() {
        return microregion;
    }

    public void setMicroregion(String microregion) {
        this.microregion = microregion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ibgeId != null ? ibgeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.ibgeId == null && other.ibgeId != null) || (this.ibgeId != null && !this.ibgeId.equals(other.ibgeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rest.Cidade[ ibgeId=" + ibgeId + " ]";
  
    }
    
}
