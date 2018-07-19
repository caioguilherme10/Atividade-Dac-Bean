/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corecontato.infra;

import com.mycompany.corecontato.conexao.Conexao;
import com.mycompany.sharedcontato.Contato;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ifpb
 */
public class ContatoDaoC implements ContatoDao{

    private final Conexao conexao;

    public ContatoDaoC() {
        conexao = new Conexao();
    }
    
    @Override
    public void cadastrar(Contato contato) {
        
        PreparedStatement stmt = null;
        String sql = "INSERT INTO contato (nome, email, telefone, datanascimento) VALUES (?,?,?,?)";
        try {
            stmt = conexao.init().prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getTelefone());
            stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoC.class.getName()).log(Level.SEVERE, null, ex);
}
    }

    @Override
    public void editar(Contato contato) {
        
        try {
            String sql = "UPDATE contato SET nome = ?, telefone = ? , datanascimento = ? WHERE email = ?";
            PreparedStatement stmt = conexao.init().prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setDate(3, Date.valueOf(contato.getDataNascimento()));
            stmt.setString(4, contato.getEmail());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void excluir(Contato contato) {
        
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM contato WHERE email = ?";
            stmt = conexao.init().prepareStatement(sql);
            stmt.setString(1, contato.getEmail());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Contato> listarOrdernadoPorNome() {
        
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM contato order by nome asc";
            stmt = conexao.init().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoC.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return criarContato(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Collections.emptyList();
    }

    @Override
    public Contato buscarPorNome(String nome) {
        
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM contato WHERE nome = ?";
            
            stmt = conexao.init().prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet resultSet = stmt.executeQuery();
            
            Contato c = new Contato(
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("telefone"),
                    resultSet.getDate("datanascimento").toLocalDate()
            );
            
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDaoC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    private List<Contato> criarContato(PreparedStatement stmt) throws SQLException{
        
        List<Contato> contatos = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            Contato c = new Contato(
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("telefone"),
                    resultSet.getDate("datanascimento").toLocalDate()
            );
            contatos.add(c);
        }

        return contatos;
    }
    
}
