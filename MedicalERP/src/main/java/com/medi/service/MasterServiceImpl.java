package com.medi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medi.dao.MasterDao;
import com.medi.domain.UserDomain;

import org.json.JSONException;
import org.json.JSONObject;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterDao masterDao;

	@Override
	public String loginWeb(String username, String password) {
		System.out.println("Service Call");
		return masterDao.loginWeb(username, password);
	}

	@Override
	public String createUser(String userDetails) {

		UserDomain userPojo = new UserDomain();

		JSONObject jsonObj;
		
		try {
			jsonObj = new JSONObject(userDetails);
			userPojo.setId(jsonObj.getInt("id"));
			userPojo.setName(jsonObj.getString("name"));
			userPojo.setEmail(jsonObj.getString("email"));
			userPojo.setMobileNumber(jsonObj.getInt("mobileNumber"));
			userPojo.setUsername(jsonObj.getString("username"));
			userPojo.setPassword(jsonObj.getString("password"));
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		return masterDao.createUser(userPojo);

	}

	@Override
	public String getListOfUser() {
		
		return masterDao.getListOfUser();
	}

	@Override
	public String getParticularUser(String id) {
		return masterDao.getParticularUser(id);

	}       
	@Override
	public String updateUser(String userRecord, int id) {

		UserDomain userPojo = new UserDomain();

		JSONObject jsonObj;
		
		try {
			jsonObj = new JSONObject(userRecord);
			//userPojo.setId(jsonObj.getInt("id"));
			userPojo.setName(jsonObj.getString("name"));
			userPojo.setEmail(jsonObj.getString("email"));
			userPojo.setMobileNumber(jsonObj.getInt("mobileNumber"));
			userPojo.setUsername(jsonObj.getString("username"));
			userPojo.setPassword(jsonObj.getString("password"));
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		return masterDao.updateUser(userPojo,id);

	}

	@Override
	public String deleteUser(int id) {
	
		return masterDao.deleteUser(id);
	}

	
	

}
