package com.systrangroup.web.template.example.controller;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
/*
 * test for controller
 * see http ://www.javacodegeeks.com/2015/03/spring-boot-integration-testing-with-selenium.html
 * see also : https://github.com/spring-projects/spring-boot/blob/master/spring-boot-samples/spring-boot-sample-data-jpa/src/test/java/sample/data/jpa/SampleDataJpaApplicationTests.java
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.bootstrap.DemoBootApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:8888")
@TestPropertySource(properties = { "spring.jpa.generate-ddl:false" })
@ActiveProfiles("local")
public class MainControllerTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	
	@Test
	public void test_save() {
		try {
			String testUrl = "/saveUser?id=jimang80@gmail.com&name=JJ";
			System.out.println(mockMvc.perform(MockMvcRequestBuilders.get(testUrl)).andReturn().getResponse().getStatus());
			mockMvc.perform(MockMvcRequestBuilders.get(testUrl)).andExpect(MockMvcResultMatchers.status().is(200));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_findListWithPagination() {
		try {
			String testUrl = "/findListWithPagination?id=jimang80@gmail&pageNumber=1&pageSize=3";
			int status = mockMvc.perform(MockMvcRequestBuilders.get(testUrl)).andReturn().getResponse().getStatus();
			Assert.assertThat("not status 200", status, is(200));
			System.out.println(mockMvc.perform(MockMvcRequestBuilders.get(testUrl)).andReturn().getResponse().getContentAsString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_findOneUserByQueryDsl() {
		try {
			String testUrl = "/findOneUserByQueryDsl?id=jimang80@gmail";
			int status = mockMvc.perform(MockMvcRequestBuilders.get(testUrl)).andReturn().getResponse().getStatus();
			Assert.assertThat("not status 200", status, is(200));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

}
