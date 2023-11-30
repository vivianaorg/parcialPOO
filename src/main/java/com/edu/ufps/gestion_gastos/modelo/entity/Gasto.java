/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Gasto {
    private int id;
    private Categoria id_categoria;
    private int monto;
    private Date fecha;

    public Gasto() {
    }

    public Gasto(int id, Categoria id_categoria, int monto, Date fecha) {
        this.id = id;
        this.id_categoria = id_categoria;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Gasto(int id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Gasto{" + "id=" + id + ", monto=" + monto + '}';
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Gasto(int id, int monto, Date fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }

    /**
     * @return the id_categoria
     */
    public Categoria getId_categoria() {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
}
