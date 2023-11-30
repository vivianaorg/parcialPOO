/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import red.BaseDatos;
import red.Test;
/**
 *
 * @author ASUS
 */
public class CategoriaDao implements CategoriaServices{
    private final String sql = "SELECT * FROM categoria";
    private final String SQL_CONSULTAID = "SELECT * FROM destino WHERE id = ?"; 
    private final String SQL_INSERTAR = "INSERT INTO categoria(id, nombre)VALUES (?, ?)";
    
    @Override
    public List<Categoria> consultar() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Categoria categoria = new Categoria(id,"nombre");
                
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return categorias;
    }
    
    @Override
    public Categoria consultarId(Categoria categoria) {
        Categoria cResultado= null;

        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();

            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setInt(1, categoria.getId());
            ResultSet rs = stm.executeQuery();
            rs.absolute(1);
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
     
            cResultado = new Categoria(id);

       
    }
    catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
    }
        return cResultado;
}

    @Override
    public int agregarCategoria(Categoria categoria) {
         int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setInt(1, categoria.getId());
            stm.setString(2, categoria.getNombre());      
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }
}
