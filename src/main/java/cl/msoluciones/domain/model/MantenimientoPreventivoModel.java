package cl.msoluciones.domain.model;

import lombok.Data;

@Data
public class MantenimientoPreventivoModel {

    private Long id;
    private String fecha;
    private String numeroOT;
    private String responsable;
    private String tipoDeTrabajo = "preventivo";
}
