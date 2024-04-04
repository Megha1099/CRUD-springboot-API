package org.wipro.rest_crud.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataNotFoundException extends RuntimeException
{
 String message="Data not found";
}
