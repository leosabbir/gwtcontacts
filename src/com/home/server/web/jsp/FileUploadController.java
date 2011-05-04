package com.home.server.web.jsp;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.home.server.service.FileStorage;

@Controller
public class FileUploadController {
	private FileStorage fileStorage;
	private Resource storageLocation;

	public void setFileStorage(FileStorage fileStorage) {
		this.fileStorage = fileStorage;
	}

	public void setStorageLocation(Resource storageLocation) {
		this.storageLocation = storageLocation;
	}

	public FileUploadController(FileStorage fileStorage,
			Resource storageLocation) {
		//super();
		this.fileStorage = fileStorage;
		this.storageLocation = storageLocation;
	}

	@RequestMapping(value = "/upload/{username}", method = RequestMethod.POST)
	public void handleRequest(@RequestParam("upload123") MultipartFile file, HttpServletResponse res) throws IOException {
		//Object file1 = ((SecurityContextHolderAwareRequestWrapper)req).getAttribute("upload");
		//MultipartFile file = ((MultipartRequest)req).getFile("upload");
		String message;
		if (file != null) {
			if (file.getSize() < 5000000) {
				File destFile = storageLocation.createRelative(
						file.getOriginalFilename()).getFile();
				try {
					fileStorage.store(destFile, file);
					res.getWriter().write("Stored!!!");
				} catch (Exception e) {
					res.getWriter().write("failed, " + e);
				}
			}
		}
	}

	@RequestMapping(value = "/upload/check", method = RequestMethod.GET)
	public void handleRequest(HttpServletResponse res) throws IOException {
		res.getWriter().write("successfull!!!!");
	}
}
