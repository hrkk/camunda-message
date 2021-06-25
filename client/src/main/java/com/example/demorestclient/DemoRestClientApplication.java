package com.example.demorestclient;

import com.example.demorestclient.entity.Customer;
import com.example.demorestclient.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class DemoRestClientApplication {
	private static String state = "NORMAL";

	public static void main(String[] args) {
		SpringApplication.run(DemoRestClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}

	@GetMapping("/hello")
	public ResponseEntity<String> hello() throws InterruptedException {
		log.debug("hello service invoked");
		if ("ERROR".equals(state)) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error 500");
		}
		if("LONG_RUN".equals(state)) {
			Thread.sleep(25000);
		} else {
			Thread.sleep(2000);
		}
		return ResponseEntity.ok("hello, state=" + state);
	}

	@GetMapping("/long-run-15sec")
	public ResponseEntity<String> longRun() {
		state = "LONG_RUN";
		return ResponseEntity.ok("state=" + state);
	}


	@GetMapping("/normal")
	public ResponseEntity<String> normal() {
		state = "NORMAL";
		return ResponseEntity.ok("state=" + state);
	}

	@GetMapping("/error-500")
	public ResponseEntity<String> error() {
		state = "ERROR";
		return ResponseEntity.ok("state=" + state);
	}

}
