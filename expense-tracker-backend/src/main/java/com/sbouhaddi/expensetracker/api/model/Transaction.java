package com.sbouhaddi.expensetracker.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text;
	private double amount;

}
