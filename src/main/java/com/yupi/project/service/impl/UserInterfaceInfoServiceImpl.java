package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.service.UserInterfaceInfoService;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import com.yupi.yuapicommon.model.entity.User;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zyb10
 * @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service实现
 * @createDate 2023-02-27 21:34:43
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {
    @Resource
    UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add) {
        Long id = userinterfaceInfo.getId();
        Long userId = userinterfaceInfo.getUserId();
        Long interfaceInfoId = userinterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userinterfaceInfo.getTotalNum();
        Integer leftNum = userinterfaceInfo.getLeftNum();
        Integer status = userinterfaceInfo.getStatus();
        Date createTime = userinterfaceInfo.getCreateTime();
        Date updateTime = userinterfaceInfo.getUpdateTime();
        Integer isDelete = userinterfaceInfo.getIsDelete();

        if (userinterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 创建时，所有参数必须非空
        if (add) {
            if (interfaceInfoId < 0 || userId < 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或者用户不存在");
            }
        }
        if (leftNum < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数小于0");
        }
    }

    @Override
    public boolean invokeCount(long userId, long interfaceIfoId) {
        if (userId <= 0 || interfaceIfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "传输参数有误");
        }
        UserInterfaceInfo userInterfaceInfo = selectOneById(userId, interfaceIfoId);
        if (userInterfaceInfo!=null){
            UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("userId", userId);
            updateWrapper.eq("interfaceInfoId", interfaceIfoId);
            updateWrapper.setSql("leftNum = leftNum - 1,totalNum = totalNum + 1");
            boolean update = this.update(updateWrapper);
            return update;
        }
        userInterfaceInfo=new UserInterfaceInfo(userId,interfaceIfoId,0,50);
        int insert = this.userInterfaceInfoMapper.insert(userInterfaceInfo);
        return insert==1;
    }

    /**
     * 根据 userId   和 interfaceId  查询用户  接口信息对应关系  主要包含：是否还有剩余接口调用次数
     * @param userId
     * @param interfaceInfoId
     * @return
     */
    @Override
    public UserInterfaceInfo selectOneById(long userId, long interfaceInfoId) {
        if (userId <= 0 || interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "传输参数有误");
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        queryWrapper.eq("userId", userId);
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoMapper.selectOne(queryWrapper);

        return userInterfaceInfo;
    }


    /**
     * 用于新用户  初始化次数
     * @param userId
     * @param interfaceIfoId
     * @return
     */
    public boolean creatinfo(long userId, long interfaceIfoId) {
        if (userId <= 0 || interfaceIfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "传输参数有误");
        }

        UserInterfaceInfo userInterfaceInfo=new UserInterfaceInfo(userId,interfaceIfoId,0,50);
        int insert = this.userInterfaceInfoMapper.insert(userInterfaceInfo);
        return insert==1;
    }

}




