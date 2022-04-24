package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Vol_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;

@Repository
public class Vol_habilidadRepositoryImp implements Vol_habilidadRepository {
    @Autowired
    private Sql2o sql2o;

    //GET ALL
    @Override
    public List<Vol_Habilidad> getAllVol_habilidades() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad")
                    .executeAndFetch(Vol_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //GET BY ID
    @Override
    public List<Vol_Habilidad> getVol_habilidad(int id) {
        String sql = "SELECT * FROM vol_habilidad WHERE vol_habilidad.id = :id";
        List<Vol_Habilidad> item = null;
        try(Connection con = sql2o.open()){
            item = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetch(Vol_Habilidad.class);
            return item;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //--CREATE
    @Override
    public Vol_Habilidad createVol_habilidad(Vol_Habilidad vol_habilidad) {

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO vol_habilidad (id_voluntario, id_habilidad, deleted) values (:id_voluntario, :id_habilidad, :deleted)", true)
                    .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
                    .addParameter("deleted", vol_habilidad.getDeleted())
                    .executeUpdate().getKey();
            return vol_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void deleteVol_habilidad(int id) {
        String deleteSql = "DELETE FROM vol_habilidad WHERE id = :id";
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
    public void updateVol_habilidad(Vol_Habilidad vol_habilidad, int id){
        String updateSql = "UPDATE vol_habilidad SET id_voluntario = :id_voluntario, id_habilidad = :id_habilidad, deleted = :deleted where id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(updateSql)
            .addParameter("id_voluntario", vol_habilidad.getId_voluntario())
            .addParameter("id_habilidad", vol_habilidad.getId_habilidad())
            .addParameter("deleted", vol_habilidad.getDeleted())
            .addParameter("id", id)
            .executeUpdate();
            return;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


