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
public interface ServiceContato {
    
    void create(Contato contato);
    void update(Contato contato);
    void delete(Contato contato);
    List<Contato> listarPorNome();
    Contato buscarPorNome(String nome);
}
