package cn.itbcat.boot.config.socket;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.utils.ITBC;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.ServletContext;

/**
 * WebSocket 配置 Created by Silence on 2017/4/20.
 */
@Configuration
@Log4j
public class WebSocketConfig implements ApplicationContextAware {

	public static ApplicationContext appContext;

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	@Bean
	public ServletContextAware endpointExporterInitializer(final ApplicationContext applicationContext) {
		return new ServletContextAware() {
			@Override
			public void setServletContext(ServletContext servletContext) {
				ServerEndpointExporter exporter = new ServerEndpointExporter();
				exporter.setApplicationContext(applicationContext);
				exporter.afterPropertiesSet();
			}
		};
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;
	}
}
