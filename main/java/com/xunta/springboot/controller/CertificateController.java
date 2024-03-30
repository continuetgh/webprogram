package com.xunta.springboot.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunta.springboot.entity.Certificate;
import com.xunta.springboot.service.ICertificateService;
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
@RequestMapping("/certificate")
public class CertificateController {

        //动态生成
        @Resource
          private ICertificateService certificateService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Certificate certificate) {
                return certificateService.saveOrUpdate(certificate);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return certificateService.removeById(id);
                }
    //批量删除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){return certificateService.removeByIds(ids);}
        //查询所有
        @GetMapping
          public List<Certificate> findAll() {
                return certificateService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Certificate findOne(@PathVariable Integer id) {
                return certificateService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Certificate> findPage(@RequestParam Integer pageNum,
                                            @RequestParam Integer pageSize,
                                            @RequestParam(defaultValue = "") String type,
                                            @RequestParam(defaultValue = "") String oriLocation,
                                            @RequestParam(defaultValue = "")String curLocation){

        QueryWrapper<Certificate> queryWrapper=new QueryWrapper<>();

            if (!"".equals(type)) {
                queryWrapper.like("type", type);
            }
            if (!"".equals(oriLocation)) {
                queryWrapper.like("oriLocation", oriLocation);
            }
            if (!"".equals(curLocation)) {
                queryWrapper.like("curLocation", curLocation);
            }
        queryWrapper.orderByAsc("id");
        return certificateService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Certificate> list = certificateService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id","id");
        writer.addHeaderAlias("name","姓名");
        writer.addHeaderAlias("type","类型");
        writer.addHeaderAlias("oriLocation", "发现地址");
        writer.addHeaderAlias("preLocation", "中转地址");
        writer.addHeaderAlias("curLocation","目前地址");
        writer.addHeaderAlias("uploadTime","转移时间");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("证件信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

}

