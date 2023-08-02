package com.example.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// @Data   // lombok에서 지원해주는 어노테이션으로, getter, setter, toString이 자동으로 만들어진다. Getter만 만들고 싶으면 @Getter라고 적어주면 된다.
@Alias("User")         // mybatis 어노테이션
@Getter
@Setter
@ToString
@NoArgsConstructor     // 매개변수가 없는 생성자
public class User {

	private String id;
	@JsonIgnore
	private String password;
	private String name;
	private String email;
	private String tel;
	@JsonIgnore
	private String photo;
	private String deleted;
	@JsonFormat(pattern = "yyyy.M.d.")
	private Date createdDate;
	@JsonFormat(pattern = "yyyy.M.d.")
	private Date updatedDate;
}
