package com.example.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class) //단위테스트 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	//DI = 의존성 주입 확인
	@Autowired
	ReplyMapper replyMapper;
	@Test
	public void mapperTest() {
		log.info("==========================================================");
		log.info(replyMapper);
		log.info("==========================================================");
		
	}

}
