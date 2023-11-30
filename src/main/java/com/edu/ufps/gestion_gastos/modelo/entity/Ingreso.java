/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.entity;
import java.util.List;
/**
 *
 * @author Laura Caballero
 */
public class Ingreso {
    int id;
    int monto;

    public Ingreso(int id, int monto) {
        this.id = id;
        this.monto = monto;
    }

    public Ingreso(int id) {
        this.id = id;
    }
    
    

    public Ingreso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Ingreso{" + "id=" + id + ", monto=" + monto + '}';
    }
    

    
}
