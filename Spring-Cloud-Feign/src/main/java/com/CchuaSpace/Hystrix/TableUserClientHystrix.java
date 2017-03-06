package com.CchuaSpace.Hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.ComputeClient;
import com.CchuaSpace.Service.TableUserClient;

@Component
public class TableUserClientHystrix implements TableUserClient {

	

	@Override
	public ResponseEntity<List<TableUser>> SelectUserId(String selectUserId) {
	       return new ResponseEntity<List<TableUser>>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<List<TableUser>> SelectUserName(String selectUserName) {
	     return new ResponseEntity<List<TableUser>>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<List<TableUser>> UserInfo(String UserInfo) {
	     return new ResponseEntity<List<TableUser>>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<List<TableUser>> SelectUserCondition(String selectUserCondition) {
	     return new ResponseEntity<List<TableUser>>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<List<TableUser>> UpdateUser(String updateUser) {
	     return new ResponseEntity<List<TableUser>>(HttpStatus.FORBIDDEN);  
	}
	
	

}