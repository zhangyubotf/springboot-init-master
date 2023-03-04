package com.yupi.project.model.dto.interfaceInfo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {

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
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String respondHead;


    /**
     * 请求参数
     */
    private String requestParams;
    /**
     * 是否删除(0-未删, 1-已删)
     */
    @TableLogic
    private Integer isDeleted;

    /**
     * 签名账户
     */
    private String accessKey;

    /**
     * 签名密钥
     */
    private String secreteKey;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}