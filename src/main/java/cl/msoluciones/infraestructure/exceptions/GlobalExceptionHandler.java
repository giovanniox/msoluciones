package cl.msoluciones.infraestructure.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


   //// Manejo de InvalidTokenException
   //@ExceptionHandler(InvalidTokenException.class)
   //public ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException ex, WebRequest request) {
   //    logger.error("Token inválido: {}", ex.getMessage());
   //    return new ResponseEntity<>("El token proporcionado no es válido o ha expirado.", HttpStatus.BAD_REQUEST);
   //}

     // // Manejo de InvalidTokenException
     // @ExceptionHandler(MailSendingException.class)
     // public ResponseEntity<Object> handleMailSendingException(MailSendingException ex, WebRequest request) {
     //     logger.error("Token inválido: {}", ex.getMessage());
     //     return new ResponseEntity<>("Error al enviar correo.", HttpStatus.INTERNAL_SERVER_ERROR);
     // }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        logger.error("Unhandled error: {}", ex.getMessage(), ex);
        return new ResponseEntity<>("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
