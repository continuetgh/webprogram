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
import java.util.Date;

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
  @TableName("xunta_bike")
@ApiModel(value = "Bike对象", description = "")
public class Bike implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        @TableId(value = "ID", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("图片")
      private String picUrl;

      @ApiModelProperty("车牌号")
      private String lpn;

      @ApiModelProperty("最初地址")
      private String oriLocation;

      @ApiModelProperty("中转地址")
      private String preLocation;

      @ApiModelProperty("目前地址")
      private String curLocation;

      @ApiModelProperty("上传系统的时间")
      @JsonFormat(pattern = "yyyy-MM-dd")
      private Date uploadTime;


}
