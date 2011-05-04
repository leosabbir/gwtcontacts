package com.home.server.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.home.server.service.FileStorage;

public class FileStorageServiceImpl implements FileStorage {

	@Override
	public void store(File fileName, MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(fileName);
	}

}
