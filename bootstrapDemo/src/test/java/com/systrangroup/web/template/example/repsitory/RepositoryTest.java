package com.systrangroup.web.template.example.repsitory;


/*
 * test for controller
 * spock : http://d2.naver.com/helloworld/568425
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
 * see http://www.javacodegeeks.com/2015/03/spring-boot-integration-testing-with-selenium.html
 */
import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bootstrap.DemoBootApplication;
import com.demo.bootstrap.domain.UserInfo;
import com.demo.bootstrap.repository.UserInfoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = { "spring.jpa.generate-ddl:false" })
@ActiveProfiles("local")
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
public class RepositoryTest {
	@Autowired
	UserInfoRepository userRepository;

	@Before(value = "")
	public void setUp(){
		System.out.println("initizing...");
	}
	
	@Test
	@Transactional // mandatory annotation for a repository test
	public void testController() {
		try {
			UserInfo user = userRepository.findOne(new String(""));
			System.out.println(user);
			Assert.assertNotNull("not null", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
