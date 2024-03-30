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
 * @since 2023-04-13
 */
@Getter
@Setter
  @TableName("xunta_asse")
@ApiModel(value = "Asse对象", description = "")
public class Asse implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        @TableId(value = "ID", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("物品类型")
      private String type;

      @ApiModelProperty("图片")
      private String picUrl;

      @ApiModelProperty("发现地址")
      private String oriLocation;

      @ApiModelProperty("中转地址")
      private String preLocation;

      @ApiModelProperty("当前地址")
      private String curLocation;

      @ApiModelProperty("上传系统时间")
      @JsonFormat(pattern = "yyyy-MM-dd")
      private LocalDate uploadTime;


}
