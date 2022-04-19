package com.lhh.seamanrecruit.utils;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author zhh
 * @date 2022/4/18 12:00
 * @description
 */
public class Test {
    public static void main(String[] args) {
        String fileName = "F:\\Test.txt";

        List<Map<String,Object>> maps = new ArrayList<>();
        String key = "";
        String poolValue1 = "";
        String poolValue2 = "";
        String serverKey1 = "";
        String serverKey2 = "";
        String serverValue1 = "";
        String serverValue2 = "";
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(fileName));
            String str = new String(bytes, StandardCharsets.UTF_8);

            String[] pools = str.split("pools");
            String pool = pools[pools.length - 1];
            String[] split1 = pool.replace(" ","").split("\\{");
            Pattern p = compile("\\s*|\t|\r|\n");
            poolValue1 = p.matcher(split1[1].replace(" ","")).replaceAll("");
            poolValue2 = p.matcher(split1[2].replace(" ","").split("\\}")[1]).replaceAll("");

            if (str.contains(poolValue1)){
                String[] sp = str.split(poolValue1);
                String[] members = sp[2].split("members");
                serverKey1 = members[1].split("\\{")[1].replace(" ","").split(":")[1];

            }

            if (str.contains(poolValue1)){
                String[] sp = str.split(poolValue1);
                for (String s : sp) {
                    if (s.contains("members")){
                        String[] members = sp[2].split("members");
                        serverKey1 = p.matcher(members[1].split("\\{")[1].replace(" ","").split(":")[1]).replaceAll("");
                        continue;
                    }
                }

            }

            if (str.contains(poolValue2)){
                String[] sp = str.split(poolValue2);
                for (String s : sp) {
                    if (s.contains("members")){
                        String[] members = sp[2].split("members");
                        serverKey2 = p.matcher(members[1].split("\\{")[1].replace(" ","").split(":")[1]).replaceAll("");
                        continue;
                    }
                }

            }

            if (str.contains(serverKey1)){
                String[] sp = str.split(serverKey1);
                for (String s : sp) {
                    if (s.contains("addresses")){
                        String[] members = sp[2].split("addresses");
                        serverValue1 = p.matcher(members[1].split("\\{")[1].replace(" ","").split(":")[0]).replaceAll("");
                    }
                }

            }

            if (str.contains(serverKey2)){
                String[] sp = str.split(serverKey2);
                for (String s : sp) {
                    if (s.contains("addresses")){
                        String[] members = s.split("addresses");
                        serverValue2 = p.matcher(members[1].split("\\{")[1].replace(" ","").split(":")[0]).replaceAll("");
                    }
                }

            }

            Map<String,String> serverMap1 = new HashMap<>();
            serverMap1.put(serverKey1,serverValue1);

            Map<String,String> serverMap2 = new HashMap<>();
            serverMap2.put(serverKey2,serverValue2);

            Map<String,Object> map1 = new HashMap<>();
            map1.put("pool",poolValue1);
            map1.put("server",serverMap1);
            maps.add(map1);

            Map<String,Object> map2 = new HashMap<>();
            map2.put("pool",poolValue2);
            map2.put("server",serverMap2);
            maps.add(map2);
            String[] split = str.split("\\{");
            for (String s : split) {
                String[] strings = s.split(" ");
                for (String string : strings) {
                    if (string.equals("wideip")){
                        key = strings[strings.length - 1];
                        continue;
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,maps);
        System.out.println(jsonObject);

    }
}
