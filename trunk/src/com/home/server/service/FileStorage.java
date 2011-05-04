package com.home.server.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {

	void store(File file, MultipartFile multiPartFile) throws IllegalStateException, IOException;

}
