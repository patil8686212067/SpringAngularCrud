package com.medi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.medi.service.MasterService;

@RestController
public class MasterController {
	
	@Autowired
	private MasterService masterService;
	
     @RequestMapping(value ="/test")
	 public String testApi()
	 {
		 System.out.println("hey anil  dude");
		return "hello anil";
	 }
     
	 @RequestMapping(value ="/login",method=RequestMethod.GET)
	 public String loginWeb(@RequestParam String username , @RequestParam String password)
	 {
		 System.out.println("Call Controller " + username + " "+ password);
		  String loginStatus=masterService.loginWeb(username, password);
		   System.out.println("loginStatus   "+loginStatus);
		   
				/* if(loginStatus.equalsIgnoreCase("true"))
				 {
						return "login succesfully ";
				  }else {
					 
				   return "login denied...!!";
					}*/
					 
		 
		    return "true";
				  
	 }
	 
	 //CURD OPERATION IN SPRING ANGUALR
	 
	   /***********Create user API**********/ 
	 @RequestMapping(value="/createuser",method=RequestMethod.POST, headers="accept=application/json")
		public ResponseEntity<?> createUserApi(@RequestBody String userDetails){
              String userResponse = masterService.createUser(userDetails);

			return new ResponseEntity<>(userResponse,HttpStatus.OK);
		}

	 
		/***********Get user API**********/ 

		@RequestMapping(value="/getparticularuser",method=RequestMethod.GET, headers="accept=application/json")
		public ResponseEntity<?> getParticularUser(@RequestParam String id){
			String usersInformation = null;
			usersInformation = masterService.getParticularUser(id);
			return new ResponseEntity<>(usersInformation, HttpStatus.OK);
		}

		/***********update user API**********/ 
		@RequestMapping(value="/updateuser",method=RequestMethod.PUT, headers="accept=application/json")
		public ResponseEntity<?> updateUsers(@RequestBody String userRecord,@RequestParam int id ){



			String userUpdateResponse = masterService.updateUser(userRecord,id);
			
			return new ResponseEntity<>(userUpdateResponse,HttpStatus.OK);
		}

		/***********Delete user API**********/ 
		
		@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE, headers="accept=application/json")
		public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {

			String userDeleteResponse = masterService.deleteUser(id);
			
			return new ResponseEntity<>(userDeleteResponse,HttpStatus.OK);
		}

		/***********GET ALL  user API**********/ 
		@RequestMapping(value="/getalluser",method=RequestMethod.GET, headers="accept=application/json")
		public ResponseEntity<?> getAllUser(){
			String usersInformation = null;
			usersInformation = masterService.getListOfUser();
			return new ResponseEntity<>(usersInformation, HttpStatus.OK);
		}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
