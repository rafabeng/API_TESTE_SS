/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import rest.Cidade;
import rest.Estado;


/**
 *
 * @author Rafael Barro
 */
@Stateless
@Path("rest.cidade")
public class CidadeFacadeREST extends AbstractFacade<Cidade> {
    @PersistenceContext(unitName = "testeCSVPU")
    private EntityManager em;

    public CidadeFacadeREST() {
        super(Cidade.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Cidade entity) {
        super.create(entity);
    }

    
    //QUESTÃO 2 - Exibe somente cidades que são capitais
    @GET
    @Path("Capitais")
    @Produces({"application/json"})
    public List<Cidade>  findAllCapital() { 
        
      List<Cidade> results =  em.createNamedQuery("Cidade.findAllCapital")
      .getResultList(); 
      
      return results;
    }   
    
    //QUESTÃO 3 - Retornar o nome do estado com a maior e menor quantidade de cidades e a quantidade de cidades;
    @GET
    @Path("MenorEstado")
    @Produces({"application/json"})
    public List<Estado>  findEstadoMenor() { 
        
      List<Estado> results =  em.createNamedQuery("Estado.findEstadoMenor")
      .getResultList(); 
      
      return results;
   
    }   
    
    @GET
    @Path("MaiorEstado")
    @Produces({"application/json"})
    public List<Estado>  findEstadoMaior() { 
        
      List<Estado> results =  em.createNamedQuery("Estado.findEstadoMaior")
      .getResultList(); 
      
      return results;
   
    }   
    
    //QUESTÃO 4 - Quantidade de cidades por estado
    @GET
    @Path("QTDCidadePorEstado")
    @Produces({"application/json"})
    public List<Estado>  findQtdCidadeporEstado() { 
        
      List<Estado> results =  em.createNamedQuery("Estado.findQtdCidadeporEstado")
      .getResultList(); 
      
      return results;
   
    }  
    
    //QUESTÃO 5 - Exibe a cidade pelo ibge
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Cidade find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
   
    @GET
    @Path("/ibge/{id}")
    @Produces({"application/json"})
    public Cidade findByIbgeId(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
   
     //QUESTÃO 6 - Exibe cidades pelo estado
    @GET
    @Path("CidadePorEstado/{uf}")
    @Produces({"application/json"})
    public List<Cidade>  findCidadeporEstado(@PathParam("uf") String uf) { 
        
      List<Cidade> results =  em.createNamedQuery("Cidade.findCidadeporEstado")
      .setParameter("uf",uf)
      .getResultList(); 
      
      return results;
    }   
             
    
     //QUESTÃO 7 - Insere a cidade pelo ibge
    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Cidade entity) {
        super.edit(entity);
    }

    //QUESTÃO 8 - Remove a cidade pelo ibge
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }
    
    
    //QUESTÃO 10 - Retornar a quantidade de registro baseado em uma coluna. Não deve contar itens iguais;
    @GET
    @Path("QTDRegEstado")
    @Produces({"application/json"})
    public List<Estado>  findQtdRegEstado() { 
        
      List<Estado> results =  em.createNamedQuery("Estado.findQtdRegEstado")
      .getResultList(); 
      
      return results;
   
    }   
    
    
    // QUESTÃO 11 - Total de registros
    @GET
    @Path("QtdTotal")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    
    // Exibe todas as cidades
    @GET
    @Override
    @Produces({"application/json"})
    public List<Cidade> findAll() {
        return super.findAll();
    }

    // Exibe a cidade pelo nome
    @GET
    @Path("Cidade/{name}")
    @Produces({"application/json"})
    public List<Cidade>  findByName(@PathParam("name") String name) { 
        
      List<Cidade> results =  em.createNamedQuery("Cidade.findByName")
      .setParameter("name",name)
      .getResultList(); 
      
      return results;
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Cidade> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
