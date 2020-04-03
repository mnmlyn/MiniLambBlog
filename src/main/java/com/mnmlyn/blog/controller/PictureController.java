package com.mnmlyn.blog.controller;

import com.mnmlyn.blog.msg.BaseMsg;
import com.mnmlyn.blog.service.FileSaveService;
import com.mnmlyn.blog.service.impl.FileSaveServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 图片上传控制器
 *
 * @author mnmlyn
 * @date 2020/3/31
 */
@Controller
public class PictureController {

    public static void main(String[] args) {

    }

    @RequestMapping(value="uploadPic", method = RequestMethod.POST)
    @ResponseBody
    public BaseMsg insertArticle(HttpServletRequest request,
                                 @RequestParam("pic") CommonsMultipartFile pic) {
        String postKey = request.getParameter("postKey");
        String getKey = request.getParameter("getKey");

        FileSaveService fileSaveService = new FileSaveServiceImpl();
        String picUrl = null;
        try {
            picUrl = fileSaveService.saveMultipartFile(pic);
        } catch (IOException e) {
            e.printStackTrace();
            picUrl = null;
        }
        return picUrl == null ?
                BaseMsg.fail(-400, "上传失败") :
                BaseMsg.successWithData(picUrl);
    }
}
