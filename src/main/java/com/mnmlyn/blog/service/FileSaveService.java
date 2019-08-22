package com.mnmlyn.blog.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * 提供保存文件到磁盘的服务
 *
 * @author mnmlyn
 * @date 2020/4/3
 */
public interface FileSaveService {
    /**
     * 将file存储在默认的磁盘位置，返回前端可以访问的地址
     * @param file
     * @return
     */
    String saveMultipartFile(CommonsMultipartFile file) throws IOException;
}
