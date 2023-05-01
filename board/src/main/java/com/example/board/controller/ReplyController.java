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
		//Header에 담겨오면 @RequestBody
		log.info("create...... : " + replyVO);
		return replyService.register(replyVO) ? new ResponseEntity<>("success", HttpStatus.OK) : //성공했을때 (register가 boolean임)
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //실패했을때
	}
// 게시글 댓글 전체 조회(bno번호로 조회)
	@GetMapping(value="/{bno}",produces = {MediaType.APPLICATION_PROBLEM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno, @PathVariable int page) {	
		//URL에 담겨오면 @PathVariable  //XML로 하거나 JSON으로 받거나 두개다 설정함 (데이터가옴)
		log.info("getList.....: " + bno);
		return new ResponseEntity<>(replyService.findAllByBNO(bno), HttpStatus.OK);
	}
// 댓글 1개 조회(rno번호로 조회)
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ReplyVO getReply(@PathVariable("rno") Long rno) {
		log.info("getReply........ : " + rno);
		return replyService.findByRNO(rno);
		//ResponseEntity 대신 바로 ReplyVO를 사용함
	}
// 댓글 삭제
	@DeleteMapping(value = "/{rno}", produces = MediaType.TEXT_PLAIN_VALUE) //댓글삭제할때는 GET,POST가능, 근데 메소드방식을 DELETE로 사용해도됌(가독성)
	public String remove(@PathVariable Long rno) {
		log.info("remove.......: " + rno);
		return replyService.remove(rno) ? "success" : "fail";
	}
//	댓글 수정 >>POSTMAPPING 제일 많이쓰긴함
//	PUT : 자원의 전체 수정, 자원 내 모든 필드를 전달해야 함 (ABC다 수정)
//	PATCH : 자원의 일부 수정, 수정할 필드만 전송(ABC 중에 수정안하는것만 default 설정)
	@PutMapping(value = "/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@PathVariable Long rno, @RequestBody ReplyVO replyVO) {
		replyVO.setRno(rno);
		return replyService.modify(replyVO) ? "success" : "fail";
	}
}






















