package cl.msoluciones.domain.model;

import lombok.Data;
import java.util.List;


@Data
public class EquipoModel {

    private Long id;

    private String equipo;
    private String marca;
    private String modelo;
    private String serie;
    private String inventario;

    private List<MantenimientoPreventivoModel> mantenimientosPreventivos;

    private List<MantenimientoCorrectivoModel> mantenimientosCorrectivos;
}


