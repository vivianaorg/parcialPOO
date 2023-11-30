/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Categoria;
import com.edu.ufps.gestion_gastos.modelo.entity.Gasto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import red.BaseDatos;

/**
 *
 * @author ASUS
 */
public class GastoDao implements GastoServices {

    private final String sql = "SELECT * FROM gasto";
    private final String SQL_CONSULTAID = "SELECT * FROM gasto WHERE id = ?";

    private final String SQL_CONSULTA = "SELECT monto FROM gasto";

    private final String SQL_INSERTAR = "INSERT INTO gasto(id, id_categoria,monto,fecha)VALUES (NULL,?, ?,?)";
    private final String SQL_BORRAR = "DELETE FROM gasto WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE gasto SET monto = ?,id_categoria=?, fecha=? WHERE id = ?";

    private final String SQL_FECHA = "SELECT id, monto, id_categoria, fecha FROM gasto WHERE fecha >= ?";

    private final String SQL_SUMA = "SELECT SUM(monto) AS total_monto FROM gasto WHERE id_categoria = ? AND fecha<='2023-11-29' AND fecha >= '2023-10-29'";
    
    @Override
    public List<Gasto> consultar() {
        List<Gasto> gastos = new ArrayList<>();
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Categoria id_categoria = new Categoria(rs.getInt("id_categoria"));
                int monto = rs.getInt("monto");
                java.util.Date fecha = rs.getDate("fecha");
                Gasto gasto = new Gasto(id, id_categoria, monto, fecha);
                gastos.add(gasto);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return gastos;
    }

    @Override
    public Gasto consultarId(Gasto gasto) {
        Gasto gastoResultado = null;

        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();

            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTAID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            stm.setInt(1, gasto.getId());
            ResultSet rs = stm.executeQuery();
            rs.absolute(1);
            int id = rs.getInt("id");
            Categoria id_categoria = new Categoria(rs.getInt("id_categoria"));
            int monto = rs.getInt("monto");
            java.util.Date fecha = rs.getDate("fecha");

            gastoResultado = new Gasto(id, id_categoria, monto, fecha);

        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return gastoResultado;
    }

    @Override
    public int agregarGasto(Gasto gasto) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);
            //stm.setInt(1, gasto.getId_categoria().getId());
            if (gasto.getId_categoria() != null) {
                stm.setInt(1, gasto.getId_categoria().getId());
                stm.setInt(2, gasto.getMonto());
                java.sql.Date fecha = new java.sql.Date(gasto.getFecha().getTime());
                stm.setDate(3, fecha);

                registros = stm.executeUpdate();
            } else {
                System.out.println("La categoría no está asignada para el gasto: " + gasto.getId());
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int eliminar(Gasto gasto) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_BORRAR);
            stm.setInt(1, gasto.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int actualizar(Gasto gasto) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setInt(1, gasto.getId_categoria().getId());

            stm.setInt(2, gasto.getMonto());
            java.sql.Date fecha = new java.sql.Date(gasto.getFecha().getTime());
            stm.setDate(3, fecha);
            stm.setInt(4, gasto.getId());

            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    public int total(Gasto gasto) {
        int totalSuma = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int monto = rs.getInt("monto");
                totalSuma += monto;
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return totalSuma;
    }

    //gastopor fecha
    public List<Gasto> gastoFecha() {
        List<Gasto> gastos = new ArrayList<>();

        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();

            Calendar calendar = Calendar.getInstance();
            java.util.Date fechaActual = new java.util.Date();
            calendar.setTime(fechaActual);
            calendar.add(Calendar.DAY_OF_MONTH, -30);
            java.util.Date f = calendar.getTime();

            PreparedStatement stm = connection.prepareStatement(SQL_FECHA);
            stm.setDate(1, new java.sql.Date(f.getTime()));

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                int idGasto = rs.getInt("id");
                int monto = rs.getInt("monto");
                Categoria id_categoria = new Categoria(rs.getInt("id_categoria"));
                Gasto gasto = new Gasto(idGasto, id_categoria, monto, f);
                gastos.add(gasto);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }

        return gastos;
    }
    
    public int sumaGastos(int id){
        int total=0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();

            PreparedStatement stm = connection.prepareStatement(SQL_SUMA);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            //rs.absolute(1);
            while(rs.next()){
            int n =  rs.getInt("total_monto");
            //total= stm.executeUpdate();
            total=n;
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return total;
    }
}

