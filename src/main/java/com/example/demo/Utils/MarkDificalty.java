package com.example.demo.Utils;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkDificalty {
	private Integer easy;
	private Integer medium;
	private Integer hard;
}
