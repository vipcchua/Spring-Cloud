package com.CchuaSpace.Hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.CchuaSpace.Model.PaginationVo;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.ComputeClient;
import com.CchuaSpace.Service.TableUserClient;

@Component
public class TableUserClientHystrix implements TableUserClient {

	

	@Override
	public ResponseEntity<PaginationVo> SelectUserId(String selectUserId) {
	       return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<PaginationVo> SelectUserName(String selectUserName) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<PaginationVo> UserInfo(String UserInfo) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<PaginationVo> SelectUserCondition(String selectUserCondition) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN);  
	}

	@Override
	public ResponseEntity<PaginationVo> UpdateUser(String updateUser) {
	     return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN);  
	}
	
	

}