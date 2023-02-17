package com.tcd.server.clients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MyDataDao {
  
  List<String> thingList = new ArrayList<>();

  public void create(String newThing) {
    thingList.add(newThing);
  }

  public List<String> getAll() {
    return thingList;
  }
}
