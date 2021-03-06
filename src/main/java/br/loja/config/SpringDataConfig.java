package br.loja.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("br")
@EnableTransactionManagement //Controle de transações
@PropertySource("classpath:/application.properties")
public class SpringDataConfig {
	
	@Autowired
	private Environment env; //É uma propridade do spring o Environment
	
	@Bean 
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory) { 
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		manager.setJpaDialect(new HibernateJpaDialect());
		return manager;
	}
	
	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() { //Diz que vamos utilizar o hibernate como framework ORM
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(env.getProperty("hibernate.show.sql", Boolean.class));
		adapter.setGenerateDdl(env.getProperty("hibernate.ddl", Boolean.class));
		return adapter;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() { //Cria a fabrica de entidade que é controlada pelo spring		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setPackagesToScan(env.getProperty("hibernate.package.scan"));
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();		
		return factory.getObject();
	}
	
	@Bean(name = "dataSource")
	public DataSource dataSource() {// Pool de conexão é quem vai controlar cada conexão criada por cada usuário
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClass"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		return dataSource;
	}

}
