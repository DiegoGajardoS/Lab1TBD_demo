/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Ranking;
import java.util.List;

public interface RankingRepository {
    public List<Ranking> getAllRankings();
    public List<Ranking> getRanking(int id);
    public Ranking createRanking(Ranking ranking);
    public void updateRanking(Ranking ranking, int id);
    public void deleteRanking(int id);
}
