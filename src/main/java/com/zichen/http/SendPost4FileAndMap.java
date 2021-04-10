package com.zichen.http;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * post请求 带file,map是其余参数
 */
public class SendPost4FileAndMap {

    public static String sendPostWithFile(String fileUrl, File file, Map<String, Object> map) {
        DataOutputStream out = null;
        DataInputStream in = null;
        final String newLine = "\r\n";
        final String prefix = "--";
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            String BOUNDARY = "-------KingKe0520a";
            conn.setRequestMethod("POST");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            out = new DataOutputStream(conn.getOutputStream());
            /*
            sun.net.www.MessageHeader@2be94b0f2 pairs: {Charsert: UTF-8}{Content-Type: multipart/form-data; boundary=-------KingKe0520a}
             */
            // 添加参数file
            // File file = new File(filePath);
            StringBuilder sb1 = new StringBuilder();
            sb1.append(prefix);
            sb1.append(BOUNDARY);
            sb1.append(newLine);
            sb1.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"" + newLine);
            sb1.append("Content-Type:application/octet-stream");
            sb1.append(newLine);
            sb1.append(newLine);
            out.write(sb1.toString().getBytes());
            // in = new DataInputStream(new FileInputStream(file));
            in = new DataInputStream(new FileInputStream(file));
            byte[] bufferOut = new byte[1024];
            int bytes = 0;
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            out.write(newLine.getBytes());

            StringBuilder sb = new StringBuilder();
            int k = 1;
            for (String key : map.keySet()) {
                if (k != 1) {
                    sb.append(newLine);
                }
                sb.append(prefix);
                sb.append(BOUNDARY);
                sb.append(newLine);
                sb.append("Content-Disposition: form-data;name=" + key + "");
                sb.append(newLine);
                sb.append(newLine);
                sb.append(map.get(key));
                out.write(sb.toString().getBytes());
                sb.delete(0, sb.length());
                k++;
            }

            // 添加参数sysName
            /*StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(BOUNDARY);
            sb.append(newLine);
            sb.append("Content-Disposition: form-data;name=\"sysName\"");
            sb.append(newLine);
            sb.append(newLine);
            sb.append("test");
            out.write(sb.toString().getBytes());*/

            // 添加参数returnImage
            /*StringBuilder sb2 = new StringBuilder();
            sb2.append(newLine);
            sb2.append(prefix);
            sb2.append(BOUNDARY);
            sb2.append(newLine);
            sb2.append("Content-Disposition: form-data;name=\"returnImage\"");
            sb2.append(newLine);
            sb2.append(newLine);
            sb2.append("false");
            out.write(sb2.toString().getBytes());*/

            byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(end_data);
            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            StringBuffer resultStr = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                resultStr.append(line);
            }
            System.out.println("返回结果：" + resultStr.toString());

        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 亲测可用
     * @param args
     */
    public static void main(String[] args) {
        String url = "http://10.131.9.119:8800/api/esign/pdf/code_sign";
        Map<String, Object> strParams = new HashMap<>();
        strParams.put("billDate", "2020-01-25 05:35:15");
        strParams.put("signLowerLeftX", "0F");
        strParams.put("signLowerLeftY", "0F");
        strParams.put("summary", "{}");
        strParams.put("signPageNo", "-1");
        strParams.put("verifyAreaPageNo", "0");
        //...
        File file = new File("D://...//xxx.pdf");
        sendPostWithFile(url, file, strParams);
    }
}
