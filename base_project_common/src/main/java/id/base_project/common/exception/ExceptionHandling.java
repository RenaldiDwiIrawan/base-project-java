package id.base_project.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandling {

//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseMahasiswa handlingEntityException(EntityNotFoundException ex){
//        ResponseMahasiswa response = new ResponseMahasiswa();
//        response.setStatus(HttpStatus.NOT_FOUND);
//        return response;
//    }
}
