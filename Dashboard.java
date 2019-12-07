package com.perisic.beds.peripherals;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.web.*; 

//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
   
public class Dashboard extends Application { 
   
//    private String stringData;

	// launch the application 
    public void start(Stage stage) 
    { 
        try { 
        	
//        	
//        	PrintWriter outputFile = new PrintWriter("charts\\sample.html");
//        	
//        	URL url2 = new URL ("http://localhost:3000/tasks");
//        	 URLConnection con = url2.openConnection();
//        	    InputStream is =con.getInputStream();
//
//        	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//        	    String line = null;
//
//
//        	    while ((line = br.readLine()) != null) {
//        	        System.out.println(line);
//        	        outputFile.println(line);
//        	    }
//        	    br.close();
//        	    outputFile.close();
        	
        	
//        	HttpURLConnection con = (HttpURLConnection)url.openConnection();
//        	con.setRequestMethod("POST");
//        	con.setRequestProperty("Content-Type", "application/json; utf-8");
////        	con.setRequestProperty("Accept", "application/json");
//        	con.setDoOutput(true);
        	
//        	String jsonInputString = "{"name": "Upendra", "job": "Programmer"}";
//        	try(OutputStream os = con.getOutputStream()) {
//        	    byte[] input = jsonInputString.getBytes("utf-8");
//        	    os.write(input, 0, input.length);           
//        	}
//        	
//        	try(BufferedReader br = new BufferedReader(
//        			  new InputStreamReader(con.getInputStream(), "utf-8"))) {
//        			    StringBuilder response = new StringBuilder();
//        			    String responseLine = null;
//        			    while ((responseLine = br.readLine()) != null) {
//        			        response.append(responseLine.trim());
//        			    }
//        			    System.out.println(response.toString());
//        			}));
        	

        	
        	
        	
   
            // set title for the stage 
            stage.setTitle("Dashboard"); 
   
            // create a webview object 
            WebView w = new WebView(); 
   
            // get the web engine 
            WebEngine e = w.getEngine();
            e.load("https://chart-service.herokuapp.com/tasks/zdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4/1"); 
   
            // create a scene 
            Scene scene = new Scene(w, w.getPrefWidth(),  
                                     w.getPrefHeight()); 
   
            // set the scene 
            stage.setScene(scene); 
   
            stage.show(); 
        } 
   
        catch (Exception e) { 
   
            System.out.println(e.getMessage()); 
        } 
    } 
   
    // Main Method 
    public static void main(String args[]) 
    { 
   
        // launch the application 
        launch(args); 
    } 
} 