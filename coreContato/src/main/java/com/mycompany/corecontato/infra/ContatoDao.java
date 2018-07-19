/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corecontato.infra;

import com.mycompany.sharedcontato.Contato;
import java.util.List;

/**
 *
 * @author ifpb
 */
public interface ContatoDao {
    
    void cadastrar(Contato contato);
    void editar(Contato contato);
    void excluir(Contato contato);
    List<Contato> listarOrdernadoPorNome();
    Contato buscarPorNome(String nome);
    
}
