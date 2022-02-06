package server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import server.dao.EmployeeRepository;
import server.model.Employee;
import server.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeRepository employeeRepo;

  public void createEmp(Employee employee) {
    employeeRepo.save(employee).subscribe();
  }

  public Mono<Employee> findByEmpId(Integer id) {
    return employeeRepo.findById(id);
  }

  public Flux<Employee> findAllEmp() {
    return employeeRepo.findAll();
  }

  public Mono<Employee> updateEmp(Employee employee) {
    return employeeRepo.save(employee);
  }

  public Mono<Void> deleteEmp(Integer id) {
    return employeeRepo.deleteById(id);
  }

}
