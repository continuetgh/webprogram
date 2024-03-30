package com.xunta.springboot.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.springboot.controller.dto.UserDTO;
import com.school.springboot.controller.dto.UserPasswordDTO;
/*import com.sun.istack.internal.NotNull;*/
import com.xunta.springboot.common.Constants;
import com.xunta.springboot.common.Result;
import com.xunta.springboot.entity.User;
import com.xunta.springboot.mapper.UserMapper;
import com.xunta.springboot.service.IUserService;
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
@RequestMapping("/user")
public class UserController {

        //动态生成
        @Resource
        private IUserService userService;
        @Resource
        private UserMapper userMapper;

    /**
     * 登录
     * @param userDTO
     * @return 返回用户信息
     *
     */
    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.code_400, "参数错误");
        }
        UserDTO dto = userService.login(userDTO);
        return Result.success(dto);
    }

    /**
     * 注册
     * @param userDTO
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO) {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.code_400, "参数错误");
        }
        return Result.success(userService.register(userDTO));
    }
/**
     * 修改密码
     *
     * @param userPasswordDTO
     * @return
     */
    @PostMapping("/password")
    public Result password(@RequestBody UserPasswordDTO userPasswordDTO) {
        userService.updatePassword(userPasswordDTO);
        return Result.success();
    }
    //新增或者更新
        @PostMapping
          public boolean save(@RequestBody User user) {
                return userService.saveOrUpdate(user);
                }
        //删除
        @DeleteMapping("/{id}")
          public boolean delete(@PathVariable Integer id) {
                return userService.removeById(id);
                }
         //批量删除
        @PostMapping("/del/batch")
        public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }
        //查询所有
        @GetMapping("/all")
          public List<User> findAll(String type) {

            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.notLike("type", "0");
            return userMapper.selectList(queryWrapper);
        }

        //根据id查询
        @GetMapping("/{id}")
        public User findOne(@PathVariable Integer id) {
                return userService.getById(id);
                }
        //分页查询
        @GetMapping("/page")
         public Page<User> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam(defaultValue = "") String username, @RequestParam(defaultValue = "") String department){
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.notLike("type", "0");
            if (!"".equals(username)) {
                queryWrapper.like("username", username);
            }
            if (!"".equals(department)) {
                queryWrapper.like("department", department);
            }
          queryWrapper.orderByAsc("type");
          return userService.page(new Page<>(pageNum,pageSize),queryWrapper);
          }
    //导出接口
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<User> list = userService.list();
        // 通过工具类创建writer 写出到磁盘路径
//        ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        //自定义标题别名
        writer.addHeaderAlias("id","id");
        writer.addHeaderAlias("type","类型");
        writer.addHeaderAlias("username", "用户名");
        writer.addHeaderAlias("nickname", "昵称");
        writer.addHeaderAlias("mp", "手机号");
        writer.addHeaderAlias("email", "邮箱");
        writer.addHeaderAlias("department","学院（部门）");
        writer.addHeaderAlias("status","状态");
        writer.addHeaderAlias("avatarUrl", "头像");

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
    /**
    根据用户的用户名获取数据库的用户属性
    * */
    @GetMapping("/username/{username}")
    public Result findByUsername(@PathVariable String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User one = userService.getOne(queryWrapper);
        return Result.success(one);
    }
}

