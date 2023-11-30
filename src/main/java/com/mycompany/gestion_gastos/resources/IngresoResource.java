/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_gastos.resources;
import com.edu.ufps.gestion_gastos.modelo.entity.Ingreso;
import controller.IngresoController;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Laura Caballero
 */
@Path("/ingreso")
public class IngresoResource {
    IngresoController ingresoController = new IngresoController();
    
    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }
    
    @GET
    @Path("/ingresos/")
    @Produces (MediaType.APPLICATION_JSON)
    
    public Response getIngresos(){
        List<Ingreso> ingresos = new ArrayList();
        ingresos = ingresoController.consultar();
        return Response
                .status(200)
                .header("Access-Control-Allow-origin", "*")
                .entity(ingresos)
                .build();
    }
   
    @GET
    @Path("/ingresos/{monto}")
    @Produces (MediaType.APPLICATION_JSON)
    public Response getTotal(@PathParam("monto") int monto){
        Ingreso ingreso = new Ingreso(monto);
        int total = ingresoController.total(ingreso);
        
        return Response
                .status(200)
                .header("Access-Control-Allow-origin", "*")
                .entity(total)
                .build();
        
    }
    
    @POST
    @Path("/ingresos/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crear(Ingreso ingreso){
        try{
            ingresoController.crear(ingreso);
            return Response.status(Response.Status.CREATED).entity(ingreso).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
    
    @DELETE
    @Path("/ingresos/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@PathParam("id") int id) {
        Ingreso ingreso = new Ingreso(id);
        int i = ingresoController.eliminar(ingreso);
        if (i == 0) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Access-Control-Allow-Origin", "*")
                    .entity("Ingreso not found")
                    .build();
        } else {
            return Response.ok("Correcto").build();
        }
    }
    
}
