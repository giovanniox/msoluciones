package cl.msoluciones.infraestructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.msoluciones.infraestructure.entities.EquipoEntity;


@Repository
public interface JpaEquipoRepository extends JpaRepository<EquipoEntity, Long>{
}
