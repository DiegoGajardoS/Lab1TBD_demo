/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.models;

public class Institucion{
 
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String dominio;
    private boolean deleted;

    //***** GETTERS *****//

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDominio() {
        return dominio;
    }

    public String getTelefono(){
        return telefono;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    //***** SETTERS *****//

    public void setId(Long id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setDominio(String dominio){
        this.dominio = dominio;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


}
