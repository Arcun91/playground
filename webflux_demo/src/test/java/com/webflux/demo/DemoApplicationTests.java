package com.webflux.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=4.4.1")
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
