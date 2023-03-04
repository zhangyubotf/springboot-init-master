//package com.yupi.project.model.entity;
//
//import com.baomidou.mybatisplus.annotation.*;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * 接口信息
// * @TableName interface_info
// */
//@TableName(value ="interface_info")
//@Data
//public class InterfaceInfo implements Serializable {
//    /**
//     * 主键
//     */
//    @TableId(type = IdType.AUTO)
//    private Long id;
//
//    /**
//     * 用户名
//     */
//    private String name;
//
//    /**
//     * 接口地址
//     */
//    private String url;
//
//    /**
//     * 详情
//     */
//    private String description;
//
//    /**
//     * 请求类型
//     */
//    private String method;
//
//    /**
//     * 用户名
//     */
//    private Long userid;
//
//    /**
//     * 接口状态
//     */
//    private Integer status;
//
//
//    /**
//     * 请求参数
//     */
//    private String requestParams;
//
//
//    /**
//     * 请求头
//     */
//    private String requestHeader;
//
//    /**
//     * 响应头
//     */
//    private String respondHead;
//
//    /**
//     * 更新时间
//     */
//    private Date updateTime;
//
//    /**
//     * 创建时间
//     */
//    private Date createTime;
//
//    /**
//     * 是否删除(0-未删, 1-已删)
//     */
//    @TableLogic
//    private Integer isDeleted;
//
//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;
//
//}