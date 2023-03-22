package cn.zeroclian.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "ZeroClian");
        hashMap.put("10002", "Justin");
        hashMap.put("10003", "Yang");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
