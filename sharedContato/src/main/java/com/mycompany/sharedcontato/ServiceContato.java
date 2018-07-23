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
    List<Contato> listarTodos();
    List<Contato> listarPorNome(String nome);
}
