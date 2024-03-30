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
 * @since 2024-03-29
 */
@Getter
@Setter
  @ApiModel(value = "Complain对象", description = "")
public class Complain implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        @TableId(value = "ID", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("违停地点")
      private String location;

      @ApiModelProperty("违停车牌号")
      private String carnumber;

      @ApiModelProperty("违停描述")
      private String description;

      @ApiModelProperty("第一张图片链接")
      private String image1;

      @ApiModelProperty("第二张图片链接")
      private String image2;

      @ApiModelProperty("第三张图片链接")
      private String image3;

      @ApiModelProperty("第四张图片链接")
      private String image4;

      @ApiModelProperty("提交时间")
      private LocalDateTime time;


}
