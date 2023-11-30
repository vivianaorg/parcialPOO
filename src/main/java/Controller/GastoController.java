/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.edu.ufps.gestion_gastos.modelo.dao.CategoriaDao;
import com.edu.ufps.gestion_gastos.modelo.entity.Gasto;
import com.edu.ufps.gestion_gastos.modelo.dao.GastoDao;
import com.edu.ufps.gestion_gastos.modelo.entity.Categoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class GastoController {

    GastoDao gastoD = new GastoDao();

    public List<Gasto> consultar() {
        return gastoD.consultar();
    }

    public Gasto consultarId(Gasto gasto) {
        return gastoD.consultarId(gasto);
    }

    public int agregarGasto(Gasto gasto) {
        return gastoD.agregarGasto(gasto);
    }

    public int eliminar(Gasto gasto) {
        return gastoD.eliminar(gasto);
    }

    public int actualizar(Gasto gasto) {
        return gastoD.actualizar(gasto);
    }

    public List<Gasto> gastoFecha() {
        return gastoD.gastoFecha();
    }

    public List<Gasto> gastoMayor() {
        List<Gasto> gastosTotalesPorCategoria = new ArrayList<>();
        
        GastoDao gastoDao= new GastoDao();
        CategoriaDao categoriaDao = new CategoriaDao();
        List<Categoria> categorias = categoriaDao.consultar();
 
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            int total=gastoDao.sumaGastos(categoria.getId());
            Gasto gastoTotal = new Gasto(0, categoria, total, new java.util.Date());
        
           gastosTotalesPorCategoria.add(gastoTotal);
        }

        return gastosTotalesPorCategoria;
    }
    

}
