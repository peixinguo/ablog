package com.kph.ablogspringboot.utils;

import com.kph.ablogspringboot.exception.ServiceException;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * IP地址工具类
 * @author GuoPeiXin  create in 2023/10/18 23:47
 */
public class IpUtils {
    private static Searcher searcher;

    static {
        try{
            InputStream inputStream = new ClassPathResource("ipdb/ip2region.xdb").getInputStream();
            byte[] cBuff = FileCopyUtils.copyToByteArray(inputStream);
            searcher = Searcher.newWithBuffer(cBuff);
        }catch (IOException e){
            throw new ServiceException("ip2region.xdb加载失败");
        }
    }

    /**
     * 在Nginx等代理之后获取用户真实IP地址
     */
    public static String getIpAddress(HttpServletRequest request){
        String ip;
        try{
            ip = request.getHeader("X-Real-IP");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getHeader("x-forwarded-for");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
                    //根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        throw new UnknownHostException("无法确定主机的IP地址");
                    }
                    ip = inet.getHostAddress();
                }
            }
            // 使用代理，则获取第一个IP地址
            if (!StringUtils.hasText(ip) && Objects.requireNonNull(ip).length() > 15) {
                int idx = ip.indexOf(",");
                if (idx > 0) {
                    ip = ip.substring(0, idx);
                }
            }
        } catch (Exception e) {
            ip = "";
        }
        return ip;
    }

    public static String getIpSource(String ip){
        try{
            String address = searcher.searchByStr(ip);
            if (StringUtils.hasText(address)){
                address = address.replace("|0", "");
                address = address.replace("0|", "");
                return address;
            }
            return address;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
