package com.example.board.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;
	private int amount;
	private String type; // null 일경우도있음 null 인아닌이유는 검색을해서
	private String keyword; // null 일경우도있음 null 인아닌이유는 검색을해서
	
	public Criteria() {
		this(1, 10);
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public Criteria(int pageNum, int amount, String type, String keyword) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.type = type; //생성자 초기화
		this.keyword = keyword; //생성자 초기화
	}
	
	public String getParams() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("") //최상의 경로
				.queryParam("pageNum", this.pageNum)
				.queryParam("type", this.type)
				.queryParam("keyword", this.keyword);
		return builder.toUriString(); // ?으로 시작 param=value 값 
	}
	// 다중항목 검색 처리 MYbytics 에서든 types으로 작성
	public String[] getTypes() {
		//"ABC".split("") --> 3칸 배열([A][B][C])
		return type == null ? new String[] {} : type.split("");
	}
}
