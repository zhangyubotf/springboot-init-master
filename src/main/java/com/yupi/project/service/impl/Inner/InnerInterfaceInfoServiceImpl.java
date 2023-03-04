package com.yupi.project.service.impl.Inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.InterfaceInfoMapper;
import com.yupi.yuapicommon.service.InnerInterfaceInfoService;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author tony
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2023-02-23 18:59:26
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    /**
     * @param url
     * @param method
     * @return
     */
    @Override
    public com.yupi.yuapicommon.model.entity.InterfaceInfo getInterfaceInfo(String url, String method) {

        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(queryWrapper);

        return interfaceInfo;
    }
}




