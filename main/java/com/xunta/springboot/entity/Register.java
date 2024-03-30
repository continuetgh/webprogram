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
 * @since 2024-03-28
 */
@Getter
@Setter
  @ApiModel(value = "Register对象", description = "")
public class Register implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
      @TableId(value = "ID", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("车主姓名")
      private String name;

      @ApiModelProperty("车主身份证号码")
      private String identity;

      @ApiModelProperty("车牌号")
      private String carnumber;

      @ApiModelProperty("车辆种类")
      private String type;

      @ApiModelProperty("提交时间")
      private LocalDateTime submitTime;


}
