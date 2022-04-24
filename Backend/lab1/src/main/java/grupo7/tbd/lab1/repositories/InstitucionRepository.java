/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.tbd.lab1.repositories;

import grupo7.tbd.lab1.models.Institucion;
import java.util.List;

public interface InstitucionRepository{

    public Institucion createInstitucion(Institucion institucion);
    public List<Institucion> getInstituciones();  
    public Institucion getInstitucion(Long id);
    public Institucion updateInstitucion(Institucion institucion, Long id);
    public boolean deleteInstitucion(Long id);
    public Long countInstitucion();
}
