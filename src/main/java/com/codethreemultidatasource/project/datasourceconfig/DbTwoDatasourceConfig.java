package com.codethreemultidatasource.project.datasourceconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		
		entityManagerFactoryRef = "dbTwoEntityManagerFactoryRef",
		transactionManagerRef = "dbTwoTransactionManagerRef",
		basePackages = "com.codethreemultidatasource.project.db2"
		
		)
public class DbTwoDatasourceConfig {

	
	@Bean(name = "dbTwoDatasourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSourceProperties getDbTwoDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name = "dbTwoDatasource")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource getDbTwoDataSource(@Qualifier("dbTwoDatasourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}
	
	@Bean(name = "dbTwoEntityManagerFactoryRef")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(
			
			@Qualifier("dbTwoDatasource") DataSource dataSource,
			EntityManagerFactoryBuilder builder
			
			) {
		
		return builder.dataSource(dataSource)
				.packages("com.codethreemultidatasource.project")
				.persistenceUnit("db2")
				.build();
		
	}
	
	@Bean(name = "dbTwoTransactionManagerRef")
	public PlatformTransactionManager getTransactionManager(@Qualifier("dbTwoEntityManagerFactoryRef") EntityManagerFactory dbTwoEntityManagerFactory) {
		
		return new JpaTransactionManager(dbTwoEntityManagerFactory);
		
	}
	
	
}
