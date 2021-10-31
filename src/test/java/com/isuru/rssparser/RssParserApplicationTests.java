package com.isuru.rssparser;

import com.isuru.rssparser.service.IRSSFeedService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RssParserApplicationTests {

	@Autowired
	IRSSFeedService rssFeedService;

	@Test
	void contextLoads() {

	}

}
