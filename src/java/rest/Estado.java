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
@Table(name = "Estado")
@XmlRootElement
@NamedNativeQueries({
@NamedNativeQuery(name = "Estado.findQtdCidadeporEstado",query = "SELECT COUNT(c.*) as qtd, c.uf FROM Cidade c group by c.uf", resultClass = Estado.class),
@NamedNativeQuery(name = "Estado.findQtdRegEstado",query = "SELECT COUNT(x.uf)as uf from( SELECT COUNT(C.uf) as uf FROM Cidade c group by c.uf)x ", resultClass = Estado.class),
@NamedNativeQuery(name = "Estado.findEstadoMenor",query = "SELECT x.uf from( SELECT c.uf, COUNT(c.name)qtd FROM Cidade c group by c.uf having  count(c.name) = (select min(y.qtd) from(SELECT C.uf, count(c.name)qtd FROM Cidade c group by c.uf)y))x " , resultClass = Estado.class),
@NamedNativeQuery(name = "Estado.findEstadoMaior",query = "SELECT x.uf from( SELECT c.uf, COUNT(c.name)qtd FROM Cidade c group by c.uf having  count(c.name) = (select max(y.qtd) from(SELECT C.uf, count(c.name)qtd FROM Cidade c group by c.uf)y))x " , resultClass = Estado.class)})


public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Column(name = "uf")
    @Id
    private String uf;
    private Integer qtd;
   

    public Estado() {
    }

    public Estado(String uf, int qtd) {
        this.uf = uf;
        this.qtd = qtd;
    }

    public String getUf() {
        return uf;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

   
    
}
