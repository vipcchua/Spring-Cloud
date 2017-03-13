package com.cchuaspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.service.ComputeClient;


@RestController



public class ConsumerController {

    @Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
    
    @RequestMapping(value = "/Selectallusers" )
    public String Selectalluser() {
        return computeClient.Selectalluser();
    }
    

    
    

    @RequestMapping(value = "/SelectuserIDsss", method = RequestMethod.POST)

	public ResponseEntity<PaginationVo> SelectUserId(@RequestBody String SelectUserId, Model model) {
    	
    	ResponseEntity<PaginationVo> user = computeClient.SelectUserId(SelectUserId);

    /*	ResponseEntity<String> str= new ResponseEntity<String>("hello",HttpStatus.OK);*/
    	
    	return user;
    }
    /*
    
    @RequestMapping(value = "/SelectuserID", method = RequestMethod.POST)
	public ResponseEntity<TableUser> protoRead(RequestEntity<TableUser> requestEntity) {
		return ResponseEntity.ok(requestEntity.getBody());
	}
    
    
    */
	
    
    
    @RequestMapping(value = "/Seldsada" )
    public String Seldsada() {
        return computeClient.Seldsada();
    }
    
    

}