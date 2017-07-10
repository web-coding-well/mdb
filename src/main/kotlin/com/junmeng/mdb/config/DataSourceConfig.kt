package com.junmeng.mdb.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary


/**
 * Created by hwj on 2017/7/7.
 */
@Configuration
class DataSourceConfig {

    @Bean(name = arrayOf("primaryDataSource") )
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    fun primaryDataSource(): javax.sql.DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean(name = arrayOf("secondaryDataSource"))
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    fun secondaryDataSource(): javax.sql.DataSource {
        return DataSourceBuilder.create().build()
    }

}