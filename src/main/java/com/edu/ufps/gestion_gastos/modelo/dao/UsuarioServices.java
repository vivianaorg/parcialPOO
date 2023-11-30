/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.dao;

import com.edu.ufps.gestion_gastos.modelo.entity.Usuario;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface UsuarioServices {
    public List<Usuario> consultar();
    public boolean iniciarSesion(Usuario usuario );
    public int crear(Usuario usuario );
    public int eliminar(Usuario usuario );
    public int acutalizar (Usuario usuario );
    public boolean iniciarConGoogle(Usuario usuario);
}
