package org.wipro.rest_crud.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue
	//@GenratedValue(strategy = GenerationType.IDENTITY)// it will generate the proper id, rather than giving the random number
	private int id;//id will be generated when we persist the date
	private String name;
	private long mobile;
	private int maths;
	private int science;
	private int english;
	private double percentage;
	private String result;
	
	

}
