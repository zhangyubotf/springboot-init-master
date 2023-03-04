package com.yupi.yuapicommon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;
/**
* @author zyb10
* @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service
* @createDate 2023-02-27 21:34:43
*/
public interface InnerUserInterfaceInfoService  {

    /**
     * 统计次数
     * @param userId
     * @param interfaceIfoId
     * @return
     */
    boolean invokeCount(long userId,long interfaceIfoId);

    /**
     * 查询表信息
     * @param userId
     * @param interfaceId
     * @return
     */
    UserInterfaceInfo selectOneById(long userId,long interfaceId);

    /**
     * 给新用户第一次调用的接口给予初始次数
     * @param userId
     * @param interfaceIfoId
     * @return
     */

    boolean creatinfo(long userId, long interfaceIfoId);



}
