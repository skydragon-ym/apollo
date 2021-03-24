package com.skydragon.apiapollomobile;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ApiIautoMobileApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		//生成一个设置了连接超时时间、请求超时时间、异常重试次数3次
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(30000).build();
		HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(config).setRetryHandler(new DefaultHttpRequestRetryHandler(3, false));
		HttpClient httpClient = builder.build();
		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		//做个日志拦截器；从性能上考虑，当前屏蔽该功能
		//restTemplate.setInterceptors(Collections.singletonList(new RestTemplateConsumerLogger()));
		return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiIautoMobileApplication.class, args);
	}

}
