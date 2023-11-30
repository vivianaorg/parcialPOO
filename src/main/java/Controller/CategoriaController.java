/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import com.edu.ufps.gestion_gastos.modelo.entity.Categoria;
import com.edu.ufps.gestion_gastos.modelo.dao.CategoriaDao;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class CategoriaController {
    CategoriaDao categoriaD = new CategoriaDao();
    public List<Categoria> consultar(){
        return categoriaD.consultar();
    }
    
    public Categoria consultarId(Categoria categoria){
        return categoriaD.consultarId(categoria);
    }
    
    public int agregarCategoria(Categoria categoria){
        return categoriaD.agregarCategoria(categoria);
    }
}
