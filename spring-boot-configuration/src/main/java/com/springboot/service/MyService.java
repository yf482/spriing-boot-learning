package com.springboot.service;

import javax.annotation.PostConstruct;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.configuration.ConnectionSettings;

@Service
public class MyService {

	@Autowired
    private ConnectionSettings connection;

     //...

    @PostConstruct
    public void openConnection() {
//        Server server = new Server();
//        this.connection.configure(server);
    }
}
