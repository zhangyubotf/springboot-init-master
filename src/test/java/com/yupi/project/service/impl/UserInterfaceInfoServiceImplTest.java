package com.yupi.project.service.impl;



import com.yupi.project.service.UserInterfaceInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserInterfaceInfoServiceImplTest {

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;
    @Test
    public void invokeCount() {
        System.out.println("远程调用结果：   "+userInterfaceInfoService.invokeCount(1,1));
    }
}