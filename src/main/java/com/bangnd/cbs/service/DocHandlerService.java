package com.bangnd.cbs.service;

import com.bangnd.util.exception.StorageException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface DocHandlerService {
    public Resource loadAsResource(String filename, Long orderId);

    public Map<String, String> storageFiles(MultipartFile[] files, String variablePath) throws StorageException;
}
