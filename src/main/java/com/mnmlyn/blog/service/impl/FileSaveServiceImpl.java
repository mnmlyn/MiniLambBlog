package com.mnmlyn.blog.service.impl;

import com.mnmlyn.blog.service.FileSaveService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件保存实现
 *
 * @author mnmlyn
 * @date 2020/4/3
 */
public class FileSaveServiceImpl implements FileSaveService {

    private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
    private final static String VIRTUAL_PATH = "/upload";

    /**
     * 获取文件扩展名，包含点
     * @param fileName
     * @return
     */
    private static String getFileExt(String fileName) {
        if (fileName == null) {
            return "";
        }
        int i = fileName.lastIndexOf('.');
        if (i == -1) {
            return "";
        }
        return fileName.substring(i);
    }

    @Override
    public String saveMultipartFile(CommonsMultipartFile file) throws IOException {
        Date now = new Date();

        String dateDirPath = "/" + SDF.format(now);
        String dirPath = "D://0upload" + dateDirPath;
        File dir = new File(dirPath);
        dir.mkdirs();
        String newFilePath = "/" + new Date().getTime();
        String newFileExt = getFileExt(file.getOriginalFilename());

        File newFile = new File(dirPath + newFilePath + newFileExt);
        int index = 0;
        while (newFile.exists()) {
            ++index;
            newFile = new File(dirPath + newFilePath + "_" + index + newFileExt);
            if (index > 65536) {
                System.out.println("文件重复异常");
                break;
            }
        }
        if (index != 0) {
            newFilePath += "_" + index;
        }

        //通过CommonsMultipartFile的方法直接写文件
        file.transferTo(newFile);
        return VIRTUAL_PATH + dateDirPath + newFilePath + newFileExt;
    }
}
