package airoucat.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dataUtil {
    /**
     * 获取系统当前时间
     * @explain 使用Date实现
     * @param format
     * @return
     */
    public static String getSysdateStr(String format) {
        Date sysdate = new Date();
        format = "".equals(format) ? "yyyy-MM-dd HH:mm:ss" : format;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(sysdate);
    }
}
