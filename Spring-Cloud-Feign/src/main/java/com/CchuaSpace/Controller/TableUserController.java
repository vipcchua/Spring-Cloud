package com.cchuaspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.service.TableUserClient;


@RestController
public class TableUserController {
	   @Autowired
	   TableUserClient tableUserClient;

	    

	    @RequestMapping(value = "/SelectuserID", method = RequestMethod.POST)

		public ResponseEntity<PaginationVo> SelectUserId(@RequestBody String SelectUserId, Model model) {
	    	
	    	ResponseEntity<PaginationVo> user = tableUserClient.SelectUserId(SelectUserId);

	    /*	ResponseEntity<String> str= new ResponseEntity<String>("hello",HttpStatus.OK);*/
	    	
	    	return user;
	    }
	    

	    
	    

	    @RequestMapping(value = "/SelectUsername", method = RequestMethod.POST)
		public ResponseEntity<PaginationVo> SelectUserName(@RequestBody String SelectUserName, Model model) { 
	    	ResponseEntity<PaginationVo> user = tableUserClient.SelectUserName(SelectUserName);
	    	return user;
	    }
	    
	    @RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
		public ResponseEntity<PaginationVo> UserInfo(@RequestBody String UserInfo, Model model) { 
	    	ResponseEntity<PaginationVo> user = tableUserClient.UserInfo(UserInfo);
	    	return user;
	    }
	    

	    @RequestMapping(value = "/SelectUserCondition", method = RequestMethod.POST)
			public ResponseEntity<PaginationVo> SelectUserCondition(@RequestBody String SelectUserCondition, Model model) { 
		    	ResponseEntity<PaginationVo> user = tableUserClient.SelectUserCondition(SelectUserCondition);
		    	return user;
		    }
		    
	    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
				public ResponseEntity<PaginationVo> UpdateUser(@RequestBody String UpdateUser, Model model) { 
			    	ResponseEntity<PaginationVo> user = tableUserClient.UpdateUser(UpdateUser);
			    	return user;
			    }
	    
	    
	    
	    
	    
	    
	    
	    
}

