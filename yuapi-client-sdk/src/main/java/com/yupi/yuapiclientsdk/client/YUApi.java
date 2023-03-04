package com.yupi.yuapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yupi.yuapiclientsdk.model.User;


import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static com.yupi.yuapiclientsdk.utils.signUtil.gensign;


/**
 * Hutool工具调用接口
 */
public class  YUApi {
    String assessKey;
    String secreteKey;

    public YUApi() {
    }

    public YUApi(String assessKey, String secreteKey) {
        this.assessKey = assessKey;
        this.secreteKey = secreteKey;
    }


    private HashMap<String ,String > getHashMap(String body){

        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey",assessKey);
        map.put("nonce", RandomUtil.randomNumbers(100));
        map.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        map.put("sign",gensign(secreteKey,body));
        map.put("body",body);
//        map.put("secreteKey",secreteKey);
        return map;
    }

    public String getNameByGet(String name) {

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result3 = HttpUtil.get("http://localhost:8023/api/name/", paramMap);


        return result3;
    }


    public String getNameByGPost( String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result3 = HttpUtil.post("http://localhost:8023/api/name/", paramMap);

        return result3;
    }

    public String getUserByGPost( User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse execute = HttpRequest.post("http://localhost:8023/api/name/user")
                .charset(StandardCharsets.UTF_8)
                .addHeaders(getHashMap(json))
                .body(json)
                .execute();
        System.out.println(execute.getStatus());
        String result = execute.body();

        return result;

    }
}
