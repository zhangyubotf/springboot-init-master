package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;

/**
* @author zyb10
* @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service
* @createDate 2023-02-27 21:34:43
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add);

    /**
     * 统计次数
     * @param userId
     * @param interfaceIfoId
     * @return
     */
    boolean invokeCount(long userId,long interfaceIfoId);

    UserInterfaceInfo selectOneById(long userId,long interfaceId);
    boolean creatinfo(long userId, long interfaceIfoId);

}
