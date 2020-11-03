/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mateus
 */
public class Anime {
    private int id;
    private String titulo;
    private String status;
    private int anoLancamento;
    private int progresso;
    private String descricao;
    private double nota;
    private Connection connection;
    
    public Anime(Connection connection){
        this.connection = connection;
    }
    
    public Anime(){   
        
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public int getAnoLancamento() {
        return anoLancamento;
    }
    
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    public int getProgresso() {
        return progresso;
    }
    
    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    public ResultSet getListaAnimes() throws SQLException{
        String sql = "select id,"
                + "titulo,"
                + "status,"
                + "anoLancamento,"
                + "progresso,"
                + "descricao,"
                + "nota"
                + " from anime";
        PreparedStatement request = this.connection.prepareStatement(sql);
        return request.executeQuery();  
    }
    public void setAnime() throws SQLException{
        String sql = "insert into anime(titulo,"
                + "status,"
                + "anoLancamento,"
                + "progresso,"
                + "descricao,"
                + "nota"
                + ") values (?, ?, ?, ?, ?, ?)";
        PreparedStatement request;
        request = this.connection.prepareStatement(sql);
        request.setString(1, this.titulo);
        request.setString(2, this.status);
        request.setInt(3, this.anoLancamento);
        request.setInt(4, this.progresso);
        request.setString(5, this.descricao);
        request.setDouble(6, this.nota);
        request.executeUpdate();
        request.close();
    }
    public void updateAnime() throws SQLException{
        String sql = "update anime set titulo=?,"
                + "status=?,"
                + "anoLancamento=?,"
                + "progresso=?,"
                + "descricao=?,"
                + "nota=? where id=?";
        PreparedStatement request = this.connection.prepareStatement(sql);
        request.setString(1, this.titulo);
        request.setString(2, this.status);
        request.setInt(3, this.anoLancamento);
        request.setInt(4, this.progresso);
        request.setString(5, this.descricao);
        request.setDouble(6, this.nota);
        request.setInt(7, this.id);
        System.out.print(request);
        request.executeUpdate();
        request.close();   
    }   
    public void deleteAnime(int id) throws SQLException{
        String sql = "delete from anime where id = ?";
        PreparedStatement request = this.connection.prepareStatement(sql);
        request.setInt(1, id);
        request.executeUpdate();
        request.close();      
    }
    
    public void setUpdate(int id) throws SQLException{
        String sql = "update updateanime set id=? where id>=0";
        PreparedStatement request = this.connection.prepareStatement(sql);
        request.setInt(1, id);
        request.executeUpdate();
        request.close(); 
    }
    
    public ResultSet getListaUpdate() throws SQLException{
        String sql = "select id from updateAnime";
        PreparedStatement request = this.connection.prepareStatement(sql);
        return request.executeQuery();  
    }
}
