package org.wipro.rest_crud.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wipro.rest_crud.dto.Student;

import lombok.Data;



@Component
@Data
public class ResponseStructure<L> //whyv<L> generics cuz, it will except whichever data u pass like list, single object
{
	private String message;
	private int status;
	//private Student data;
	L Data;
	


	

}
