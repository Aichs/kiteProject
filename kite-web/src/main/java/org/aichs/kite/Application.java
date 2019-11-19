package org.aichs.kite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;


/**
 * @Method
 * @Author MECHREVO
 * @Version  1.0
 * @Description
 * @param
 * @Return
 * @Exception
 * @Date 2019/11/17 15:31
 */
@ServletComponentScan
@MapperScan("org.aichs.kite")
@EnableScheduling
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//     list<S>   list.parallelStream().filter(x->x!="5").forEach(x->{System.out.println(x);});
//    }
}
