package com.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	// XML파일에 있는것과 일치해야 접목
	// XML만들어야함 >> src/main/resource/mappers > ReplyMapper.xml 생성
	
	
	//메소드만들기
	public int insert(ReplyVO repyVO);
	//댓글 하나갖고오기
	public ReplyVO select(Long rno);

}
