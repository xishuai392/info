package com.ztesoft.framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.ztesoft.framework.exception.SysRuntimeException;

/**
 * <Description> Http工具类<br>
 */
public class HttpUtils {

    public enum HttpMethod {
        GET, POST, DELETE, PUT
    }

    private HttpURLConnection urlc = null;

    private String encoding = FrameWorkConstants.UTF_8_ENCODING;

    private HttpMethod method = HttpMethod.GET;

    private int timeout = 2000;

    private Map<String, String> properties = new HashMap<String, String>();

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void addProperties(String key, String value) {
        if (properties.containsKey(key)) {
            properties.remove(key);
        }
        properties.put(key, value);
    }

    private String prepareParam(Map<String, Object> paramMap) {
        StringBuffer sb = new StringBuffer();
        if (paramMap.isEmpty()) {
            return "";
        }
        else {
            for (String key : paramMap.keySet()) {
                String value = (String) paramMap.get(key);
                if (sb.length() < 1) {
                    sb.append(key).append("=").append(value);
                }
                else {
                    sb.append("&").append(key).append("=").append(value);
                }
            }
            return sb.toString();
        }
    }

    /**
     * 发送请求
     * 
     * @param urlStr
     * @param paramMap
     * @throws Exception
     */
    public void sendRequest(String urlStr, Map<String, Object> paramMap)
            throws Exception {
        String paramStr = prepareParam(paramMap);
        if (paramStr == null || paramStr.trim().length() < 1) {

        }
        else {
            urlStr += "?" + paramStr;
        }
        sendRequest(urlStr, "");
    }

    public String getResponse() {
        byte[] buffer = new byte[0];

        InputStream stream;
        if (urlc != null) {
            try {
                urlc.setReadTimeout(timeout);
                stream = urlc.getInputStream();
                int count = timeout / 10;
                while (true) {
                    if (count <= 0) {
                        break;
                    }
                    if (stream.available() > 0) {
                        buffer = new byte[stream.available()];
                        stream.read(buffer);
                        while (stream.available() > 0) {
                            byte[] tmpbuffer = new byte[stream.available()];
                            stream.read(tmpbuffer);
                            buffer = ByteUtils.append(buffer, tmpbuffer);
                        }
                        break;
                    }
                    Thread.sleep(10);
                    count--;
                }

                String ret = new String(buffer, encoding);
                return ret;
            }
            catch (Throwable e) {
                throw new SysRuntimeException(e, "HttpUtil获取http请求出现异常"
                        + e.getMessage());
            }
        }
        return "";
    }

    public void sendRequest(String url, byte[] data) {
        try {
            if (method.equals(HttpMethod.GET)) {
                StringBuffer param = new StringBuffer();
                int i = 0;
                for (String key : properties.keySet()) {
                    if (i == 0) {
                        param.append("?");
                    }
                    else {
                        param.append("&");
                    }
                    param.append(key).append("=").append(properties.get(key));
                    i++;
                }
                url += param;
            }

            URL u = new URL(url);
            urlc = (HttpURLConnection) u.openConnection();
            urlc.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            urlc.setReadTimeout(timeout);
            urlc.addRequestProperty("method", String.valueOf(method));
            urlc.setDoOutput(true);
            urlc.setDoInput(true);
            urlc.setUseCaches(false);

            for (String key : properties.keySet()) {
                urlc.addRequestProperty(key, properties.get(key));
            }

            if (method.equals(HttpMethod.POST)) {
                urlc.getOutputStream().write(data);
            }

        }
        catch (Throwable e) {
            throw new SysRuntimeException(e, "HttpUtil发送http请求出现异常"
                    + e.getMessage());
        }

    }

    public void sendRequest(String url, String data) {
        byte[] sdata = null;
        try {
            sdata = data.getBytes(encoding);
        }
        catch (Throwable e) {
            throw new SysRuntimeException(e, "HttpUtil发送http请求出现异常"
                    + e.getMessage());
        }
        sendRequest(url, sdata);
    }

    public byte[] download(String url) {
        byte[] retbuffer = new byte[0];
        try {
            URL u = new URL(url);
            urlc = (HttpURLConnection) u.openConnection();
            urlc.setReadTimeout(timeout);
            InputStream inputStream = urlc.getInputStream();
            Thread.sleep(100);
            while (true) {
                int size = inputStream.available() > 0 ? inputStream
                        .available() : 1024;
                byte[] buffer = new byte[size];
                int ret = inputStream.read(buffer);
                if (ret <= 0) {
                    break;
                }

                if (ret == size) {
                    retbuffer = ByteUtils.append(retbuffer, buffer);
                }
                else {
                    byte[] tmpbuffer = new byte[ret];
                    System.arraycopy(buffer, 0, tmpbuffer, 0, tmpbuffer.length);
                    retbuffer = ByteUtils.append(retbuffer, tmpbuffer);
                }
            }
        }
        catch (Throwable e) {
            throw new SysRuntimeException(e, "HttpUtil下载资源出现异常"
                    + e.getMessage());
        }
        return retbuffer;
    }

    public static void main(String[] args) throws IOException {

    }

}
