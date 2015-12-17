package src.businesslogic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2015/11/25.
 * ��;�����ù���
 */
public class CommonUtil {

    // ���ɵ�ǰ����
    public static String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(new Date());
    }

    public static boolean isValidNumberString(String s, int length) {
        char[] numbers = s.toCharArray();
        if (numbers.length != length)
            return false;
        for (char n : numbers)
            if (!(n >= '0' && n <= '9'))
                return false;
        return true;
    }

}
