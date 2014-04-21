package com.startup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dao.POProfilingDAO;
import com.util.SearchUtil;

public class E2EMFDataLoaderThread implements Runnable {
	
	private static Logger log = LogManager.getLogger(E2EMFDataLoaderThread.class);
	private ServletContext context = null;
		
	
	public E2EMFDataLoaderThread(ServletContext context) {
		this.context = context;
		
	}
	
	@Override
	public void run() {
		//while(true) {
			try {
				loadProfileData();				
			} catch(IOException e){
				log.error(e.toString());
			} catch(Exception e){
				log.error(e.toString());
			}			
		//}
	}
		
	@SuppressWarnings({ "unused", "unused" })
	private void loadProfileData() throws IOException {
		
		POProfilingDAO poprofileData = new POProfilingDAO();
		
		String data = poprofileData.retrievePOProfileData();
		
		context.setAttribute("poprofiledata", data);		
		//log.info(context.getAttribute("poprofiledata").toString());
	}
	
	
}
