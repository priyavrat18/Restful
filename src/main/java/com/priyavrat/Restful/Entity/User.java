package com.priyavrat.Restful.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Data //generates all getter setter and tostring method
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Size(min=2,message="Name should have atleast 2 characters")
	private String name;
	
	@Past
	private LocalDateTime birthDate;

}
