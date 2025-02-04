package com.sbouhaddi.expensetracker.api.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbouhaddi.expensetracker.api.model.Transaction;
import com.sbouhaddi.expensetracker.api.repositories.TransactionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionsController {

	private final TransactionRepository repository;

	@GetMapping("/getAll")
	public ResponseEntity<List<Transaction>> getAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	@PostMapping("/transaction")
	public ResponseEntity<Transaction> createNewTodo(@RequestBody Transaction todo) {
		Transaction savedTransaction = repository.save(todo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(savedTransaction.getId()).toUri();
		return ResponseEntity.created(location).body(savedTransaction);

	}

	@DeleteMapping("/transaction/{transaction_id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long transaction_id) {
		Transaction transaction = repository.findById(transaction_id).get();
		if (transaction != null) {
			repository.delete(transaction);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}

}
