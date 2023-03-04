package com.yupi.project.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.yupi.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询请求
 *
 * @author yupi
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoQueryRequest extends PageRequest implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 详情
     */
    private String description;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 用户名
     */
    private Long userid;

    /**
     * 接口状态
     */
    private String status;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 请求参数
     */
    private String requestParams;
    /**
     * 响应头
     */
    private String respondHead;


    /**
     * 是否删除(0-未删, 1-已删)
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}