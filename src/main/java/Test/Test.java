/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import com.edu.ufps.gestion_gastos.modelo.entity.Historial;

/**
 *
 * @author Royner Omaña
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Historial h = new Historial(); 
        
        h.verDetalle();
        h.saldo();
    }
    
}
