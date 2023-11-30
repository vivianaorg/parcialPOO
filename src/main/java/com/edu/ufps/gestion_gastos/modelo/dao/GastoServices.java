/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Gasto;
import java.util.*;
/**
 *
 * @author ASUS
 */
public interface GastoServices {
    public List<Gasto> consultar();
    public Gasto consultarId(Gasto gasto);
    public int agregarGasto(Gasto gasto);
    public int eliminar(Gasto gasto);
    public int actualizar (Gasto gasto);

}
