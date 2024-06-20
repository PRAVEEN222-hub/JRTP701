package com.nt.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class CarInsurancePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer cid;
	private String carName;
	private String engModel;
   private  String activeSw;
   @CreationTimestamp
   private LocalDate createdDate;
   @UpdateTimestamp
   private LocalDate mngftureDate;
   
}
