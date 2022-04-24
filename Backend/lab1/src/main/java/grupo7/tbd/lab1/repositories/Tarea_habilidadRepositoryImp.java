package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Tarea_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;

@Repository
public class Tarea_habilidadRepositoryImp implements Tarea_habilidadRepository{
    @Autowired
    private Sql2o sql2o;

    //GET ALL
    @Override
    public List<Tarea_Habilidad> getAllTarea_habilidades() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad")
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //GET BY ID
    @Override
    public List<Tarea_Habilidad> getTarea_habilidad(int id) {
        String sql = "SELECT * FROM tarea_habilidad WHERE tarea_habilidad.id = :id";
        List<Tarea_Habilidad> item = null;
        try(Connection con = sql2o.open()){
            item = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetch(Tarea_Habilidad.class);
            return item;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //--CREATE
    @Override
    public Tarea_Habilidad createTarea_habilidad(Tarea_Habilidad tarea_habilidad) {

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO tarea_habilidad (id_tarea, id_eme_habilidad, deleted) values (:id_tarea, :id_eme_habilidad, :deleted)", true)
                    .addParameter("id_tarea", tarea_habilidad.getId_tarea())
                    .addParameter("id_eme_habilidad", tarea_habilidad.getId_eme_habilidad())
                    .addParameter("deleted", tarea_habilidad.getDeleted())
                    .executeUpdate().getKey();
            return tarea_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void deleteTarea_habilidad(int id) {
        String deleteSql = "DELETE FROM tarea_habilidad WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(deleteSql)
            .addParameter("id", id)
            .executeUpdate();
            return;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    //--UPDATE
    @Override
    public void updateTarea_habilidad(Tarea_Habilidad tarea_habilidad, int id){
        String updateSql = "UPDATE tarea_habilidad SET id_tarea = :id_tarea , id_eme_habilidad = :id_eme_habilidad, deleted = :deleted where id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(updateSql)
            .addParameter("id_tarea", tarea_habilidad.getId_tarea())
            .addParameter("id_eme_habilidad", tarea_habilidad.getId_eme_habilidad())
            .addParameter("deleted", tarea_habilidad.getDeleted())

            .addParameter("id", id)
            .executeUpdate();
            return;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


