package com.springbootshoppingcart.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Utility {
@Bean
public static BCryptPasswordEncoder passEncoder() {
	return new BCryptPasswordEncoder();
}
}
