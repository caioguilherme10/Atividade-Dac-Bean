package com.mycompany.jsecontato;

import com.mycompany.sharedcontato.Contato;
import com.mycompany.sharedcontato.ServiceContato;
import java.util.List;

/**
 *
 * @author alexalins
 */
public class NewMain {

    public static void main(String[] args) {
        ServiceContato service = new ServiceLocator().lookup();

        //ListandoTodos
        List<Contato> contatos = service.listarTodos();
        contatos.forEach((c) -> System.out.println(c.toString()));

        //Listando Lucas pelo nome
        List<Contato> contatoPorNome = service.listarPorNome("Lucas");
        contatoPorNome.forEach((c) -> System.out.println(c.toString()));
    }

}
