/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sharedcontato;

import java.util.List;

/**
 *
 * @author ifpb
 */
public interface ContatoDao {
    
    void cadastrar(Contato contato);
    void editar(Contato contato);
    void excluir(Contato contato);
    List<Contato> listarTodos();
    Contato buscarPorNome(String nome);
    
}
