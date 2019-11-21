package org.aichs.kite.configs;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import org.aichs.kite.properties.DruidDataSourceProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ProjectName: kite
 * @Package: org.aichs.kite.configs
 * @ClassName: DruidDataSourceConfig
 * @Author: MECHREVO
 * @Description: druid配置类
 * @Date: 2019/11/17 13:57
 */
@Configuration
public class DruidDataSourceConfig {

    @Resource
    private DruidDataSourceProperties druid;

    /**
     * @Method
     * @Author MECHREVO
     * @Version  1.0
     * @Description 配置数据
     * @param
     * @Return
     * @Exception
     * @Date 2019/11/17 14:08
     */
    @Bean
    @Primary
    public DataSource dataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(druid.getUrl());
        dataSource.setUsername(druid.getUsername());
        dataSource.setPassword(druid.getPassword());
        dataSource.setDriverClassName(druid.getDriverClassName());

        //configuration
        dataSource.setInitialSize(druid.getInitialSize());
        dataSource.setMinIdle(druid.getMinIdle());
        dataSource.setMaxActive(druid.getMaxActive());
        dataSource.setMaxWait(druid.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(druid.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druid.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(druid.getValidationQuery());
        dataSource.setTestWhileIdle(druid.isTestWhileIdle());
        dataSource.setTestOnBorrow(druid.isTestOnBorrow());
        dataSource.setTestOnReturn(druid.isTestOnReturn());
        dataSource.setPoolPreparedStatements(druid.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(druid.getMaxPoolPreparedStatementPerConnectionSize());

        try {
            dataSource.setFilters(druid.getFilters());
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: " + e);
        }
        dataSource.setConnectionProperties(druid.getConnectionProperties());
        return dataSource;
    }

    /**
     * 注册Filter信息, 监控拦截器
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
