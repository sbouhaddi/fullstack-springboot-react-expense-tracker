package com.sbouhaddi.expensetracker.api.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sbouhaddi.expensetracker.api.model.Transaction;
import com.sbouhaddi.expensetracker.api.repositories.TransactionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {

	private final TransactionRepository repository;

	@Override
	public void run(String... args) throws Exception {
		if (repository.count() < 1) {

			Transaction transaction = Transaction.builder().text("Flower").amount(-20).build();
			repository.save(transaction);
			Transaction transaction1 = Transaction.builder().text("Salary").amount(300).build();
			repository.save(transaction1);
			Transaction transaction2 = Transaction.builder().text("Book").amount(-10).build();
			repository.save(transaction2);
			Transaction transaction3 = Transaction.builder().text("Camera").amount(150).build();
			repository.save(transaction3);

		}

		log.info("saved transactions: =======> " + repository.count());

	}

}
