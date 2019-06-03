package com.medi.dao;

import com.medi.domain.UserDomain;

public interface MasterDao {
	public String loginWeb(String username,String password);
    String createUser(UserDomain userPojo);
	public String getListOfUser();
	public String getParticularUser(String id);
	public String updateUser(UserDomain user, int id);
	public String deleteUser(int id);
	


}
