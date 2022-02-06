package server.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.model.Employee;

public interface EmployeeService {
  void createEmp(Employee employee);
  Mono<Employee> findByEmpId(Integer id);
  public Flux<Employee> findAllEmp();
  Mono<Employee> updateEmp(Employee employee);
  Mono<Void> deleteEmp(Integer id);
}
