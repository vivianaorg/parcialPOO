/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import com.edu.ufps.gestion_gastos.modelo.dao.UsuarioDao;
import com.edu.ufps.gestion_gastos.modelo.entity.Usuario;

/**
 *
 * @author juan
 */
public class TestUsuario {
    public static void main(String[] args) {
        UsuarioDao a = new UsuarioDao();
        Usuario b = new Usuario("sanguinorincon@gmail.com", "juan", "blablabla");
        Usuario c = new Usuario("vi@g.com", "maria", "123");
        a.crear(c);
        System.out.println(a.consultar());
        System.out.println(a.iniciarSesion(b));
    }
}
