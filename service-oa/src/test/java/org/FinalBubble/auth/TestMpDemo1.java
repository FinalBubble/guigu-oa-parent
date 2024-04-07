package org.FinalBubble.auth;


import org.FinalBubble.auth.mapper.SysRoleMapper;
import org.FinalBubble.auth.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: TestMpDemo1
 * Package: org.FinalBubble.auth
 * Description:
 *
 * @Author 杨其睿
 * @Create 2024-04-07 15:43
 * @Version 1.0
 */
@SpringBootTest
public class TestMpDemo1 {

    //注入
    @Autowired
    private SysRoleMapper mapper;

    @Test
    public void getAll() {
        List<SysRole> list = mapper.selectList(null);
        System.out.println(list);
    }

}
