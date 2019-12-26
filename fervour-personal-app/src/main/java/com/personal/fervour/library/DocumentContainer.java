/**
 * 
 */
package com.personal.fervour.library;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.personal.fervour.cmm.response.ResponseEntityMapper;
import com.personal.fervour.cmm.response.ResponseType;

/**
 * @author vignesh
 *
 */
@RestController
@RequestMapping("/library/doc")
public class DocumentContainer implements ResponseEntityMapper<Object>{
	@PostMapping(value="/upload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> getUpload(@RequestParam("file") final MultipartFile multiPart) {
		long size = multiPart.getSize();
		String responseMsg = null;
		
		
		fileUpload:{
			if(size == 0) {
				responseMsg=  "file is empty";
			}else {
				String orgFileName = multiPart.getOriginalFilename();
				String fileLocation = null;
				if(orgFileName.contains(".")) {
					String fileExt = orgFileName.substring(orgFileName.lastIndexOf("."), orgFileName.length());
					switch(fileExt) {
					case ".png":
					case ".jpg":
					case ".jpeg":
						fileLocation = "/Users/vignesh/fervour/documents/images/";
						break;
					case ".txt":
					case ".md":
					case ".doc":
					case ".xlsx":
					case ".xlx":
						fileLocation = "/Users/vignesh/fervour/documents/pages/";
						break;
					case ".mp3":
					case ".m4a":
						fileLocation = "/Users/vignesh/fervour/documents/audios/";
						break;
					case ".mp4":
					case ".3gp":
					case ".avi":
						fileLocation = "/Users/vignesh/fervour/documents/videos/";
						break;
					default:
						fileLocation =  "unknown";
						break;
					}
				}else {
					fileLocation = "/Users/vignesh/fervour/documents/files/";
				}
				
				if(fileLocation == "unknown") {
					responseMsg = "unsupported file format";
					break fileUpload;
				}else {
					
					Path path = Paths.get(fileLocation);
					if(!Files.exists(path)) {
						try {
							Files.createDirectories(path);
						}catch(Exception e) {
							System.out.println(e);
							responseMsg = "Uploading failed!";
						}
					}
					
					File fileUploader = new File(fileLocation+File.separator+orgFileName);
					try (FileOutputStream fos = new FileOutputStream(fileUploader);
							BufferedOutputStream bout=new BufferedOutputStream(fos);) {
						BufferedInputStream bis = new BufferedInputStream(multiPart.getInputStream());
						int c;
						while((c = bis.read()) != -1) {
							bout.write(c);
						}
						bout.flush();
						responseMsg = "uploaded successfully!";
					} catch (FileNotFoundException e) {
						responseMsg = "Uploading failed!";
						e.printStackTrace();
					} catch (IOException e1) {
						responseMsg = "Uploading failed!";
						e1.printStackTrace();
					}catch(Exception e2) {
						responseMsg = "Uploading failed!";
						e2.printStackTrace();
					}
					
					break fileUpload;
				}
			}
		}
		
		
		return this.getResponse(ResponseType.UPDATE, responseMsg, null, HttpStatus.OK);
	}

}
