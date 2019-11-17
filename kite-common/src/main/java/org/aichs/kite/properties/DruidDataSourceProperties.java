package org.aichs.kite.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: kite
 * @Package: org.aichs.kite.properties
 * @ClassName: DruidDataSourceProperties
 * @Author: MECHREVO
 * @Description: 数据库配置类
 * @Date: 2019/11/17 13:59
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.druid")
//@PropertySource("classpath:/kite-web/application.yml")
@EnableConfigurationProperties(DruidDataSourceProperties.class)
public class DruidDataSourceProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private int maxWait;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;
}
