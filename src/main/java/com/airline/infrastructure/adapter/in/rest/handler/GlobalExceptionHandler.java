package com.airline.infrastructure.adapter.in.rest.handler;

import com.airline.domain.exception.*;
import com.airline.infrastructure.adapter.in.rest.controller.dto.response.ApiResponseDTO;
import com.airline.infrastructure.exception.ApiException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.airline.infrastructure.util.Constants.*;


/**
 * Manejador global de excepciones para toda la aplicación.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    
    /**
     * Gestiona DuplicateEmailException (excepción de la regla de negocio para correos electrónicos duplicados).
     *
     * @param ex      la DuplicateEmailException lanzada
     * @param request la solicitud HTTP actual
     * @return una respuesta de conflicto 409 con detalles del error
     */
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleDuplicateEmail(DuplicateEmailException ex, HttpServletRequest request) {
        log.warn("Email duplicado: {}", ex.getMessage());
        ApiResponseDTO<Void> response = ApiResponseDTO.error(
                ex.getMessage(),
                DUPLICATE_EMAIL,
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    /**
     * Maneja la excepción ReservationNotFoundException (reserva no encontrada en la lógica del dominio).
     *
     * @param ex      la excepción ReservationNotFoundException lanzada
     * @param request la solicitud HTTP actual
     * @return una respuesta 404 No encontrado con detalles del error
     */
    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleReservationNotFound(
            ReservationNotFoundException ex, HttpServletRequest request) {
        log.warn("Reserva no encontrada: {}", ex.getMessage());
        ApiResponseDTO<Void> response = ApiResponseDTO.error(
                ex.getMessage(),
                RESERVATION_NOT_FOUND,
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Maneja ResourceNotFoundException (recurso genérico faltante en la lógica del dominio).
     *
     * @param ex      la excepción ResourceNotFoundException lanzada
     * @param request la solicitud HTTP actual
     * @return una respuesta 404 No encontrado con detalles del error
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleResourceNotFound(
            ResourceNotFoundException ex, HttpServletRequest request) {
        log.warn("Recurso no encontrado: {}", ex.getMessage());
        ApiResponseDTO<Void> response = ApiResponseDTO.error(
                ex.getMessage(),
                RESOURCE_NOT_FOUND,
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Gestiona TicketNotFoundException (ticket no encontrado en la lógica del dominio).
     *
     * @param ex      la TicketNotFoundException lanzada
     * @param request la solicitud HTTP actual
     * @return una respuesta 404 No encontrado con detalles del error
     */
    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleTicketNotFound(
            TicketNotFoundException ex, HttpServletRequest request) {
        log.warn("Ticket no encontrado: {}", ex.getMessage());
        ApiResponseDTO<Void> response = ApiResponseDTO.error(
                ex.getMessage(),
                TICKET_NOT_FOUND,
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Maneja la excepción UserNotFoundException (usuario no encontrado en la lógica del dominio).
     *
     * @param ex      la excepción UserNotFoundException lanzada
     * @param request la solicitud HTTP actual
     * @return una respuesta 404 No encontrado con detalles del error
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleUserNotFound(
            UserNotFoundException ex, HttpServletRequest request) {
        log.warn("Usuario no encontrado: {}", ex.getMessage());
        ApiResponseDTO<Void> response = ApiResponseDTO.error(
                ex.getMessage(),
                USER_NOT_FOUND,
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Maneja excepciones personalizadas de tipo {@link ApiException}.
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleApiException(ApiException ex, HttpServletRequest request) {
        log.warn("Error controlado: [{}] {} - Path: {}", ex.getErrorCode(), ex.getMessage(), request.getRequestURI());
        ApiResponseDTO<Void> response = ApiResponseDTO.<Void>builder()
                .success(false)
                .message(ex.getMessage())
                .errorCode(ex.getErrorCode())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    /**
     * Maneja errores de validación de Bean Validation (@Valid).
     *
     * <p>Se lanza cuando un DTO no cumple las restricciones de validación
     * definidas con anotaciones como @NotBlank, @Email, @Size, etc.</p>
     *
     * @param ex      excepción de validación
     * @param request petición HTTP actual
     * @return respuesta con errores campo por campo
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {
        log.warn("Error de validación en: {}", request.getRequestURI());

        // Extraer errores campo por campo
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ApiResponseDTO<Void> response = ApiResponseDTO.validationError(
                VALIDATION_ERROR_MESSAGE,
                errors,
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Maneja errores no controlados (genéricos).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO<Void>> handleGenericException(Exception ex, HttpServletRequest request) {
        log.error("Error inesperado: ", ex);

        ApiResponseDTO<Void> response = ApiResponseDTO.<Void>builder()
                .success(false)
                .message(INTERNAL_ERROR_MESSAGE)
                .errorCode(INTERNAL_SERVER_ERROR)
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
