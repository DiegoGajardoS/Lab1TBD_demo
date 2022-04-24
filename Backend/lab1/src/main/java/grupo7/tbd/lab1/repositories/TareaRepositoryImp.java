package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Tarea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class TareaRepositoryImp implements TareaRepository{
    @Autowired
    private Sql2o sql2o;

    //GET ALL
    @Override
    public List<Tarea> getAllTareas() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea")
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //GET BY ID
    @Override
    public List<Tarea> getTarea(int id) {
        String sql = "SELECT * FROM tarea WHERE tarea.id = :id";
        List<Tarea> item = null;
        try(Connection con = sql2o.open()){
            item = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetch(Tarea.class);
            return item;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //--CREATE
    @Override
    public Tarea createTarea(Tarea tarea) {

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO tarea (titulo, descripcion, cant_voluntarios, id_estado, id_emergencia, deleted) values (:titulo, :descripcion, :cant_voluntarios, :id_estado, :id_emergencia, :deleted)", true)
                    .addParameter("titulo", tarea.getTitulo())
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("cant_voluntarios", tarea.getCant_voluntarios())
                    .addParameter("id_estado", tarea.getId_estado())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("deleted", tarea.getDeleted())
                    .executeUpdate().getKey();
            return tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void deleteTarea(int id) {
        String deleteSql = "DELETE FROM tarea WHERE id = :id";
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
    public void updateTarea(Tarea tarea, int id){
        String updateSql = "UPDATE tarea SET titulo = :titulo, descripcion = :descripcion, cant_voluntarios = :cant_voluntarios, id_estado = :id_estado, id_emergencia = :id_emergencia, deleted = :deleted where id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(updateSql)
            .addParameter("titulo", tarea.getTitulo())
            .addParameter("descripcion", tarea.getDescripcion())
            .addParameter("cant_voluntarios", tarea.getCant_voluntarios())
            .addParameter("id_estado", tarea.getId_estado())
            .addParameter("id_emergencia", tarea.getId_emergencia())
            .addParameter("deleted", tarea.getDeleted())
            .addParameter("id", id)
            .executeUpdate();
            return;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

