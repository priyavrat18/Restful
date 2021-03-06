package com.priyavrat.Restful.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Data //generates all getter setter and tostring method
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Size(min=2,message="Name should have atleast 2 characters")
	private String name;
	
	@Past
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	private LocalDateTime birthDate;

}
