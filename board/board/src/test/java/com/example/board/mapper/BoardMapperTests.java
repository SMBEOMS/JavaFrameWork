package com.example.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Autowired
	private BoardMapper boardMapper;
	
//	@Test
//	public void getListTest() {
//		boardMapper.getList().forEach(log::info);
//	}
	
	@Test
	public void insertTest() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성한 글 제목3");
		board.setContent("새로 작성한 글 내용3");
		board.setWriter("user03");
		
		boardMapper.insert(board);
		
		log.info(board);
	}
}












