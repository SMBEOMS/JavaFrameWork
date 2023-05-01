package com.example.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
@Log4j
public class ReplyController {
	
	private final ReplyService replyService;
	
//	댓글 등록
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE}) //consumes == 외부에서 전달 파라미터받을 타입을 쓴것
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) { //json이랑 Reply가 같아야함 , produces = 결과값을 리턴할때 값을 적어주는것(브라우저에서는
		//글을 String 말고 TEXT_PLAIN_VALUE로 받음 //ResponseEntity = 응답할때 여러가지 요소들을 사용하는것,서버의상태를 알려주는것
		//나는 success를 주기위해서 <String>을 사용함, 숫자를 사용하려면 <int>
		log.info("create...... : " + replyVO);
		return replyService.register(replyVO) ? new ResponseEntity<>("success", HttpStatus.OK) : //성공했을때 (register가 boolean임)
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //실패했을때
	}
	
}






















