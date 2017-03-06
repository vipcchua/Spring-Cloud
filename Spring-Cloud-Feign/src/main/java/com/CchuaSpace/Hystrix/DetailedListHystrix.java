package com.CchuaSpace.Hystrix;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.CchuaSpace.Model.DetailedList;
import com.CchuaSpace.Model.TableUser;
import com.CchuaSpace.Service.ComputeClient;
import com.CchuaSpace.Service.DetailedListClient;

@Component
public class DetailedListHystrix implements DetailedListClient {

	@Override
	public ResponseEntity<List<DetailedList>> SelectByUserId(String selectByUserId) {
		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> SelectByDetailedId(String selectByDetailedId) {

		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> DeleteByCommodity(String deleteByDetailedId) {

		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> DeleteBydetailedId(String deleteByNumber) {

		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> DeleteAll(String deleteAll) {

		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> InsertDetailed(String insertDetailed) {

		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> UpdateByUserId(String updateByUserId) {

		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> UpdateByDetailedId(String updateByDetailedId) {
		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<List<DetailedList>> DeleteCommodity(String deleteByNumber) {
		return new ResponseEntity<List<DetailedList>>(HttpStatus.FORBIDDEN);
		
	}



}
