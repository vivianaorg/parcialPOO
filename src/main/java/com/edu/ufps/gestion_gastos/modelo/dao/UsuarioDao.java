/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Usuario;
import java.util.List;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import red.BaseDatos;
import red.Test;

/**
 *
 * @author Juan
 */
public class UsuarioDao implements UsuarioServices {

    private final String SQL_CONSULTA = "SELECT * FROM usuario";
    private final String SQL_INSERTAR = "INSERT INTO usuario(email, nombre, contraseña)VALUES (?, ?, ?)";
    private final String SQL_BORRAR = "DELETE FROM usuario WHERE email = ?";
    private final String SQL_ACTUALIZAR = "UPDATE usuario SET nombre = ?, contraseña = ? WHERE email = ?";
    private final String SQL_INICIARSESION = "SELECT * FROM usuario WHERE email = ? AND nombre = ? AND contraseña = ?";

    @Override
    public List<Usuario> consultar() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();

            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String nombre = rs.getString("nombre");
                String contraseña = rs.getString("contraseña");
                

                Usuario usuario = new Usuario(email, nombre, contraseña);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }

        return usuarios;
    }

    @Override
    public boolean iniciarSesion(Usuario usuario) {
        
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INICIARSESION);
            
            
            stm.setString(1, usuario.getEmail());
            stm.setString(2, usuario.getNombre());
            stm.setString(3, usuario.getContraseña());
            //stm.setString(2, usuario.getNombre());
            //stm.setString(3, usuario.getContraseña());
            ResultSet rs = stm.executeQuery();
            //rs.absolute(1);

            //String email = rs.getString("email");
            //String contraseña = rs.getString("contraseña");
            
            if(rs.next()){
                return true;
            } else {
                crear(usuario);
            }
            
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } 
        return false;
    }

    @Override
    public int crear(Usuario usuario) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);

            stm.setString(1, usuario.getEmail());
            stm.setString(2, usuario.getNombre());
            stm.setString(3, usuario.getContraseña());

            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int eliminar(Usuario usuario) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_BORRAR);

            stm.setString(1, usuario.getEmail());

            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int acutalizar(Usuario usuario) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_ACTUALIZAR);

            stm.setString(1, usuario.getEmail());
            stm.setString(2, usuario.getNombre());
            stm.setString(3, usuario.getContraseña());

            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }
    
    @Override
    public boolean iniciarConGoogle(Usuario usuario){
        return false;
    }
}
