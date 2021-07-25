package com.bugapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Bug {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String bname;
	
	private String bpath;
	
	private String bbuildnumber;
	
	private String bseverity;
	
	private String bpriority;
	
	private String bassignto;
	
	private String breportedby;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date breportedon;
	
	private String reason;
	
	private String status;
	
	private String environment;
	
	private String description;
	
	private String stepstoreproduce;
	
	private String remarks;
		
}
