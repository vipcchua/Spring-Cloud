package com.CchuaSpace.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.TableUserClient;


@RestController
public class TableUserController {
	   @Autowired
	   TableUserClient tableUserClient;

	    

	    @RequestMapping(value = "/SelectuserID", method = RequestMethod.POST)

		public ResponseEntity<List<TableUser>> SelectUserId(@RequestBody String SelectUserId, Model model) {
	    	
	    	ResponseEntity<List<TableUser>> user = tableUserClient.SelectUserId(SelectUserId);

	    /*	ResponseEntity<String> str= new ResponseEntity<String>("hello",HttpStatus.OK);*/
	    	
	    	return user;
	    }
	    

	    
	    

	    @RequestMapping(value = "/SelectUsername", method = RequestMethod.POST)
		public ResponseEntity<List<TableUser>> SelectUserName(@RequestBody String SelectUserName, Model model) { 
	    	ResponseEntity<List<TableUser>> user = tableUserClient.SelectUserName(SelectUserName);
	    	return user;
	    }
	    
	    @RequestMapping(value = "/UserInfo", method = RequestMethod.POST)
		public ResponseEntity<List<TableUser>> UserInfo(@RequestBody String UserInfo, Model model) { 
	    	ResponseEntity<List<TableUser>> user = tableUserClient.UserInfo(UserInfo);
	    	return user;
	    }
	    

	    @RequestMapping(value = "/SelectUserCondition", method = RequestMethod.POST)
			public ResponseEntity<List<TableUser>> SelectUserCondition(@RequestBody String SelectUserCondition, Model model) { 
		    	ResponseEntity<List<TableUser>> user = tableUserClient.SelectUserCondition(SelectUserCondition);
		    	return user;
		    }
		    
	    @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
				public ResponseEntity<List<TableUser>> UpdateUser(@RequestBody String UpdateUser, Model model) { 
			    	ResponseEntity<List<TableUser>> user = tableUserClient.UpdateUser(UpdateUser);
			    	return user;
			    }
	    
	    
	    
	    
	    
	    
	    
	    
}

