package com.yin.databaseproject.config;

import com.github.pagehelper.PageInterceptor;
import com.yin.databaseproject.util.SqlSessionFactoryUtil;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author yin
 * @Date 2019/9/8 19:48
 * @Method
 */
@Configuration
@MapperScan(basePackages = DataSqlConfig.PACKAGE,sqlSessionFactoryRef = "DataSqlSessionFactory")
public class DataSqlConfig {
    //mapper文件目录
    static final String PACKAGE = "com.yin.databaseproject.dao.datasql";
    //database驱动器
    @Value("${spring.item.datasourceType}")
    private Class<? extends DataSource> dataSourcceType;
    //mapper文件目录
    private static final String MAPPER_LOCATIONS = "classpath:mapping/datasql/*.xml";

    //处理器包.
    private static final String TYPE_HANDLERS_PACKAGE = "com.yin.handler";
    //暂时不用
    private static final String TYPE_ALIASES_PACKAGE = "com.yin.type";

    @Resource(name = "mybatisConfig")
    private org.apache.ibatis.session.Configuration mybatisConfig;

    @Resource(name = "pageInterceptor")
    private PageInterceptor pageInterceptor;

    @Bean(name = "sqlDataSource")
    @ConfigurationProperties("spring.item.datasource")
    public DataSource sqlDataSource(){
        return DataSourceBuilder.create().type(dataSourcceType).build();
    }

    @Bean(name = "sqlTransactionManager")
    public DataSourceTransactionManager masterTransactionManager(){
        return new DataSourceTransactionManager(sqlDataSource());
    }

    @Bean(name = "DataSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("sqlDataSource") DataSource sqlDataSource) {
        return SqlSessionFactoryUtil.createSqlSessionFactory(sqlDataSource,TYPE_ALIASES_PACKAGE,
                TYPE_HANDLERS_PACKAGE,MAPPER_LOCATIONS,mybatisConfig,new Interceptor[] {pageInterceptor});
    }

}
