package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.service.DocHandlerService;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.file.FileHandler;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.bangnd.util.exception.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class DocHandlerServiceImpl implements DocHandlerService {

    @Override
    public Resource loadAsResource(String filename,Long orderId) {
        try {
            Path file = load(filename,orderId);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);
            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    private Path load(String filename,Long orderId) {
        Path rootLocation= Paths.get(ConstantCfg.ORDER_DOC_FIXED_PATH+orderId+"/");
        System.out.println("Path="+rootLocation.toUri());
        return rootLocation.resolve(filename);
    }

    /**
     * 将文件名进行UUID编码后存储到指定位置，并将原名称和编码后的名称的对应关系返回，用于存储到数据库中
     * @param files
     * @param variablePath
     * @return
     * @throws StorageException
     */
    @Override
    public Map<String,String> storageFiles(MultipartFile[] files, String variablePath) throws StorageException {
        Map<String,String> fileNameMapping = new HashMap<String,String>();
        //这里可以支持多文件上传
        if(files!=null && files.length>=1) {
            for(int i=0;i<files.length;i++){
                BufferedOutputStream bw = null;
                try {
                    String fileName = files[i].getOriginalFilename();
                    //判断是否有文件且是否为图片文件
                    if(fileName!=null && !"".equalsIgnoreCase(fileName.trim()) && FileHandler.isImageFile(fileName)) {
                        String UUIDName= UUID.randomUUID().toString();
                        //注意key要保证唯一，必须使用UUIDName
                        fileNameMapping.put(UUIDName + FileHandler.getFileType(fileName),fileName);
                        //创建输出文件对象
                        File outFile = new File(ConstantCfg.ORDER_DOC_FIXED_PATH + variablePath+ "/" + UUIDName + FileHandler.getFileType(fileName));
                        //拷贝文件到输出文件对象
                        FileUtils.copyInputStreamToFile(files[i].getInputStream(), outFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new StorageException("文件保存失败，请联系管理员!");
                } finally {
                    try {
                        if(bw!=null) {bw.close();}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fileNameMapping;
    }
}
