package com.yupi.project.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.project.annotation.AuthCheck;
import com.yupi.project.common.*;
import com.yupi.project.constant.CommonConstant;
import com.yupi.project.constant.UserConstant;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.model.dto.userInterfaceInfo.UserInterfaceInfoAddRequest;
import com.yupi.project.model.dto.userInterfaceInfo.UserInterfaceInfoQueryRequest;
import com.yupi.project.model.dto.userInterfaceInfo.UserInterfaceInfoUpdateRequest;
import com.yupi.project.service.UserInterfaceInfoService;
import com.yupi.project.service.UserService;
import com.yupi.yuapicommon.model.entity.User;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 帖子接口
 *
 * @author yupi
 */
@RestController
@RequestMapping("/InterfaceInfo")
@Slf4j
public class UserInterfaceInfoController {

    @Resource
    private UserInterfaceInfoService UserInterfaceInfoService;

    @Resource
    private UserService userService;


    // region 增删改查

    /**
     * 创建
     *
     * @param userInterfaceInfoAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Long> addInterfaceInfo(@RequestBody UserInterfaceInfoAddRequest userInterfaceInfoAddRequest, HttpServletRequest request) {
        if (userInterfaceInfoAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo UserInterfaceInfo = new UserInterfaceInfo();
        BeanUtils.copyProperties(userInterfaceInfoAddRequest, UserInterfaceInfo);
        // 校验
        UserInterfaceInfoService.validUserInterfaceInfo(UserInterfaceInfo, true);
        User loginUser = userService.getLoginUser(request);
        UserInterfaceInfo.setUserId(loginUser.getId());
        boolean result = UserInterfaceInfoService.save(UserInterfaceInfo);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        long newInterfaceInfoId = UserInterfaceInfo.getId();
        return ResultUtils.success(newInterfaceInfoId);
    }

    /**
     * 删除
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> deleteInterfaceInfo(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User user = userService.getLoginUser(request);
        long id = deleteRequest.getId();
        // 判断是否存在
        UserInterfaceInfo oldInterfaceInfo = UserInterfaceInfoService.getById(id);
        if (oldInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 仅本人或管理员可删除
        if (!oldInterfaceInfo.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean b = UserInterfaceInfoService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新
     *
     * @param InterfaceInfoUpdateRequest
     * @param request
     * @return
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateInterfaceInfo(@RequestBody UserInterfaceInfoUpdateRequest InterfaceInfoUpdateRequest,
                                            HttpServletRequest request) {
        if (InterfaceInfoUpdateRequest == null || InterfaceInfoUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo InterfaceInfo = new UserInterfaceInfo();
        BeanUtils.copyProperties(InterfaceInfoUpdateRequest, InterfaceInfo);
        // 参数校验
        UserInterfaceInfoService.validUserInterfaceInfo(InterfaceInfo, false);
        User user = userService.getLoginUser(request);
        long id = InterfaceInfoUpdateRequest.getId();
        // 判断是否存在
        UserInterfaceInfo oldInterfaceInfo = UserInterfaceInfoService.getById(id);
        if (oldInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 仅本人或管理员可修改
        if (!oldInterfaceInfo.getUserId().equals(user.getId()) && !userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        boolean result = UserInterfaceInfoService.updateById(InterfaceInfo);
        return ResultUtils.success(result);
    }

    /**
     * 根据 id 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<UserInterfaceInfo> getInterfaceInfoById(long id) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo InterfaceInfo = UserInterfaceInfoService.getById(id);
        return ResultUtils.success(InterfaceInfo);
    }

    /**
     * 获取列表（仅管理员可使用）
     *
     * @param InterfaceInfoQueryRequest
     * @return
     */
    @AuthCheck(mustRole = "admin")
    @GetMapping("/list")
    public BaseResponse<List<UserInterfaceInfo>> listInterfaceInfo(UserInterfaceInfoQueryRequest InterfaceInfoQueryRequest) {
        UserInterfaceInfo InterfaceInfoQuery = new UserInterfaceInfo();
        if (InterfaceInfoQueryRequest != null) {
            BeanUtils.copyProperties(InterfaceInfoQueryRequest, InterfaceInfoQuery);
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>(InterfaceInfoQuery);
        List<UserInterfaceInfo> InterfaceInfoList = UserInterfaceInfoService.list(queryWrapper);
        return ResultUtils.success(InterfaceInfoList);
    }

    /**
     * 分页获取列表
     *
     * @param InterfaceInfoQueryRequest
     * @param request
     * @return
     */
    @GetMapping("/list/page")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Page<UserInterfaceInfo>> listInterfaceInfoByPage(UserInterfaceInfoQueryRequest InterfaceInfoQueryRequest, HttpServletRequest request) {
        if (InterfaceInfoQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo InterfaceInfoQuery = new UserInterfaceInfo();
        BeanUtils.copyProperties(InterfaceInfoQueryRequest, InterfaceInfoQuery);
        long current = InterfaceInfoQueryRequest.getCurrent();
        long size = InterfaceInfoQueryRequest.getPageSize();
        String sortField = InterfaceInfoQueryRequest.getSortField();
        String sortOrder = InterfaceInfoQueryRequest.getSortOrder();
        // 限制爬虫
        if (size > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>(InterfaceInfoQuery);
        queryWrapper.orderBy(StringUtils.isNotBlank(sortField),
                sortOrder.equals(CommonConstant.SORT_ORDER_ASC), sortField);
        Page<UserInterfaceInfo> InterfaceInfoPage = UserInterfaceInfoService.page(new Page<>(current, size), queryWrapper);
        return ResultUtils.success(InterfaceInfoPage);
    }

    // endregion





}
