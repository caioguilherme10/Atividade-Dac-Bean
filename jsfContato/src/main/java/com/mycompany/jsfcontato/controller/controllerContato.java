/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfcontato.controller;

import com.mycompany.sharedcontato.Contato;
import com.mycompany.sharedcontato.ServiceContato;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ifpb
 */
@Named
@SessionScoped
public class controllerContato implements Serializable {

    private Contato contato = new Contato();
    private List<Contato> contatos;
    private String busca;

    @EJB
    private ServiceContato service;

    @PostConstruct
    public void init() {
        contatos = new ArrayList<>();
    }

    public void cadastrar() {
        contato.setDataNascimento(LocalDate.now());
        this.service.create(contato);
        
        //limpando
        contato.setNome("");
        contato.setEmail("");
        contato.setTelefone("");

    }

    public void editar() {
        contato.setDataNascimento(LocalDate.now());
        this.service.update(contato);
        
        //limpando
        contato.setNome("");
        contato.setEmail("");
        contato.setTelefone("");
    }

    public void excluir(Contato contato) {
        this.service.delete(contato);
    }

    public List<Contato> listarTodos() {
        return service.listarTodos();
    }

    public List<Contato> listarPorNome() {
        contatos = this.service.listarPorNome(busca);
        return contatos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
    
    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
}
