package com.mnmlyn.blog.util;

import org.eclipse.jetty.util.StringUtil;

import java.util.Map;

/**
 * 校验网页前端的传入参数
 *
 * @author mnmlyn
 * @date 2020/4/3
 */
public class ParamValidateUtil {

    /**
     * 传入参数名与参数值的列表。参数为空，或postKey参数不为指定值时，返回错误提示。
     * 参数校验通过，返回null
     *
     * @param params
     * @return
     */
    public static String paramEmptyValidate(Map<String, String> params) {
        if (params.containsKey("postKey") && !"111666".equals(params.get("postKey"))) {
            return "暂未开放该功能";
        }
        for(Map.Entry<String, String> param: params.entrySet()) {
            System.out.println("参数名：" + param.getKey());
            if (StringUtil.isBlank(param.getValue())) {
                return "参数" + param.getKey() + "不能为空";
            }
        }
        return null;
    }
}
