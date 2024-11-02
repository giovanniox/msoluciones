package cl.msoluciones.aplication.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.domain.model.MantenimientoCorrectivoModel;
import cl.msoluciones.domain.model.MantenimientoPreventivoModel;
import cl.msoluciones.infraestructure.entities.EquipoEntity;
import cl.msoluciones.infraestructure.entities.MantenimientoCorrectivoEntity;
import cl.msoluciones.infraestructure.entities.MantenimientoPreventivoEntity;

@Component
public class EquipoMapper {

    public EquipoModel toModel(EquipoEntity equipoEntity) {
        EquipoModel equipoModel = new EquipoModel();
        equipoModel.setId(equipoEntity.getId());
        equipoModel.setEquipo(equipoEntity.getEquipo());
        equipoModel.setMarca(equipoEntity.getMarca());
        equipoModel.setModelo(equipoEntity.getModelo());
        equipoModel.setSerie(equipoEntity.getSerie());
        equipoModel.setInventario(equipoEntity.getInventario());

        // Convertir listas de mantenimientos preventivos
        List<MantenimientoPreventivoModel> mantenimientoPreventivoModels = equipoEntity.getMantenimientosPreventivos()
                .stream()
                .map(this::toMantenimientoPreventivoModel)
                .collect(Collectors.toList());
        equipoModel.setMantenimientosPreventivos(mantenimientoPreventivoModels);

        // Convertir listas de mantenimientos correctivos
        List<MantenimientoCorrectivoModel> mantenimientoCorrectivoModels = equipoEntity.getMantenimientosCorrectivos()
        .stream()
        .map(this::toMantenimientoCorrectivoModel)
        .collect(Collectors.toList());
                    equipoModel.setMantenimientosCorrectivos(mantenimientoCorrectivoModels);
        return equipoModel;
    }

    public EquipoEntity toEntity(EquipoModel equipoModel) {
        EquipoEntity equipoEntity = new EquipoEntity();
        equipoEntity.setId(equipoModel.getId());
        equipoEntity.setEquipo(equipoModel.getEquipo());
        equipoEntity.setMarca(equipoModel.getMarca());
        equipoEntity.setModelo(equipoModel.getModelo());
        equipoEntity.setSerie(equipoModel.getSerie());
        equipoEntity.setInventario(equipoModel.getInventario());

        // Convertir listas de mantenimientos preventivos
        List<MantenimientoPreventivoEntity> mantenimientoPreventivoEntities = equipoModel.getMantenimientosPreventivos()
                .stream()
                .map(this::toMantenimientoPreventivoEntity)
                .collect(Collectors.toList());
        equipoEntity.setMantenimientosPreventivos(mantenimientoPreventivoEntities);

        // Convertir listas de mantenimientos corecctivos
        List<MantenimientoCorrectivoEntity> mantenimientoCorrectivoEntities = equipoModel.getMantenimientosCorrectivos()
                .stream()
                .map(this::toMantenimientoCorrectivoEntity)
                .collect(Collectors.toList());
        equipoEntity.setMantenimientosCorrectivos(mantenimientoCorrectivoEntities);

        return equipoEntity;
    }

    private MantenimientoPreventivoModel toMantenimientoPreventivoModel(MantenimientoPreventivoEntity entity) {
        MantenimientoPreventivoModel model = new MantenimientoPreventivoModel();
        model.setId(entity.getId());
        model.setFecha(entity.getFecha());
        model.setNumeroOT(entity.getNumeroOT());
        model.setResponsable(entity.getResponsable());
        model.setTipoDeTrabajo(entity.getTipoDeTrabajo());
        return model;
    }

    private MantenimientoPreventivoEntity toMantenimientoPreventivoEntity(MantenimientoPreventivoModel model) {
        MantenimientoPreventivoEntity entity = new MantenimientoPreventivoEntity();
        entity.setId(model.getId());
        entity.setFecha(model.getFecha());
        entity.setNumeroOT(model.getNumeroOT());
        entity.setResponsable(model.getResponsable());
        entity.setTipoDeTrabajo(model.getTipoDeTrabajo());
        return entity;
    }

    private MantenimientoCorrectivoModel toMantenimientoCorrectivoModel(MantenimientoCorrectivoEntity entity) {
        MantenimientoCorrectivoModel model = new MantenimientoCorrectivoModel();
        model.setId(entity.getId());
        model.setFecha(entity.getFecha());
        model.setNumeroOT(entity.getNumeroOT());
        model.setResponsable(entity.getResponsable());
        model.setTipoDeTrabajo(entity.getTipoDeTrabajo());
        return model;
    }

    private MantenimientoCorrectivoEntity toMantenimientoCorrectivoEntity(MantenimientoCorrectivoModel model) {
        MantenimientoCorrectivoEntity entity = new MantenimientoCorrectivoEntity();
        entity.setId(model.getId());
        entity.setFecha(model.getFecha());
        entity.setNumeroOT(model.getNumeroOT());
        entity.setResponsable(model.getResponsable());
        entity.setTipoDeTrabajo(model.getTipoDeTrabajo());
        return entity;
    }
}