package io.task.estl.rqmt.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ServiceExceptionHandler {

  @ExceptionHandler(Exception.class)
  public CustomErrorResponse commonHandleException(Exception e, HttpServletRequest request) {
    
    return builderMessage(500, "Internal Server Error", e.getMessage(), request);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public CustomErrorResponse handleMissingParams(MissingServletRequestParameterException e, HttpServletRequest request) {
    return builderMessage(400, "Bad Request", e.getMessage(), request);
  }

  private CustomErrorResponse builderMessage(int status, String ErrorKey, String message, HttpServletRequest request) {
    CustomErrorResponse errorResponse = new CustomErrorResponse();
    errorResponse.setTimestamp(LocalDateTime.now());
    errorResponse.setStatus(status);
    errorResponse.setError(ErrorKey);
    errorResponse.setMessage(message);
    errorResponse.setPath(request.getRequestURI());
    return errorResponse;
  }
}
