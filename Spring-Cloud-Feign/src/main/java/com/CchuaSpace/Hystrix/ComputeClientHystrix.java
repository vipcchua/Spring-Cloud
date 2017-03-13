package com.cchuaspace.hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.cchuaspace.model.PaginationVo;
import com.cchuaspace.model.TableUser;
import com.cchuaspace.service.ComputeClient;

@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }

	@Override
	public String Selectalluser() {
		// TODO Auto-generated method stub
		return "9999";
	}



	@Override
	public String Seldsada() {
		// TODO Auto-generated method stub
		return "9999";
	}

	@Override
	public String login() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public ResponseEntity<PaginationVo> SelectUserId(String selectUserId) {
	       return new ResponseEntity<PaginationVo>(HttpStatus.FORBIDDEN);  

	}

}