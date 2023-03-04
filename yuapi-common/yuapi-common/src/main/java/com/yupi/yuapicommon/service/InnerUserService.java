package com.yupi.yuapicommon.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author yupi
 */
public interface InnerUserService {

    /**
     * 通过ak  sk  获得用户信息
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
