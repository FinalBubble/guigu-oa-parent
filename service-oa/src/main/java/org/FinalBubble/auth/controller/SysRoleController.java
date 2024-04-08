package org.FinalBubble.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.FinalBubble.auth.model.system.SysRole;
import org.FinalBubble.auth.service.SysRoleService;
import org.FinalBubble.auth.vo.system.SysRoleQueryVo;
import org.FinalBubble.common.Result.Result;
import org.FinalBubble.common.config.exception.GuiguException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: SysRoleController
 * Package: org.FinalBubble.auth.controller
 * Description:
 *
 * @Author 杨其睿
 * @Create 2024-04-08 10:23
 * @Version 1.0
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    //注入service
    @Autowired
    private SysRoleService sysRoleService;

    //查询所有角色
    //@GetMapping("/findAll")
    //public List<SysRole> findAll() {
    //    //调用service方法
    //    List<SysRole> list = sysRoleService.list();
    //    return list;
    //}

    //统一返回数据结果
    @ApiOperation(value = "查询所有角色")
    @GetMapping("/findAll")
    public Result findAll() {
        //调用service方法
        List<SysRole> list = sysRoleService.list();

        //模拟异常效果
        try {
            int i = 0/0;
        } catch (Exception e){
            //抛出自定义异常
            throw new GuiguException(20001, "执行了自定义异常处理...");
        }

        return Result.ok(list);
    }
    
    /**
     * 条件分页查询
     * @param page 当前页
     * @param limit 每页显示记录数
     * @param sysRoleQueryVo 条件对象
     * @return
     */
    @ApiOperation(value = "条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo) {
        //调用service的方法实现
        //1 创建Page对象，传递分页相关参数
        Page<SysRole> pageParam = new Page<>(page, limit);
        //2 封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)) {
            //封装
            wrapper.like(SysRole::getRoleName,roleName);
        }
        //3 调用方法实现
        Page<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }

    //添加角色
    @ApiOperation(value = "添加角色")
    @PostMapping("save")
    public Result save(SysRole sysRole) {
        //调用service方法
        boolean is_success = sysRoleService.save(sysRole);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //修改角色-根据id查询
    @ApiOperation(value = "根据id查询")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    //修改角色-最终需改
    @ApiOperation(value = "修改角色")
    @PostMapping("update")
    public Result update(SysRole sysRole) {
        //调用service方法
        boolean is_success = sysRoleService.updateById(sysRole);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //根据id删除
    @ApiOperation(value = "根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        boolean is_success = sysRoleService.removeById(id);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //批量删除
    @ApiOperation(value = "批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        boolean is_success = sysRoleService.removeByIds(idList);
        if (is_success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}
