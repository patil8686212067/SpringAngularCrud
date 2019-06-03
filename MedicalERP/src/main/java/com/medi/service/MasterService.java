package com.medi.service;

public interface MasterService {
 
	public String loginWeb(String username,String password);
	
	String createUser(String userDetails);
	
	public String getListOfUser();
	
	public String getParticularUser(String id);
	
	public String updateUser(String userRecord, int id);
	
	public String deleteUser(int id);

	
}
