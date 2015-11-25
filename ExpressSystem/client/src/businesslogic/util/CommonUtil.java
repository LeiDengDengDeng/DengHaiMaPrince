package src.businesslogic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2015/11/25.
 * 用途：公用工具
 */
public class CommonUtil {

    // 生成当前日期
    public static String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(new Date());
    }

}
