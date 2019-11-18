package top.imlgw.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author imlgw.top
 * @date 2019/11/18 18:30
 */
@SpringBootApplication
@ComponentScan
@MapperScan(basePackages = "top.imlgw.demo.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
