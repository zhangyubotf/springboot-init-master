package com.yupi.project.service.impl.Inner;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.service.UserInterfaceInfoService;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;
import com.yupi.yuapicommon.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zyb10
 * @description 针对表【user_interface_info(用户接口关系表)】的数据库操作Service实现
 * @createDate 2023-02-27 21:34:43
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long userId, long interfaceIfoId) {
        return userInterfaceInfoService.invokeCount(userId, interfaceIfoId);
    }

    @Override
    public UserInterfaceInfo selectOneById(long userId, long interfaceId) {
        return userInterfaceInfoService.selectOneById(userId,interfaceId);
    }

    @Override
    public boolean creatinfo(long userId, long interfaceIfoId) {
        return userInterfaceInfoService.creatinfo(userId,interfaceIfoId);
    }

}




