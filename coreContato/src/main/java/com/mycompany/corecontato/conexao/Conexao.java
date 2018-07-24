/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corecontato.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifpb
 */
public class Conexao {

    private Connection connection;

    public Connection init() {
        try {
            Class.forName("org.postgresql.Driver");
            return connection = DriverManager.getConnection("jdbc:postgresql://host-banco:5432/dac-bean", "postgres", "123");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void fecharConexao(Connection c) throws SQLException {
        c.close();
    }
}
