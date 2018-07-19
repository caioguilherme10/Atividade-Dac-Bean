/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corecontato.infra;

import com.mycompany.sharedcontato.Contato;
import com.mycompany.sharedcontato.ContatoDao;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author ifpb
 */
@Stateful
public class ServiceContato implements ContatoDao{
    
    private ContatoDaoC dao = new ContatoDaoC();

    @Override
    public void cadastrar(Contato contato) {
        this.dao.cadastrar(contato);
        
    }

    @Override
    public void editar(Contato contato) {
        this.dao.editar(contato);
    }

    @Override
    public void excluir(Contato contato) {
        this.dao.excluir(contato);
    }

    @Override
    public List<Contato> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public Contato buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
    
}
