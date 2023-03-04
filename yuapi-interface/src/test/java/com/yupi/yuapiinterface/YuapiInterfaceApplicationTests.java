package com.yupi.yuapiinterface;

import com.yupi.yuapiclientsdk.client.YUApi;
import com.yupi.yuapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class YuapiInterfaceApplicationTests {
    @Resource
    private YUApi yuApi;

    @Test
    void contextLoads() {
        String name = yuApi.getNameByGet("dashabi");
        User user = new User();
        user.setUserName("aaaaaa");
        String userByGPost = yuApi.getUserByGPost(user);
        System.out.println(name);
        System.out.println(userByGPost);
    }

}
