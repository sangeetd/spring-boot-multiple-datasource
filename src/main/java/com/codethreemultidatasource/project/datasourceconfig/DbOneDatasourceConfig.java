package com.codethreemultidatasource.project.datasourceconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		
		entityManagerFactoryRef = "dbOneEntityManagerFactoryRef",
		transactionManagerRef = "dbOneTransactionaManagerRef",
		basePackages = "com.codethreemultidatasource.project.db1"
		
		)
public class DbOneDatasourceConfig {

	@Primary
	@Bean(name = "dbOneDatasourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSourceProperties getDbOneDataSourceProperties() {
		
		return new DataSourceProperties();
		
	}
	
	@Primary
	@Bean(name = "dbOneDatasource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDbOneDataSource(@Qualifier("dbOneDatasourceProperties") DataSourceProperties dataSourceProperties) {
		
		return dataSourceProperties.initializeDataSourceBuilder().build();
		
	}
	
	
	@Primary
	@Bean(name = "dbOneEntityManagerFactoryRef")
	public LocalContainerEntityManagerFactoryBean getDbOneEntityManagerFactoryBean(
			
			@Qualifier("dbOneDatasource") DataSource dataSource,
			EntityManagerFactoryBuilder builder
			
			) {
		
		return builder.dataSource(dataSource)
				.packages("com.codethreemultidatasource.project")
				.persistenceUnit("db1")
				.build();
		
	}
	
	@Primary
	@Bean(name = "dbOneTransactionaManagerRef")
	public PlatformTransactionManager getTransactionManager(@Qualifier("dbOneEntityManagerFactoryRef") EntityManagerFactory entityManagerFactory) {
		
		return new JpaTransactionManager(entityManagerFactory);
		
	}
	
	
}
