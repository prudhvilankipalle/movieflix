package io.egen.movieflix;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
		LocalContainerEntityManagerFactoryBean objEmf = new LocalContainerEntityManagerFactoryBean();
		objEmf.setDataSource(getDataSource());
		objEmf.setPackagesToScan("io.egen.movieflix.entity");
		objEmf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		objEmf.setJpaProperties(jpaProperties());
		return objEmf;
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource objDM = new DriverManagerDataSource();
		objDM.setDriverClassName("com.mysql.jdbc.Driver");
		objDM.setUrl("jdbc:mysql://localhost:3306/movieflix_db");
		objDM.setUsername("root");
		objDM.setPassword("12345");
		return objDM;
	}
	
	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory objEmf){
		JpaTransactionManager txnManager = new JpaTransactionManager(objEmf);
		return txnManager;
	}
	
	private Properties jpaProperties(){
		Properties props = new Properties();
		props.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
		props.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		props.setProperty(PersistenceUnitProperties.WEAVING, "false");
		return props;
	}

}
