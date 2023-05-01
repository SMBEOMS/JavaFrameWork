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
 	
 	return {add: add}	// {KEY값: VALUE값}
 })();
 
 
 
 