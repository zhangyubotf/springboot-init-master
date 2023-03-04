package com.yupi.project.service.impl.Inner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserMapper;
import com.yupi.yuapicommon.model.entity.User;
import com.yupi.yuapicommon.service.InnerUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;



/**
 * 用户服务实现类
 *
 * @author yupi
 */
@DubboService
@Slf4j
public class InnerUserServiceImpl  implements  InnerUserService {

    @Resource
    private  UserMapper userMapper;

    /**
     * 供给网关调用  获取user信息
     * @param accessKey
     * @return
     */
    @Override
    public com.yupi.yuapicommon.model.entity.User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)){
            throw  new BusinessException(ErrorCode.PARAMS_ERROR,"密钥有误");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey",accessKey);
        User user = userMapper.selectOne(queryWrapper);

        return user;
    }
}




