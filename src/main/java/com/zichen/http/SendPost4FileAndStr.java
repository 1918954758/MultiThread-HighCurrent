package com.zichen.http;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * post请求 带file,String是其余参数
 */
public class SendPost4FileAndStr {

    public static void main(String[] args) {
        String url = "https://ws-di1.sit.cmrh.com/aiisp/v1/mixedInvoiceFileOCR";
        String params = "a=1&b=2&c=3&d=4";
        sendPostWithFile(url, params);
    }


    public static void sendPostWithFile(String fileUrl, String filePath) {
        DataOutputStream out = null;
        final String newLine = "\r\n";
        final String prefix = "--";
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            String BOUNDARY = "-------7da2e536604c8";
            conn.setRequestMethod("POST");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            out = new DataOutputStream(conn.getOutputStream());

            // 添加参数file
            File file = new File(filePath);
            StringBuilder sb1 = new StringBuilder();
            sb1.append(prefix);
            sb1.append(BOUNDARY);
            sb1.append(newLine);
            sb1.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"" + newLine);
            sb1.append("Content-Type:application/octet-stream");
            sb1.append(newLine);
            sb1.append(newLine);
            out.write(sb1.toString().getBytes());
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            byte[] bufferOut = new byte[1024];
            int bytes = 0;
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            out.write(newLine.getBytes());
            in.close();

            // 添加参数sysName
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(BOUNDARY);
            sb.append(newLine);
            sb.append("Content-Disposition: form-data;name=\"sysName\"");
            sb.append(newLine);
            sb.append(newLine);
            sb.append("test");
            out.write(sb.toString().getBytes());

            // 添加参数returnImage
            StringBuilder sb2 = new StringBuilder();
            sb2.append(newLine);
            sb2.append(prefix);
            sb2.append(BOUNDARY);
            sb2.append(newLine);
            sb2.append("Content-Disposition: form-data;name=\"returnImage\"");
            sb2.append(newLine);
            sb2.append(newLine);
            sb2.append("false");
            out.write(sb2.toString().getBytes());

            byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            // 写上结尾标识
            out.write(end_data);
            out.flush();
            out.close();

            // 定义BufferedReader输入流来读取URL的响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
    }
}
