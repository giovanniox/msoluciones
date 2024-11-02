package cl.msoluciones.aplication.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import cl.msoluciones.domain.model.EquipoModel;
import cl.msoluciones.domain.ports.in.PdfUseCase;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PdfService implements PdfUseCase {

    private final TemplateEngine templateEngine;

    @Override
    public byte[] generarPdfEquipos(List<EquipoModel> equipos) throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();

        // Crear el documento PDF concatenado
        renderer.setDocumentFromString("<html><body></body></html>"); // Documento inicial
        renderer.layout();

        // Variable para almacenar el contenido HTML acumulado
        StringBuilder htmlBuilder = new StringBuilder("<html><body>");

        for (int i = 0; i < equipos.size(); i++) {
            EquipoModel equipo = equipos.get(i);
            Context context = new Context();
            context.setVariable("equipo", equipo);

            // Procesar la plantilla HTML para cada equipo
            String htmlContent = templateEngine.process("pdf-template", context);

            // Añadir el contenido HTML procesado al acumulador
            htmlBuilder.append(htmlContent);

            // Añadir salto de página después de cada equipo, excepto el último
            if (i < equipos.size() - 1) {
                htmlBuilder.append("<div style='page-break-after: always;'></div>");
            }
        }

        // Cerrar el cuerpo HTML
        htmlBuilder.append("</body></html>");

        // Establecer el documento con todo el contenido acumulado
        renderer.setDocumentFromString(htmlBuilder.toString());
        renderer.layout();

        // Crear el PDF combinado en el output stream
        renderer.createPDF(byteArrayOutputStream, true);

        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte[] generarPdfEquipo(EquipoModel equipo) throws DocumentException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();

        // Crear el documento PDF concatenado
        renderer.setDocumentFromString("<html><body></body></html>"); // Documento inicial
        renderer.layout();

        // Variable para almacenar el contenido HTML acumulado
        StringBuilder htmlBuilder = new StringBuilder("<html><body>");

        Context context = new Context();
        context.setVariable("equipo", equipo);

        // Procesar la plantilla HTML para cada equipo
        String htmlContent = templateEngine.process("pdf-template", context);

        // Añadir el contenido HTML procesado al acumulador
        htmlBuilder.append(htmlContent);

        // Cerrar el cuerpo HTML
        htmlBuilder.append("</body></html>");

        // Establecer el documento con todo el contenido acumulado
        renderer.setDocumentFromString(htmlBuilder.toString());
        renderer.layout();

        // Crear el PDF combinado en el output stream
        renderer.createPDF(byteArrayOutputStream, true);

        return byteArrayOutputStream.toByteArray();
    }
}
