package com.yupi.project.model.vo;

import com.yupi.project.model.entity.Post;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口信息封装试图
 *
 * @author yupi
 * @TableName product
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 使用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}