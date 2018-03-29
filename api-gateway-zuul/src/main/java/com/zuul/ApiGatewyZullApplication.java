package com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


import java.io.FileReader;
import java.io.IOException;


import brave.sampler.Sampler;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewyZullApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewyZullApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	}
	
	
	
	@Bean
	public Docket api() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
        return new Docket(DocumentationType.SWAGGER_2)  
                .select() 
                .apis(RequestHandlerSelectors.basePackage("com.demo.demo.zuul"))
                .paths(PathSelectors.any())                          
                .build().apiInfo(new ApiInfo("Product Service Api Documentation", "Documentation automatically generated", model.getParent().getVersion(), null, new Contact("KKD PROJECT", null, "kkdsapient@gmail.com"), null, null));
		
		//return new Docket(DocumentationType.SWAGGER_2);
	}

}
