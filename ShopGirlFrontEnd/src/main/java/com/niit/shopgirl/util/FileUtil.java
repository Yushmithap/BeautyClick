
package com.niit.shopgirl.util;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shopgirl.Controller.UserController;

public class FileUtil{
	
	public static Logger log = LoggerFactory.getLogger(UserController.class);
	
	
public static void upload(String path, MultipartFile file, String fileName){
	
	log.debug("Starting of the method:upload");
	
	Util.removeComman(fileName);
	if(! file.isEmpty()){
		
		try {
			byte[] bytes;
			
				bytes = file.getBytes();
			
			
			File dir = new File(path);
			if(!dir.exists())
				dir.mkdirs();
			
			File serverFile = new File(dir.getAbsolutePath()+File.separator+ fileName);
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				log.info("Server File location="+serverFile.getAbsolutePath());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
	
		
	}
}
