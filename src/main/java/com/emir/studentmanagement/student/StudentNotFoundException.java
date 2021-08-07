package com.emir.studentmanagement.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such student")
public class StudentNotFoundException extends RuntimeException {

}

