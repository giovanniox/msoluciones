package cl.msoluciones.infraestructure.configs.app;

import java.io.ByteArrayOutputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.msoluciones.aplication.services.EquipoService;
import cl.msoluciones.aplication.services.PdfService;
import cl.msoluciones.aplication.usecases.EquipoUseCaseImpl;
import cl.msoluciones.aplication.usecases.PdfUseCaseImpl;
import cl.msoluciones.domain.ports.out.EquipoRepositoryPort;
import cl.msoluciones.domain.ports.out.PdfRepositoryPort;
import cl.msoluciones.infraestructure.entities.EquipoEntity;
import cl.msoluciones.infraestructure.repository.JpaEquipoRepositoryAdapter;

@Configuration
public class ApplicationConfig {



    @Bean
    public EquipoRepositoryPort equipoRepositoryPort(JpaEquipoRepositoryAdapter jpaUserRepositoryAdapter) {
        return jpaUserRepositoryAdapter;
    }
   
    @Bean
    public EquipoService equipoService(EquipoRepositoryPort equipoRepositoryPort) {
        EquipoUseCaseImpl equipoUseCase = new EquipoUseCaseImpl(equipoRepositoryPort);
        return new EquipoService(equipoUseCase);
    }



}
