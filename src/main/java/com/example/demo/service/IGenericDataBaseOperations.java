package com.example.demo.service;

public interface IGenericDataBaseOperations {
	
	public Object insert(Object objectToInsert) throws Exception;
	
	public Object delete(Object objectToDelete) throws Exception;
	
	public Object update(Long idUsr, Object modifiedObject) throws Exception;
	
	public Object getObjectByEmail(String email) throws Exception;
	
}
