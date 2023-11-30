/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Ingreso;
import java.util.List;

/**
 *
 * @author Laura Caballero
 */
public interface IngresoServices {
    public List<Ingreso> consultar();
    public int total(Ingreso ingreso);
    public int crear(Ingreso ingreso);
    public int eliminar(Ingreso ingreso);
    public int acutalizar (Ingreso ingreso);
}
