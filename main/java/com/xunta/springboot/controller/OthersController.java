package com.xunta.springboot.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunta.springboot.entity.Others;
import com.xunta.springboot.service.IOthersService;
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
@RequestMapping("/others")
public class OthersController {

        //动态生成
        @Resource
          private IOthersService othersService;
          //新增或者更新
        @PostMapping
          public Boolean save(@RequestBody Others others) {
                return othersService.saveOrUpdate(others);
                }
        //删除
        @DeleteMapping("/{id}")
          public Boolean delete(@PathVariable Integer id) {
                return othersService.removeById(id);
                }
    //批量删除
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){return othersService.removeByIds(ids);}
                //查询所有
        @GetMapping
          public List<Others> findAll() {
                return othersService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Others findOne(@PathVariable Integer id) {
                return othersService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
          public Page<Others> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize){

        QueryWrapper<Others> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return othersService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
        //数据导出接口
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Others> list = othersService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id","id");
        writer.addHeaderAlias("pic_url","图片");
        writer.addHeaderAlias("LPN","车牌号");
        writer.addHeaderAlias("ori_location", "发现地址");
        writer.addHeaderAlias("pre_location", "中转地址");
        writer.addHeaderAlias("cur_location","目前地址");
        writer.addHeaderAlias("upload_time","转移时间");
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("用户信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }

}

