package cl.msoluciones.infraestructure.entities;

import lombok.Data;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class EquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipo;
    private String marca;
    private String modelo;
    private String serie;
    private String inventario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private List<MantenimientoPreventivoEntity> mantenimientosPreventivos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private List<MantenimientoCorrectivoEntity> mantenimientosCorrectivos;
}


