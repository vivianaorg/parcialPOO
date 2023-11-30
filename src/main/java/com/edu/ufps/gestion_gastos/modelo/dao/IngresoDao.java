/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Ingreso;
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
 * @author Laura Caballero
 */
public class IngresoDao implements IngresoServices {

    private final String SQL_CONSULTA = "SELECT * FROM ingreso";
    private final String SQL_INSERTAR = "INSERT INTO ingreso(id, monto)VALUES (NULL, ?)";
    private final String SQL_BORRAR = "DELETE FROM ingreso WHERE id = ?";
    private final String SQL_ACTUALIZAR = "UPDATE ingreso SET monto = ? WHERE id = ?";

    @Override
    public List<Ingreso> consultar() {
        List<Ingreso> ingresos = new ArrayList<>();
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();

            PreparedStatement stm = connection.prepareStatement(SQL_CONSULTA);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                int monto = rs.getInt("monto");

                Ingreso ingreso = new Ingreso(id, monto);
                ingresos.add(ingreso);
            }
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }

        return ingresos;
    }

    @Override
    public int total(Ingreso ingreso) {
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

    @Override
    public int crear(Ingreso ingreso) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_INSERTAR);
            stm.setInt(1, ingreso.getMonto());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int eliminar(Ingreso ingreso) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_BORRAR);
            stm.setInt(1, ingreso.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

    @Override
    public int acutalizar(Ingreso ingreso) {
        int registros = 0;
        try {
            BaseDatos bd = BaseDatos.getInstance();
            Connection connection = bd.getConection();
            PreparedStatement stm = connection.prepareStatement(SQL_ACTUALIZAR);
            stm.setInt(1, ingreso.getMonto());
            stm.setInt(2, ingreso.getId());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        }
        return registros;
    }

}
