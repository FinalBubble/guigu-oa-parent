package org.FinalBubble.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

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
@ComponentScan("org.FinalBubble")
public class ServiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class,args);
    }
}
