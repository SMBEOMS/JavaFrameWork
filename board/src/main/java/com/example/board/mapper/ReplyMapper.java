package com.example.board.mapper;

import java.util.List;

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
	//댓글 삭제하기 (return 되는게 건수)
	public int delete(Long rno);
	//댓글 다삭제하기(게시글 삭제할때 다삭제)
	public int deleteAll(Long bno);
	//수정하기 전체내용을 갖고오고 사용자가 이미 수정한 내용 갖고오기
	public int update(ReplyVO replyVO);
	//목록
	public List<ReplyVO> selectAll(Long bno); //댓글의 번호 알면됌

}
