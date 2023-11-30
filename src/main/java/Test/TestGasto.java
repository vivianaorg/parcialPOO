/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import com.edu.ufps.gestion_gastos.modelo.dao.GastoDao;
import com.edu.ufps.gestion_gastos.modelo.entity.Gasto;
import com.edu.ufps.gestion_gastos.modelo.dao.CategoriaDao;
import com.edu.ufps.gestion_gastos.modelo.entity.Categoria;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class TestGasto {

    public static void main(String[] args) {
        GastoDao d = new GastoDao();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //CategoriaDao c = new CategoriaDao();
        LocalDate f1 = LocalDate.now();
        String f1s = f1.toString(); // En formato por defecto ISO yyyy-MM-dd

        LocalDate f2 = LocalDate.now().minusDays(40);
        String f2s = f2.toString(); // En formato por defecto ISO yyyy-MM-dd

        // Convertir a Date
        Date f1Date = Date.from(f1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date f2Date = Date.from(f2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        Categoria categoria = new Categoria(1);
        // Agregar gastos con fechas formateadas
        //int r = d.agregarGasto(new Gasto(2,categoria, 2000, f1Date));
        int a = d.agregarGasto(new Gasto(3,categoria, 3400, f2Date));
        //System.out.println("" + d.consultar());
        //System.out.println("Gastos totales: " +d.total(new Gasto()));
        
        /*int categoria = c.agregarCategoria(new Categoria(2,"Educacion"));
        int categoria2 = c.agregarCategoria(new Categoria(3,"Entretenimiento"));
        int c3 = c.agregarCategoria(new Categoria(4,"Ropa"));
        int c4 = c.agregarCategoria(new Categoria(5,"Salud"));
        int c5 = c.agregarCategoria(new Categoria(6,"Servicios"));
        int c6 = c.agregarCategoria(new Categoria(7,"Transporte"));
        int c7 = c.agregarCategoria(new Categoria(8,"Viajes"));
        int c8 = c.agregarCategoria(new Categoria(9,"Negocio"));
        int c9 = c.agregarCategoria(new Categoria(10,"Deportes"));
        int c10 = c.agregarCategoria(new Categoria(11,"Compras"));
        int c11 = c.agregarCategoria(new Categoria(12,"Otros"));*/
        
        //System.out.println(r);
        System.out.println(a);
        
        System.out.println(d.gastoFecha());
        System.out.println(""+d.consultar());
    }
}
