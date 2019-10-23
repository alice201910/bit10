package org.zerock.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//@ToString
//@Getter
//@AllArgsConstructor
//@Data
//vo로 쓰고 싶으면 @Data, @AllArgsConstructor
//DTO는 @Data
@ToString
@Setter
public class BoardVO {
	private Long bno;
	private String title,content,writer;
	private Date regdate,updatedate;
	
	
	
//	public BoardVO(Long bno, Date regdate, Date updatedate) {
//		super();
//		this.bno = bno;
//		this.regdate = regdate;
//		this.updatedate = updatedate;
//	}
	
	
}
