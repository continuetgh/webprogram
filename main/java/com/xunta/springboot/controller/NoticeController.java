package com.xunta.springboot.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunta.springboot.common.Result;
import com.xunta.springboot.entity.Notice;
import com.xunta.springboot.service.INoticeService;
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
 * @since 2023-04-15
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

        //动态生成
        @Resource
          private INoticeService noticeService;
          //新增或者更新
          @PostMapping
          public Result save(@RequestBody Notice notice) {
              if (notice.getId() == null) {
                  notice.setTime(DateUtil.now());
                  //notice.setUser(TokenUtils.getCurrentUser().getNickname());
              }
              noticeService.saveOrUpdate(notice);
              return Result.success();
          }
        //删除
        @DeleteMapping("/{id}")
          public Result delete(@PathVariable Integer id) {
                noticeService.removeById(id);
                return Result.success();
                }
        //批量删除
        @PostMapping("/del/batch")
         public Result deleteBatch(@RequestBody List<Integer> ids){
             noticeService.removeByIds(ids);
             return Result.success();
        }
        //查询所有
        @GetMapping
          public List<Notice> findAll() {
                return noticeService.list();
                }
        //根据id查询
        @GetMapping("/{id}")
          public Notice findOne(@PathVariable Integer id) {
                return noticeService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
        public Result findPage(@RequestParam(defaultValue = "") String name,
                               @RequestParam(required = false) Integer type,
                               @RequestParam Integer pageNum,
                               @RequestParam Integer pageSize) {
            QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("id");
            queryWrapper.eq("type", type);
            if (!"".equals(name)) {
                queryWrapper.like("name", name);
            }
//        User currentUser = TokenUtils.getCurrentUser();
//        if (currentUser.getRole().equals("ROLE_USER")) {
//            queryWrapper.eq("user", currentUser.getUsername());
//        }
            return Result.success(noticeService.page(new Page<>(pageNum, pageSize), queryWrapper));
        }
    /**
     * 导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Notice> list = noticeService.list();
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("公告信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

}

