/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.ufps.gestion_gastos.modelo.entity;

/**
 *
 * @author Juan
 */
public class Usuario {
    private String email;
    private String nombre;
    private String contraseña;

    public Usuario(String email, String nombre, String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public Usuario(String email){
        this.email = email;
    }
    
    public Usuario(){
        
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nombre=" + nombre + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
}
