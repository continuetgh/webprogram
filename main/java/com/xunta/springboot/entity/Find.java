package com.xunta.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author school
 * @since 2023-04-08
 */
@Getter
@Setter
  @TableName("xunta_find")
@ApiModel(value = "Find对象", description = "")
public class Find implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        @TableId(value = "ID", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("类型（1、科创组队，2、竞赛组队，3、课程设计组队，4、其他组队）")
      private String type;

      @ApiModelProperty("详情说明")
      private String content;

      @ApiModelProperty("联系电话")
      private String phone;

      @ApiModelProperty("发布时间")
      @JsonFormat(pattern = "yyyy-MM-dd")
      private LocalDate uploadTime;

      @ApiModelProperty("截止时间")
      @JsonFormat(pattern = "yyyy-MM-dd")
      private LocalDate deadlineTime;


}
