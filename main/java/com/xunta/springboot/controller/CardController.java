package com.xunta.springboot.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunta.springboot.entity.Card;
import com.xunta.springboot.service.ICardService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author school
 * @since 2023-04-08
 */
@RestController
@RequestMapping("/card")
public class CardController {

        //动态生成
        @Resource
          private ICardService cardService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Card card) {
                return cardService.saveOrUpdate(card);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return cardService.removeById(id);
                }
    //批量删除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){return cardService.removeByIds(ids);}
        //查询所有
        @GetMapping
          public List<Card> findAll() {
                return cardService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Card findOne(@PathVariable Integer id) {
                return cardService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Card> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String number,
                                @RequestParam(defaultValue = "") String name,
                                @RequestParam(defaultValue = "")String department,
                                @RequestParam(defaultValue = "") String oriLocation,
                                @RequestParam(defaultValue = "")String curLocation)
        {

        QueryWrapper<Card> queryWrapper=new QueryWrapper<>();
            if (!"".equals(number)) {
                queryWrapper.like("number", number);
            }
            if (!"".equals(name)) {
                queryWrapper.like("name", name);
            }
            if (!"".equals(department)) {
                queryWrapper.like("department", department);
            }
            if (!"".equals(oriLocation)) {
                queryWrapper.like("oriLocation", oriLocation);
            }
            if (!"".equals(curLocation)) {
                queryWrapper.like("curLocation", curLocation);
            }
        queryWrapper.orderByAsc("id");
        return cardService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
        //数据导出接口
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Card> list = cardService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id","id");
        writer.addHeaderAlias("number","学工号");
        writer.addHeaderAlias("name","姓名");
        writer.addHeaderAlias("department","学院（部门）");
        writer.addHeaderAlias("oriLocation", "发现地址");
        writer.addHeaderAlias("preLocation", "中转地址");
        writer.addHeaderAlias("curLocation","目前地址");
        writer.addHeaderAlias("picUrl","图片");
        writer.addHeaderAlias("uploadTime","上传时间");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("校园卡丢失信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

}

