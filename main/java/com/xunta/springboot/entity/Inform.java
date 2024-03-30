package com.xunta.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author school
 * @since 2024-03-20
 */
@Getter
@Setter
  @ApiModel(value = "Inform对象", description = "")
public class Inform implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        @TableId(value = "ID", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("标题")
      private String title;

      @ApiModelProperty("内容")
      private String content;

      @ApiModelProperty("发布学院（部门）")
      private String department;

      @ApiModelProperty("发布时间")
      private LocalDateTime time;

      @ApiModelProperty("通知用户的用户名")
      private String username;


}
