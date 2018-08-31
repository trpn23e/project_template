package net.pis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Boot Main설정 파일
 * (war 배포시에는 SpringBootServletInitializer가 상속되야 한다고 하는데..
 *  실제로 그런지는 모르겠음)
 */
@Configuration
@EnableJpaAuditing
@EntityScan(basePackageClasses = {MainApplication.class ,Jsr310JpaConverters.class}, basePackages = {"net.pis.repository"})
@SpringBootApplication
// @SpringBootApplication (
// 	scanBasePackages={"net.pis"}
// )
@EnableAsync
@EnableMBeanExport
@ComponentScan("net.pis")
// @ComponentScan(
// 	basePackages = "net.pis",
// 	excludeFilters = {
// 			@ComponentScan.Filter(Configuration.class), //@ComponentScan.Filter(type=FilterType.ASPECTJ, pattern="com.bizon.sbms.server.dti.adapter.service.PollingTaskService")
// 	}
// )
@EnableAspectJAutoProxy
// @EnableScheduling
@EnableTransactionManagement
// public class ExApplication extends ServletInitializer{
public class MainApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
