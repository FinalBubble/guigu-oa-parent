package org.FinalBubble.auth;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: ServiceAuthApplication
 * Package: org.FinalBubble.auth
 * Description:
 *
 * @Author 杨其睿
 * @Create 2024-04-07 15:38
 * @Version 1.0
 */


@SpringBootApplication
@MapperScan("package org.FinalBubble.auth.mapper")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class,args);
    }
}
