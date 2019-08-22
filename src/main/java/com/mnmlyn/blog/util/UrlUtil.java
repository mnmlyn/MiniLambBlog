package com.mnmlyn.blog.util;

import org.springframework.util.StringUtils;

/**
 * 处理请求URL的工具类
 *
 * @author mnmlyn
 * @date 2019/10/12
 */
public class UrlUtil {
    public static String getRequestURI(String uri, String contextPath, String servletPath) {
        if(!StringUtils.isEmpty(uri)) {
            uri = uri.substring(contextPath.length() + servletPath.length());
        }
        if (uri.length() > 0 && uri.substring(0, 1).equals("/")) {
            uri = uri.substring(1);
        }
        return uri;
    }
}
