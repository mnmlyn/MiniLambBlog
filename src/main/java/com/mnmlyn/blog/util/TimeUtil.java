package com.mnmlyn.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 所有与时间日期相关的处理
 *
 * @author mnmlyn
 * @date 2019/10/28
 */
public class TimeUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    public static String getDateTimeString(Date date) {
        return sdf.format(date);
    }

}
