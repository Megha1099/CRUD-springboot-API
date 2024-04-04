package org.wipro.rest_crud.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wipro.rest_crud.helper.ResponseStructure;

@RestControllerAdvice
public class MyExceptionHandler
{
	@Autowired
	ResponseStructure structure;
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handle(DataNotFoundException exception) {
		structure.setData(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_GATEWAY.value());
		structure.setMessage("data not found");
//		return new ResponseEntity<ResponseStructure<L>>(structure , HttpStatus.NOT_FOUND.value()));
		return  new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
		
	}

}
