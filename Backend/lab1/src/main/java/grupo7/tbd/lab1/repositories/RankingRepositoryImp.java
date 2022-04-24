/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Ranking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    @Autowired
    private Sql2o sql2o;

    //GET ALL
    @Override
    public List<Ranking> getAllRankings() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ranking")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //GET BY ID
    @Override
    public List<Ranking> getRanking(int id) {
        String sql = "SELECT * FROM ranking WHERE ranking.id = :id";
        List<Ranking> item = null;
        try(Connection con = sql2o.open()){
            item = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetch(Ranking.class);
            return item;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //--CREATE
    @Override
    public Ranking createRanking(Ranking ranking) {

        try(Connection conn = sql2o.open()){
            conn.createQuery("INSERT INTO ranking (valor, id_tarea, id_voluntario, deleted) values (:valor, :id_tarea, :id_voluntario, :deleted)", true)
                    .addParameter("valor", ranking.getValor())
                    .addParameter("id_tarea", ranking.getId_tarea())
                    .addParameter("id_voluntario", ranking.getId_voluntario())
                    .addParameter("deleted", ranking.getDeleted())
                    .executeUpdate().getKey();
            return ranking;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //DELETE
    @Override
    public void deleteRanking(int id) {
        String deleteSql = "DELETE FROM ranking WHERE id = :id";
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
    public void updateRanking(Ranking ranking, int id){
        String updateSql = "UPDATE ranking SET valor = :valor, id_tarea = :id_tarea, id_voluntario = :id_voluntario, deleted = :deleted where id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(updateSql)
            .addParameter("valor", ranking.getValor())
            .addParameter("id_tarea", ranking.getId_tarea())
            .addParameter("id_voluntario", ranking.getId_voluntario())
            .addParameter("deleted", ranking.getDeleted())
            .addParameter("id", id)
            .executeUpdate();
            return;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


