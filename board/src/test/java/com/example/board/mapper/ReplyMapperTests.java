package com.example.board.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class) //단위테스트
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	// 5개 배열 순서대로 > 전역변수 설정
	private Long[] arBno = {3144485L, 3144484L, 3144483L, 3144482L, 31444851L};
	
	
	//DI = 의존성 주입 확인
	@Autowired
	ReplyMapper replyMapper;
	@Test
	public void mapperTest() {
		log.info("==================================");
		log.info(replyMapper);
		log.info("==================================");
	}
		
	
//	@Test
//	public void insertTest() {
//		//5개의 게시글에 2개씩 댓글 달기
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			replyVO.setBno(arBno[i % 5]);
//			replyVO.setReply("댓글 테스트" + i);
//			replyVO.setReplier("작성자" + i);
//			
//			replyMapper.insert(replyVO);
//		});
//	}
//	@Test
//	public void selectTest() {
//		log.info(replyMapper.select(10L));
//	}
//	
//	@Test
//	public void deleteTest() {
//		log.info(replyMapper.delete(15L));
//	}
//	@Test
//	public void deleteAllTest() {
//		log.info(replyMapper.deleteAll(2072L));
//	}
	@Test
	public void updateTest() {
		ReplyVO replyVO = replyMapper.select(2L);
		if(replyVO != null) {
			replyVO.setReply("수정된 댓글 내용");
		}
		log.info("============================================");
		log.info(replyVO == null? "없는 댓글입니다.":	replyMapper.update(replyVO) + "건 수정되었습니다.");
		log.info("============================================");
	}
}
