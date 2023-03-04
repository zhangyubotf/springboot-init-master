package com.yupi.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.yuapicommon.model.entity.User;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;

import java.util.List;


/**
* @author zyb10
* @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Mapper
* @createDate 2023-02-27 21:34:43
* @Entity generator.domain.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {


    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}




