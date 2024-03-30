package com.xunta.springboot.entity;

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
  @TableName("xunta_umbrella")
@ApiModel(value = "Umbrella对象", description = "")
public class Umbrella implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        private Integer id;

      @ApiModelProperty("图片")
      private String picUrl;

      @ApiModelProperty("最初地址")
      private String oriLocation;

      @ApiModelProperty("中转地址")
      private String preLocation;

      @ApiModelProperty("当前地址")
      private String curLocation;

      @ApiModelProperty("上传系统时间")
      @JsonFormat(pattern = "yyyy-MM-dd")
      private LocalDate uploadTime;


}
