package com.tn.code;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by zhangjian5 on 2015/12/8.
 */
public class CommonUtils {
    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };
    /**
     * 产生8位唯一码
     * 参考：http://blog.csdn.net/andy_miao858/article/details/9530245
     * @return shortBuffer.toString()
     *
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

    public static  int getAgeFromUserId(String id)
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(calendar.YEAR)-Integer.parseInt(id.substring(6, 10));

    }
    @Test
    public void testGenerateShortUUid()
    {
        Integer i = 100000;
        while (i>0) {
            System.out.print(i+":"+CommonUtils.generateShortUuid()+"\n");
            i--;
        }
    }
    @Test
    public void testGetAgeFromUserId()
    {
        System.out.print(CommonUtils.getAgeFromUserId(""));
    }
}
