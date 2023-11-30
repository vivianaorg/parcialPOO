/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.entity;

import com.edu.ufps.gestion_gastos.modelo.dao.CategoriaDao;
import com.edu.ufps.gestion_gastos.modelo.dao.GastoDao;
import com.edu.ufps.gestion_gastos.modelo.dao.IngresoDao;
import java.util.List;

/**
 *
 * @author Royner Omaña
 */
public class Historial {
    private CategoriaDao categoriaDao;
    private IngresoDao ingresoDao;
    private GastoDao gastoDao;

    public Historial(CategoriaDao categoriaDao, IngresoDao ingresoDao, GastoDao gastoDao) {
        this.categoriaDao = categoriaDao;
        this.ingresoDao = ingresoDao;
        this.gastoDao = gastoDao;
    }

    public Historial() {
    }
    
    public void verDetalle() {
        List<Categoria> listaCategorias = categoriaDao.consultar();
        System.out.println("Detalle de Categorias:");
        for (Categoria categoria : listaCategorias) {
            System.out.println(categoria.toString());
        }

        List<Ingreso> listaIngresos = ingresoDao.consultar();
        System.out.println("Detalle de Ingresos:");
        for (Ingreso ingreso : listaIngresos) {
            System.out.println(ingreso.toString());
        }

        List<Gasto> listaGastos = gastoDao.consultar();
        System.out.println("Detalle de Gastos:");
        for (Gasto gasto : listaGastos) {
            System.out.println(gasto.toString());
        }
    }

    public void saldo() {
        int totalIngresos = ingresoDao.total(new Ingreso());
        int totalGastos = gastoDao.total(new Gasto());

        int saldo = totalIngresos - totalGastos;
        System.out.println("El saldo es: " + saldo);
    }
}

    

