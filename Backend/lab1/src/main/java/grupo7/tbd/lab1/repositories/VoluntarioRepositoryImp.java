package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository {
    @Autowired
    private Sql2o sql2o;

    //GET ALL
    @Override
    public List<Voluntario> getAllVoluntarios() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //GET BY ID
    @Override
    public List<Voluntario> getVoluntario(int id) {
        String sql = "SELECT * FROM voluntario WHERE voluntario.id = :id";
        List<Voluntario> item = null;
        try(Connection con = sql2o.open()){
            item = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetch(Voluntario.class);
            return item;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //--CREATE

    /**
     *
     * @param voluntario
     * @param disponibilidad
     * @return
     */
    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO voluntario (nombre, disponibilidad, telefono, direccion, correo_electronico, rut, ubicacion, deleted) values (:nombre, :disponibilidad, :telefono, :direccion, :correo_electronico, :rut, :ubicacion, :deleted)", true)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("disponibilidad", voluntario.getDisponibilidad())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("direccion", voluntario.getDireccion())
                    .addParameter("correo_electronico", voluntario.getCorreo_electronico())
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("ubicacion", voluntario.getUbicacion())
                    .addParameter("deleted", voluntario.getDeleted())
                    .executeUpdate().getKey();
            return voluntario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void deleteVoluntario(int id) {
        String deleteSql = "DELETE FROM voluntario WHERE id = :id";
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
    public void updateVoluntario(Voluntario voluntario, int id){
        String updateSql = "UPDATE voluntario SET nombre= :nombre, disponibilidad = :disponibilidad, telefono = :telefono, direccion = :direccion, correo_electronico = :correo_electronico, rut = :rut, ubicacion = :ubicacion, deleted = :deleted where id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(updateSql)
            .addParameter("name", voluntario.getNombre())
            .addParameter("disponibilidad", voluntario.getDisponibilidad())
            .addParameter("telefono", voluntario.getTelefono())
            .addParameter("direccion", voluntario.getDireccion())
            .addParameter("correo_electronico", voluntario.getCorreo_electronico())
            .addParameter("rut", voluntario.getRut())
            .addParameter("ubicacion", voluntario.getUbicacion())
            .addParameter("deleted", voluntario.getDeleted())
            .addParameter("id", id)
            .executeUpdate();
            return;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}

