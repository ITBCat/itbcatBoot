package cn.itbcat.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//MVC
@EnableWebMvc
//开启缓存
@EnableCaching
//开启servlet
@ServletComponentScan
//开启socket
//@EnableWebSocket
//开启定时器
@EnableScheduling

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer(){
//		return new EmbeddedServletContainerCustomizer() {
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				container.setSessionTimeout(36000);//单位为S
//			}
//		};
//	}
	/*@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setLocation("");
		return factory.createMultipartConfig();
	}*/

}
