/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfcontato.controller;

import com.mycompany.sharedcontato.Contato;
import com.mycompany.sharedcontato.ServiceContato;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ifpb
 */
@Named
@SessionScoped
public class controllerContato {
    
    private Contato Contato = new Contato();
    private ServiceContato service;
    
    public void cadastrar(Contato contato) {
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
}
