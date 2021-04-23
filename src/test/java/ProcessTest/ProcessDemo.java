package ProcessTest;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProcessDemo {

    @Test
    public void test1() {
        String cmd = "ping www.baidu.com";
        try {
            Process exec = Runtime.getRuntime().exec(cmd);
            InputStream inputStream = exec.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            while (s != null) {
                System.out.println(s);
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        String cmd = "cmd.exe /c D:\\software\\WeChat & dir";
        Runtime runtime = Runtime.getRuntime();
        try {
            InputStream inputStream = runtime.exec(cmd).getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            while (s != null) {
                System.out.println(s);
                s = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        String cmd = "cmd /c start D:\\software\\WeChat\\WeChat.exe";
        //String cmd = "cmd";
        Runtime runtime = Runtime.getRuntime();
        try {
            //runtime.exec("cmd /d D:\\software\\WeChat");
            runtime.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test4() {
        String cmd = "cmd.exe /c ipconfig";
        Runtime runtime = Runtime.getRuntime();
        try {
            InputStream inputStream = runtime.exec(cmd).getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String s = bufferedReader.readLine();
//            while (s != null) {
//                System.out.println(s);
//                s = bufferedReader.readLine();
//            }
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = bufferedReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            String s = responseStrBuilder.toString();
            System.out.println(s);
            System.out.println("========================");
            //getData4CurrIP(s);
            getDataAll(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getDataAll(String s) {
        String[] s1 = s.split("   ");
        System.out.println(Arrays.asList(s1));

        System.out.println("==============================");
        StringBuilder con = new StringBuilder();
        for (String s2 : s1) {
            //截取key和value
            String[] kv = s2.split("( :|\\d:)");
            if ("".equals(s2) || null == s2)
                continue;
            con.append(kv[0]).append(kv.length > 1 ? kv[1] : null).append("\r\n");
        }
        System.out.println(con.toString());
    }

    private void getData4CurrIP(String s) {
        //get current ip
        String[] split = s.split("无线局域网适配器 无线网络连接:")[1].split("172.20.10.1以太网适配器 Bluetooth 网络连接: ");
        System.out.println(split[0]);
        System.out.println("============================");
        String[] s1 = split[0].split("   ");
        System.out.println(Arrays.asList(s1));

        System.out.println("==============================");
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i < s1.length; i++) {
            //截取key和value
            String[] kv = s1[i].split(" :");

            //get key
            String key = kv[0].replaceAll("\\.", "").trim();
            //get value
            String value = null;
            if (kv.length > 1) {
                 value = kv[1].trim();
            }
            map.put(key, value);
        }
        System.out.println(map);
    }
}
