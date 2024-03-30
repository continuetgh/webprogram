package com.xunta.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author school
 * @since 2022-08-18
 */
@Getter
@Setter

@TableName("student_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户类型（0--管理员，1--后勤人员/保安，2--学生）")
    private String type;

    @ApiModelProperty("学工号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("手机号码")
    private String mp;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("部门（例如：信息工程学院、海洋科学与工程学院后勤中心、保卫处）")
    private String department;

    @ApiModelProperty("账号状态（0--正常，1--禁用）")
    private String status;

    @ApiModelProperty("头像链接")
    private String avatarUrl;


}
