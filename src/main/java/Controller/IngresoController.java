/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import com.edu.ufps.gestion_gastos.modelo.dao.IngresoDao;
import com.edu.ufps.gestion_gastos.modelo.entity.Ingreso;
import java.util.List;
/**
 *
 * @author Laura Caballero
 */
public class IngresoController {
    IngresoDao ingreso = new IngresoDao();
    public List<Ingreso> consultar(){
        return ingreso.consultar();
    }
    public int total(Ingreso ingresoD){
        return ingreso.total(ingresoD);
    }
    
    public int crear(Ingreso ingresoD){
        return ingreso.crear(ingresoD);
    }
    
    public int eliminar(Ingreso ingresoD){
        return ingreso.eliminar(ingresoD);
    }
    
    public int actualizar(Ingreso ingresoD){
        return ingreso.acutalizar(ingresoD);
    }
}
