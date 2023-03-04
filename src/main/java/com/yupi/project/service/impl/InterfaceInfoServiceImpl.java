package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;

import com.yupi.project.model.entity.Post;
import com.yupi.project.model.enums.PostGenderEnum;
import com.yupi.project.model.enums.PostReviewStatusEnum;
import com.yupi.project.service.InterfaceInfoService;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import com.yupi.yuapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author tony
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-02-23 18:59:26
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = interfaceInfo.getId();
        String name = interfaceInfo.getName();
        String url = interfaceInfo.getUrl();
        String description = interfaceInfo.getDescription();
        String method = interfaceInfo.getMethod();
        Long userid = interfaceInfo.getUserid();
        Integer status = interfaceInfo.getStatus();
        String requestHeader = interfaceInfo.getRequestHeader();
        String respondHead = interfaceInfo.getRespondHead();
        Date updateTime = interfaceInfo.getUpdateTime();
        Date createTime = interfaceInfo.getCreateTime();
        Integer isDeleted = interfaceInfo.getIsDeleted();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name)&&name.length()>50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容长的1");
        }
    }
}




