package com.priyavrat.Restful.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private Integer id;
	
	@Size(min=2,message="Name should have atleast 2 characters")
	private String name;
	
	@Past
	private Date birthDate;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User2 [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}
