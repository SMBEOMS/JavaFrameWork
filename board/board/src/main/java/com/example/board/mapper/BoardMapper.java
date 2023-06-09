package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> getList();
	public void insert(BoardVO board);
}
