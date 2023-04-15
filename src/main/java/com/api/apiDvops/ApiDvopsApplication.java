package com.api.apiDvops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class ApiDvopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDvopsApplication.class, args);
		System.out.println("ola mundo!");
	}

	public static Connection connect() throws Exception{
			String connectionString = "jdbc:sqlserver://ramonapi.database.windows.net:1433;database=databaseAPI;user=ramon123@ramonapi;password=ramon!23;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			try{
				Connection connection = DriverManager.getConnection(connectionString);
				return connection;
			}
			catch (Exception e){
				System.out.println("didnt worked");
			}
			return null;
	}

}
