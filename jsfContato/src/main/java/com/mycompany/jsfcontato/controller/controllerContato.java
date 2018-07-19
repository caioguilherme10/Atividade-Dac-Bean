/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfcontato.controller;

import com.mycompany.sharedcontato.Contato;
import com.mycompany.sharedcontato.ServiceContato;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author ifpb
 */

@Named
@RequestScoped
public class controllerContato implements Serializable{
    
    private Contato contato = new Contato();
    @EJB
    private ServiceContato service;

    public controllerContato() {
    }
    
    
    
    public void cadastrar() {
        this.service.create(contato);
        
    }

    public void editar(Contato contato) {
        this.service.update(contato);
    }

    
    public void excluir(Contato contato) {
        this.service.delete(contato);
    }

    
    public List<Contato> listarTodos() {
        return service.listarPorNome();
    }

    
    public Contato buscarPorNome(String nome) {
        return service.buscarPorNome(nome);
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    
}
