package com.xunta.springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameNumber {

    @JsonProperty("value") //echarts 要求返回的名称，要不封装不上数据
    private int number;

    @JsonProperty("name") //echarts 要求返回的名称，要不封装不上数据
    private String goodsname;
}
