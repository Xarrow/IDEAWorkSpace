package com.tn.code;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zhangjian5 on 2015/12/8.
 */
public class SignUtils {
    public static final String KEY = "0123456789"; //统一扣款接口生成签名MD5秘钥
    private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);
//	 签名规则：对所有待签名参数按照字段名的ASCII码从小到大排序(字典序)后，使用URL键值对的格式(即 key1=value1&key2=value2 … )
// 	拼接成字符串【Null和空值不参与签名】，使用md5签名，生成sign值，并添加在签名串后。再使用Base64生成加密串

    public static String createSign(SortedMap<String, Object> packageParams) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)) {  //空的参数不参与签名的生成
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append(KEY);
        logger.info("参与签名的参数【{}】", sb.toString());
        String sign = MD5Util.MD5Encode(sb.toString(), "utf-8");
        return "sb:" + sb + "\nsign:" + sign;
    }

    public static void main(String[] args) {
//        SortedMap<String,Object> packageParams = new TreeMap<String,Object>();
//        packageParams.put("userId", 6700028);
//        packageParams.put("totalAmount", 0.01);
//        packageParams.put("platformId", "10001");
//        packageParams.put("userIp", "170.30.61.56");
//        packageParams.put("bizId", "1009");
//        packageParams.put("bizOrderId", "htj201509180");
//        packageParams.put("payChannel", 6);
//        packageParams.put("payMethod", 2);
//        packageParams.put("targetBankId", "7391");
        TreeMap<String,Object> packageParams = new TreeMap<String,Object>();
        packageParams.put("Hello",new String("World"));

        System.out.println(SignUtils.createSign(packageParams));

    }
}
