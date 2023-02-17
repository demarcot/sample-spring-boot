package com.tcd.server.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tcd.server.clients.MyDataDao;


@Service
public class MyDataService {
	private static Logger LOGGER = LogManager.getLogger();
	
	//NOTE(Tom): injects properly cuz bean and var are same name
	@Autowired
	String thing;
	
	@Qualifier(value = "altThing")
	@Autowired
	String otherThing;
	
	@Autowired
	private MyDataDao dao;
	
	@PostConstruct
	private void init() {
		LOGGER.info("Constructed: service...");
		LOGGER.info("thing: " + thing + ", otherThing: " + otherThing);
	}
	
	
	public MyDataService() {
	}
	
	public void createThing(String newThing) {
	  dao.create(newThing);
	}
	
	public List<String> getThings() {
	  return dao.getAll();
	}
}
