package org.FinalBubble.auth;

import org.FinalBubble.auth.model.system.SysRole;
import org.FinalBubble.auth.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

/**
 * ClassName: TestMpDemo2
 * Package: org.FinalBubble.auth
 * Description:
 *
 * @Author 杨其睿
 * @Create 2024-04-08 9:59
 * @Version 1.0
 */
@SpringBootTest
public class TestMpDemo2 {
    //注入
    @Autowired
    private SysRoleService service;

    //查询所有记录
    @Test
    public void getAll(){
        List<SysRole> list = service.list();
        System.out.println(list);
    }


}
