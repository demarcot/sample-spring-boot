package com.tcd.server.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcd.server.models.CreateThingRequest;
import com.tcd.server.services.MyDataService;

@RestController
public class MyDataController {

	@Autowired
	private MyDataService svc;
	
	public MyDataController() {
		
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<List<String>> MakeDataPoint(HttpServletRequest req, HttpServletResponse resp) {
		return ResponseEntity.ok(svc.getThings());
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<String> OtherEndpoint(HttpServletRequest req, HttpServletResponse resp,
	    @RequestBody CreateThingRequest thingRequest) {
		svc.createThing(thingRequest.thing);
	  return ResponseEntity.ok("Created.");
	}
}
