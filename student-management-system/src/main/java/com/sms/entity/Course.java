package com.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String courseCode;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

}
