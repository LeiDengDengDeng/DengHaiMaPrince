package src.businesslogic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2015/11/25.
 * ��;�����ù���
 */
public class CommonUtil {

    // ���ɵ�ǰ����
    public static String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(new Date());
    }

}
