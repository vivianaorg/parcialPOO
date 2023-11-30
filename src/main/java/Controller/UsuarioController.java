/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import com.edu.ufps.gestion_gastos.modelo.dao.UsuarioDao;
import com.edu.ufps.gestion_gastos.modelo.entity.Usuario;
import java.util.List;
/**
 *
 * @author Juan
 */
public class UsuarioController {
    UsuarioDao usuario = new UsuarioDao();
    
    public List<Usuario> consultar(){
        return usuario.consultar();
    }
    public boolean iniciarSesion(Usuario UsuarioD){
        return usuario.iniciarSesion(UsuarioD);
    }
    
    public int crear(Usuario UsuarioD){
        return usuario.crear(UsuarioD);
    }
    
    public int eliminar(Usuario UsuarioD){
        return usuario.eliminar(UsuarioD);
    }
    
    public int actualizar(Usuario UsuarioD){
        return usuario.acutalizar(UsuarioD);
    }
    
    public boolean iniciarConGoogle(Usuario UsuarioD){
        return usuario.iniciarConGoogle(UsuarioD);
    }
}
