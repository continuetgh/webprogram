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
  @TableName("xunta_certificate")
@ApiModel(value = "Certificate对象", description = "")
public class Certificate implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        @TableId(value = "ID", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("丢失证件照片")
      private String picUrl;

      @ApiModelProperty("例如：身份证、学生证、护照、其他")
      private String type;

      @ApiModelProperty("丢失者姓名")
      private String name;

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
