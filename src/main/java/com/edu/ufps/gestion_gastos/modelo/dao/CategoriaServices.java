/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Categoria;
import java.util.*;
/**
 *
 * @author ASUS
 */
public interface CategoriaServices {
    public List<Categoria> consultar();
    public Categoria consultarId(Categoria categoria);
    public int agregarCategoria(Categoria categoria);    
}
