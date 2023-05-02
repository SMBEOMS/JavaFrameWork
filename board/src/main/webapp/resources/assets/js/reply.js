/**
 *  Javascript 모듈화 모듈=부품 문제가 생겼을시 전체를 안고쳐도됌
 *  한개였던것을 여러개를 나눈다
 *  함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
 *  화면 내에서 Javascript를 처리하다 보면 이벤트 처리, DOM, Ajax 처리 등 Ajax = 통신
 *  복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript 코드를 여러 부품으로 분리하여 조립하는 형식으로 설계한다.
 */
 
 console.log("Reply Module......");
 
 
 let replyService = (function(){ //선언과 동시 사용하기위해서 '(' 
 
 // 추가하기
 	function add(reply, callback){
 		console.log("add reply.........");
 		
 		$.ajax({
 			url: "/replies/new",
 			type: "post", //type을 안쓰면 get방식
 			data: JSON.stringify(reply),  //JS VS JSON = JS:KEY값 {a:[],b:0} , JSON = {"a":0, "b":0}(KEY값에 쌍따음표있어야함)
 										  //stringify = JAVA를 JASON으로 바꿔주는것, Parse = JASON을 JAVA 오브젝트로 바꿔주는것
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	}

 	// 목록보기  (ReplyController.java에서 게시글 댓글 전체 조회 를 보고 하는거임)
 	//param은 게시글 번호와 요청한 페이지를 받아올 수 있는 객체이다.
 	function getList(param, callback, error){//객체로 받는걸로함 why? 게시글처럼 받으면 댓글이 너무많으면 스크롤을 계속하게됌
 		let bno = param.bno;
 		let page = param.page || 1; // let variable = a || b;  ---> a가 값이 없으면 b로 사용된다.
 		
 		//getJSON()은 빠르고 편하게 요청 후 JSON데이터를 받아오기 위해 사용한다.
 		//전송방식은 get방식이다.
 		//.json을 붙인 이유는 XML이 default로 설정되어 있기 때문에 JSON 형식으로 전달받기 위해 사용한다.
 		$.getJSON("/replies/" + bno + "/" + page + ".json", function(list){//ajax보다 편하게 받을수있음 get = JSON을 가져오는거아님 get방식으로 하는것
 													//확장자명이 xml,json인데 xml형태로 와서 json을 붙여야함
 			if(callback){
 				callback(list);
 			}
 		}).fail(function(xhr, status, err){
 			if(error){
 				error(err);
 			}
 		});
 	}
 	
 	
 	
 	
 	
 	return {add:add, getList:getList}	// {KEY값: VALUE값}
 })();
 
 
 
 