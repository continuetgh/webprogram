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
 * @since 2023-04-12
 */
@Getter
@Setter
  @TableName("xunta_article")
@ApiModel(value = "Article对象", description = "")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("标题")
      private String name;

      @ApiModelProperty("内容")
      private String content;

      @ApiModelProperty("发布人")
      private String user;

      @ApiModelProperty("发布时间")
      private String time;


}
