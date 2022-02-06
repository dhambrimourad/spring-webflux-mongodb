package client.service.impl;

import client.model.Employee;
import client.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class EmployeeService implements IEmployeeService
{
	@Autowired
	WebClient webClient;
	
	public Flux<Employee> findAll()	{
		return webClient.get()
			.uri("/get/all")
			.retrieve()
			.bodyToFlux(Employee.class)
			.timeout(Duration.ofMillis(10_000));
	}

	public Mono<Employee> create(Employee empl)	{
		return webClient.post()
				.uri("/create/emp")
				.body(Mono.just(empl), Employee.class)
				.retrieve()
				.bodyToMono(Employee.class)
				.timeout(Duration.ofMillis(10_000));
	}

	public Mono<Employee> findById(Integer id) {
		return webClient.get()
				.uri("/get/" + id)
				.retrieve()
				.bodyToMono(Employee.class);
	}

	public Mono<Employee> update(Employee e) {
		return webClient.put()
				.uri("/update/emp/" + e.getId())
				.body(Mono.just(e), Employee.class)
				.retrieve()
				.bodyToMono(Employee.class);
	}

	public Mono<Void> delete(Integer id) {
		return webClient.delete()
				.uri("/delete/" +id)
				.retrieve()
				.bodyToMono(Void.class);
	}

}