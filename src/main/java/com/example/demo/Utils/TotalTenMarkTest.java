package com.example.demo.Utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("totaltenmark")
public class TotalTenMarkTest  {

	private MarkDificalty onemarkques;
	private MarkDificalty Twomarkques;
	private MarkDificalty Fivemarkques;
	private MarkDificalty Tenmarkques;
}
