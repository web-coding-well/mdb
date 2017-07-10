package com.junmeng.mdb.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

import javax.persistence.EntityManager
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactorySecondary",
        transactionManagerRef = "transactionManagerSecondary",
        basePackages = arrayOf("com.junmeng.mdb.repository.secondary")) //设置Repository所在位置
class SecondaryConfig {

    @Autowired
    @Qualifier("secondaryDataSource")
    lateinit var secondaryDataSource: DataSource

    @Bean(name = arrayOf("entityManagerSecondary"))
    fun entityManager(builder: EntityManagerFactoryBuilder): EntityManager {
        return entityManagerFactorySecondary(builder).`object`.createEntityManager()
    }

    @Bean(name = arrayOf("entityManagerFactorySecondary"))
    fun entityManagerFactorySecondary(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
                .dataSource(secondaryDataSource)
                .properties(getVendorProperties(secondaryDataSource))
                .packages("com.junmeng.mdb.entity.secondary") //设置实体类所在位置
                .persistenceUnit("secondaryPersistenceUnit")
                .build()
    }

    @Autowired
    private val jpaProperties: JpaProperties? = null

    private fun getVendorProperties(dataSource: DataSource): Map<String, String> {
        return jpaProperties!!.getHibernateProperties(dataSource)
    }

    @Bean(name = arrayOf("transactionManagerSecondary"))
    internal fun transactionManagerSecondary(builder: EntityManagerFactoryBuilder): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactorySecondary(builder).`object`)
    }

}