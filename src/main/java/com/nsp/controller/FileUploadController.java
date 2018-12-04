package com.nsp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nsp.dao.StudentDao;
import com.nsp.dao.UploadDao;
import com.nsp.model.StudentRegister;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadController.class);

	@Autowired
	StudentDao sdao;

	@Autowired
	UploadDao udao;


	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadFile/{gs_aadhar}" , method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@PathVariable long gs_aadhar,@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file,HttpServletRequest request) {

		String status=request.getParameter("checkstatus");

		if(status.equals("Rejected"))
		{
			udao.changestatus(gs_aadhar,status);
			return "action saved";
		}

		else {		

			if(name.isEmpty())
			{ 
				return "You failed to upload because you didn't give any file name";
			}

			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Creating the directory to store file
					String rootPath = System.getProperty("catalina.home");
					File dir = new File(rootPath + File.separator + "tmpFiles");
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					File serverFile = new File(dir.getAbsolutePath()
							+ File.separator + name);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					logger.info("Server File Location="
							+ serverFile.getAbsolutePath());

					/**
					 * Making changes to institute approval
					 */

					udao.changestatus(gs_aadhar,status);

					//return new ModelAndView("institute dashboard");	

					return "You successfully uploaded file=" + name;
				} catch (Exception e) {
					return "You failed to upload " + name + " => " + e.getMessage();
				}
			} else 
				return "You failed to upload " + name+ " because the file was empty.";

		}
	}

	/**
	 * Upload multiple file using Spring Controller
	 * @throws IOException 
	 */
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public ModelAndView uploadMultipleFileHandler( @ModelAttribute StudentRegister st ,@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) throws IOException {

		int flag=0; String loc="";
		long gs_aadhar=sdao.getaadhar(st.getGs_email());

		sdao.saveUploadData(st,gs_aadhar);

		if (files.length != names.length)
			return new ModelAndView("post","str","Mandatory information missing");

		String dir_loc="";
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];
			String name = names[i];
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles"+ File.separator+st.getGs_name());
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				dir_loc=dir.getAbsolutePath();
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				loc=serverFile.getAbsolutePath();

				if(flag==0) {
					udao.savelocation(gs_aadhar, loc, name);  flag=1; 
				}
				else {
					udao.updatelocation(gs_aadhar, loc, name); 
				}

			} catch (Exception e) {
				udao.DeleteRecords(gs_aadhar);
				FileUtils.deleteDirectory(new File(dir_loc));
				return new ModelAndView("post","str1","You failed to upload " + name + " => " + e.getMessage());
			}
		}
		udao.Updatedoc(gs_aadhar);
		return new ModelAndView("success");
	}
}
