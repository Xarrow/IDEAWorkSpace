package com.tn.code.a;


import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by zhangjian5 on 2015/12/8.
 */
public class IPUtils implements Serializable{
    public static String getLocalIp() {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String publicip = null;
        try {
            InetAddress ip = null;
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();


                    if (!ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                        publicip = ip.getHostAddress();
                    } else if (ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                        localip = ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            System.out.print("getLocalIp error! " + e.toString());
        }
        return localip + ":" +publicip;
    }

    public static void main(String[] args)
    {
//        System.out.print(IPUtils.getLocalIp());
        System.out.print(IPUtils.getLocalIp());
    }
}
