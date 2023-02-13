package com.fse0.microservice.processpension;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProcessPensionApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}

	@Test
	public void applicationStarts() {
		ProcessPensionApplication.main(new String[] {});
	}
//
//	@Test
//	public void checkTest() throws Exception {
//		check c = new check();
//		c.retrievePensionersDetail();
//	}
}
