-- 帖子表
create table if not exists user_interface_info
(
    id            bigint auto_increment comment 'id' primary key,
    userId        bigint                             not null comment '调用用户 id',
    interfaceInfoId     bigint                       not null comment '接口的 id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status`  int      default 0                 not null comment '状态（0-正常, 1-禁用, 2-拒绝）',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除'

    ) comment '用户接口关系表'