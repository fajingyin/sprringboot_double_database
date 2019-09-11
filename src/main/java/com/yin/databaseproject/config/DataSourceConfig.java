package com.yin.databaseproject.config;

import com.github.pagehelper.PageInterceptor;
import com.yin.databaseproject.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.apache.ibatis.plugin.Interceptor;
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
@MapperScan(basePackages = DataSourceConfig.PACKAGE,sqlSessionFactoryRef = "druidSqlSessionFactory")
public class DataSourceConfig {
    //mapper文件目录
    static final String PACKAGE = "com.yin.databaseproject.dao.pingyougou";
    //database驱动器
    @Value("${spring.user.datasourceType}")
    private Class<? extends DataSource> dataSourcceType;
    //mapper文件目录
    private static final String MAPPER_LOCATIONS = "classpath:mapping/pingyougou/*.xml";

    //处理器包.
    private static final String TYPE_HANDLERS_PACKAGE = "com.yin.handler";
    //暂时不用
    private static final String TYPE_ALIASES_PACKAGE = "com.yin.type";

    @Resource(name = "mybatisConfig")
    private org.apache.ibatis.session.Configuration mybatisConfig;

    @Resource(name = "pageInterceptor")
    private PageInterceptor pageInterceptor;

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties("spring.user.datasource")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().type(dataSourcceType).build();
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(){
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "druidSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource) {
        return SqlSessionFactoryUtil.createSqlSessionFactory(masterDataSource,TYPE_ALIASES_PACKAGE,
                TYPE_HANDLERS_PACKAGE,MAPPER_LOCATIONS,mybatisConfig,new Interceptor[] {pageInterceptor});
    }

}
