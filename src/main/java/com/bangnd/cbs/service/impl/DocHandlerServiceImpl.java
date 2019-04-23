package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.service.DocHandlerService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.exception.StorageException;
import com.bangnd.util.exception.StorageFileNotFoundException;
import com.bangnd.util.file.FileHandler;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class DocHandlerServiceImpl implements DocHandlerService {

    @Override
    public Resource loadAsResource(String filename, Long orderId,String typeName) {
        try {
            Path file = load(filename, orderId,typeName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    private Path load(String filename, Long orderId,String typeName) {
        Path rootLocation = Paths.get(ConstantCfg.ORDER_DOC_FIXED_PATH + orderId+"/"+typeName+ "/");
        System.out.println("Path=" + rootLocation.toUri());
        return rootLocation.resolve(filename);
    }

    /**
     * 将文件名进行UUID编码后存储到指定位置，并将原名称和编码后的名称的对应关系返回，用于存储到数据库中
     *
     * @param files
     * @param variablePath
     * @return
     * @throws StorageException
     */
    @Override
    public Map<String, String> storageFiles(MultipartFile[] files, String variablePath,String typeName) throws StorageException {
        Map<String, String> fileNameMapping = new HashMap<String, String>();
        //这里可以支持多文件上传
        if (files != null && files.length >= 1) {
            for (int i = 0; i < files.length; i++) {
                BufferedOutputStream bw = null;
                try {
                    String fileName = files[i].getOriginalFilename();
                    //判断是否有文件且是否为图片文件
                    if (fileName != null && !"".equalsIgnoreCase(fileName.trim()) && FileHandler.isImageFile(fileName)) {
                        String UUIDName = UUID.randomUUID().toString();
                        //注意key要保证唯一，必须使用UUIDName
                        fileNameMapping.put(UUIDName + FileHandler.getFileType(fileName), fileName);
                        //创建输出文件对象
                        File outFile = new File(ConstantCfg.ORDER_DOC_FIXED_PATH + variablePath +"/"+typeName+ "/" + UUIDName + FileHandler.getFileType(fileName));
                        //拷贝文件到输出文件对象
                        FileUtils.copyInputStreamToFile(files[i].getInputStream(), outFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new StorageException("文件保存失败，请联系管理员!");
                } finally {
                    try {
                        if (bw != null) {
                            bw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fileNameMapping;
    }

    @Override
    public Map<String, String> storageFilesFromUrls(String urls,String typeName, String orderPath) {
        Map<String, String> fileNameMapping = new HashMap<String, String>();
        if (urls == null || orderPath == null || "".equals(orderPath) || "".equals(urls)) {
            return null;
        }
        String[] paths = urls.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "").split(",");
        if (paths != null && paths.length > 0) {
            fileNameMapping = download(paths,typeName, orderPath);
        }
        return fileNameMapping;
    }

    private Map<String, String> download(String[] listImgSrc,String typeName, String orderPath) {
        Map<String, String> fileNameMapping = new HashMap<String, String>();
        try {
            //开始时间
            Date begindate = new Date();
            for (String url : listImgSrc) {
                System.out.println("url=" + url);
                //开始时间
                Date begindate2 = new Date();
                String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
                fileNameMapping.put(imageName, imageName);
                URL uri = new URL(url);
                InputStream in = uri.openStream();

                //File picPath = new File("/Users/wrh/Documents/wrh/work/gzx_app/"+ConstantCfg.ORDER_DOC_FIXED_PATH + orderPath);//文件输出流
                File picPath = new File(ConstantCfg.ORDER_DOC_FIXED_PATH + orderPath+"/"+typeName);
                if (!picPath.exists()) {
                    picPath.mkdirs();
                }
                FileOutputStream fo = new FileOutputStream(new File(picPath + "/" + imageName));//文件输出流
                byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf, 0, buf.length)) != -1) {
                    fo.write(buf, 0, length);
                }
                //关闭流
                in.close();
                fo.close();
                System.out.println(imageName + "下载完成");
                //结束时间
                Date overdate2 = new Date();
                double time = overdate2.getTime() - begindate2.getTime();
                System.out.println("耗时：" + time / 1000 + "s");
            }
            Date overdate = new Date();
            double time = overdate.getTime() - begindate.getTime();
            System.out.println("总耗时：" + time / 1000 + "s");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
        return fileNameMapping;
    }

    public static void main(String[] args) {
        DocHandlerServiceImpl docHandlerService = new DocHandlerServiceImpl();
        String urls = "[https://static.dingtalk.com/media/lADPDgQ9qmknzX3NBQDNAtA_720_1280.jpg,https://static.dingtalk.com/media/lADPDgQ9qmko5bPNBQDNAtA_720_1280.jpg,https://static.dingtalk.com/media/lADPDgQ9qmknzX7NBQDNAtA_720_1280.jpg,https://static.dingtalk.com/media/lADPDgQ9qmko5bTNBQDNAtA_720_1280.jpg,https://static.dingtalk.com/media/lADPDgQ9qmknzX_NBQDNAtA_720_1280.jpg]";
        docHandlerService.storageFilesFromUrls(urls, "身份证明","72");
    }
}
