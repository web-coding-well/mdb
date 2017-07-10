package com.junmeng.mdb.config

import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.context.annotation.Primary
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.persistence.EntityManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


/**
 * Created by hwj on 2017/7/7.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary",
        basePackages = arrayOf("com.junmeng.mdb.repository.primary")) //设置Repository所在位置
class PrimaryConfig {

    @Autowired
    @Qualifier("primaryDataSource")
    lateinit var primaryDataSource: DataSource

    @Primary
    @Bean(name = arrayOf( "entityManagerPrimary"))
    fun entityManager(builder: EntityManagerFactoryBuilder): EntityManager {
        return entityManagerFactoryPrimary(builder).`object`.createEntityManager()
    }

    @Primary
    @Bean(name =  arrayOf("entityManagerFactoryPrimary"))
    fun entityManagerFactoryPrimary(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties(primaryDataSource!!))
                .packages("com.junmeng.mdb.entity.primary") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")
                .build()
    }

    @Autowired
    private val jpaProperties: JpaProperties? = null

    private fun getVendorProperties(dataSource: DataSource): Map<String, String> {
        return jpaProperties!!.getHibernateProperties(dataSource)
    }

    @Primary
    @Bean(name =  arrayOf("transactionManagerPrimary"))
    fun transactionManagerPrimary(builder: EntityManagerFactoryBuilder): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactoryPrimary(builder).`object`)
    }

}