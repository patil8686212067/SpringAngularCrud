package com.medi.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medi.domain.UserDomain;

@Repository
public class MasterDaoImpl implements MasterDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String loginWeb(String username, String password) {

		List<Map<String, Object>> list = null;

		String loginQuery = "select * from user where username=? and password=?";
		try {
			list = jdbcTemplate.queryForList(loginQuery, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("query--<" + loginQuery);
		System.out.println("Result--<" + list);
		if(list.isEmpty()){
			return "false";
		}
		else {
			return "true";	
		}
	}
	
	//create user
	
	
	public String createUser(UserDomain user){
		int usercount=0;
    String queryToInsertuser="insert into user (id,name,email,mobileNumber,username,password) value(?,?,?,?,?,?)";
      
		
		try {
			     usercount=jdbcTemplate.update(queryToInsertuser,new Object[]{user.getId(),user.getName(),user.getEmail(),user.getMobileNumber()
					,user.getUsername(),user.getPassword()});
			
		    } catch (Exception e) {
				e.printStackTrace();
				return "{\"status\": \"Fail\",\"reason\": \"user Not Created\"}";
		   }
	
		   return "{\"status\": \"Success\",\"reason\": \"User Created Successfully\"}";
	   }
	
	@Override
	public String getListOfUser() {
		List<Map<String, Object>> allUserList = null;

		String queryToGetAllUser=" select * from user ";



		allUserList = jdbcTemplate.queryForList(queryToGetAllUser);

		JSONObject json = new JSONObject();

		if(allUserList.size() >= 0) {

			try {
				json.put("UsersList", allUserList);
			} catch (JSONException e) { 
				e.printStackTrace();
			}
		}

		return json.toString();

	}
	
	@Override 
	public String getParticularUser(String id) {

		String query =" select * from user where id=?";

		List<Map<String, Object>> userList = jdbcTemplate.queryForList(query,id);
		JSONObject json = new JSONObject();

		if(userList.size() >= 0) {
			try {
				json.put("userList", userList);

			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		return json.toString();
	}
	
	@Override
	@Transactional(rollbackFor={RuntimeException.class,Exception.class})
	public String updateUser(UserDomain user, int id) {
		
		int updateCount=0;
		try {
			
				String updateUserQuery= "update user set name = ? , email = ? , mobileNumber = ? , username = ? , password = ?  where id = ?";
				updateCount = jdbcTemplate.update(updateUserQuery, new Object[]{user.getName(),user.getEmail(),user.getMobileNumber(),user.getUsername(),user.getPassword(),id});
			
			}catch (Exception e) {
	          e.printStackTrace();
			}
			
			return "{\"status\": \"Success\",\"reason\": \"Ok\"}";
		  }
          
	@Override
	public String deleteUser(int id) {
		int deleteCount=0;
		String queryToDeleteUser= "delete from user where id=?";
		try{
			deleteCount = jdbcTemplate.update(queryToDeleteUser,id);
		}catch (Exception e) 
		{
	          e.printStackTrace();
	          if(deleteCount==0)
	          {
	        	  
	        	  return "unable to delete user ";
	          }
		}
		 
		return "{\"status\": \"Success\",\"reason\": \"Ok\"}";
	   }
	
}
 