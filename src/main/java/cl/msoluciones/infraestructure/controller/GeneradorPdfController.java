package cl.msoluciones.infraestructure.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import cl.msoluciones.aplication.services.EquipoService;
import cl.msoluciones.aplication.services.PdfService;
import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.infraestructure.entities.EquipoEntity;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pdf")
public class GeneradorPdfController {

    private final EquipoService equipoService;
    private final PdfService pdfService;

    @GetMapping("/generate")
    public ResponseEntity<byte[]> generatePdf() {
        try {
            // Obtiene los datos de los equipos desde la base de datos
            List<EquipoModel> equipos = equipoService.listarEquipos();
            // Generar el PDF usando el servicio PdfService
            byte[] pdfBytes = pdfService.generarPdfEquipos(equipos);

            // Configurar headers de respuesta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "equipos_medicos.pdf");

            // Devolver el PDF
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/generate/{id}")
    public ResponseEntity<byte[]> generatePdfById(@PathVariable Long id) {
        try {
            // Obtiene el equipo específico desde la base de datos
            EquipoModel equipo = equipoService.buscarEquipoPorId(id);
            if (equipo == null) {
                return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el equipo
            }

            // Generar el PDF usando el servicio PdfService
            pdfService.generarPdfEquipo(equipo);
            byte[] pdfBytes = pdfService.generarPdfEquipo(equipo);
            // Configurar headers de respuesta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "equipo_" + id + ".pdf");

            // Devolver el PDF
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}