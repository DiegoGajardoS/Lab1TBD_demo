/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Eme_Habilidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class Eme_HabilidadRepositoryImp implements Eme_HabilidadRepository {
    @Autowired
     private Sql2o sql2o;

     @Override
     public Long countEme_Habilidad(){
         String query = "select count(*) from eme_habilidad";
         Connection conn = sql2o.open();
         Long resultado = (Long) conn.createQuery(query,true).executeAndFetchFirst(Long.class);
         return resultado + 1; 
     }
 
    
    @Override
    public Eme_Habilidad createEme_Habilidad(Eme_Habilidad eme_habilidad){
        Long id_emeH = countEme_Habilidad();
        String query = "insert into eme_habilidad (id, id_emergencia,id_habilidad) values (:id, :id_emergencia,:id_habilidad)";
        try(Connection conn = sql2o.open()){
            conn.createQuery(query,true).addParameter("id",id_emeH)
                .addParameter("id_emergencia", eme_habilidad.getIdEmergencia())
                .addParameter("id_habilidad", eme_habilidad.getIdHabilidad())
                .executeUpdate().getKey();
            eme_habilidad.setId(id_emeH);
            return eme_habilidad;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Eme_Habilidad getEme_Habilidad(Long id){
        String query = "select * from eme_habilidad where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).addParameter("id",id).executeAndFetchFirst(Eme_Habilidad.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public  List<Eme_Habilidad> getEme_Habilidades() {
        String query = "select * from eme_habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(query).executeAndFetch(Eme_Habilidad.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteEme_Habilidad(Long id){
        String query = "update eme_habilidad set deleted = true where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            id = conn.createQuery(query).addParameter("id",id).executeUpdate().getKey(Long.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override 
    public Eme_Habilidad updateEme_Habilidad(Eme_Habilidad eme_habilidad, Long id){
        String query = "update eme_habilidad set id_emergencia = :id_emergencia, id_habilidad = :id_habilidad  where id = :id and deleted = false";
        try(Connection conn = sql2o.open()){
            Long insertedid = (Long) conn.createQuery(query,true)
            .addParameter("id", id)
            .addParameter("id_emergencia", eme_habilidad.getIdEmergencia())
                            .addParameter("id_habilidad", eme_habilidad.getIdHabilidad())
                            .executeUpdate().getKey(Long.class);
            eme_habilidad.setId(insertedid);
            return eme_habilidad;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    
}
