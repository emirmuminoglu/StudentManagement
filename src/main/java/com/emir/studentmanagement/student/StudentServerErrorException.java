package com.emir.studentmanagement.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Unknown error")
public class StudentServerErrorException extends RuntimeException {
  public Exception InnerException;

  public StudentServerErrorException(Exception ex) {
    InnerException = ex;
  }
}
