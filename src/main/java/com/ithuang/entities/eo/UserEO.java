package com.ithuang.entities.eo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "tb_user")
@Entity
public class UserEO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String userName;

	private String passWord;

	private String tel;

	private String addr;

	private String eMail;
}
