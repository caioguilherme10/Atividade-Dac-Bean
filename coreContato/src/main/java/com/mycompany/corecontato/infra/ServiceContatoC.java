/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corecontato.infra;

import com.mycompany.corecontato.infra.ContatoDaoC;
import com.mycompany.sharedcontato.Contato;
import com.mycompany.sharedcontato.Contato;
import com.mycompany.sharedcontato.ServiceContato;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author ifpb
 */
@Stateless
public class ServiceContatoC implements ServiceContato{
    
    private ContatoDaoC dao = new ContatoDaoC();

    @Override
    public void create(Contato contato) {
        this.dao.cadastrar(contato);
        
    }

    @Override
    public void update(Contato contato) {
        this.dao.editar(contato);
    }

    @Override
    public void delete(Contato contato) {
        this.dao.excluir(contato);
    }

    @Override
    public List<Contato> listarPorNome() {
        return dao.listarOrdernadoPorNome();
        
    }

    @Override
    public Contato buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
    
}
