package com.dcalabresi.iamtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IamTestApplication.class)
@WebAppConfiguration
public class WebIntegrationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void loadImageTest() {
		System.out.println("Hola mundo!!!!");
	}

}
