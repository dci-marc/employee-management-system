package org.dcistudent.employeemanagementsystem.services;

import jakarta.persistence.EntityManager;
import org.dcistudent.employeemanagementsystem.entities.Client;
import org.dcistudent.employeemanagementsystem.entities.Contract;
import org.dcistudent.employeemanagementsystem.entities.Department;
import org.dcistudent.employeemanagementsystem.entities.Employee;
import org.dcistudent.employeemanagementsystem.repositories.ClientRepository;
import org.dcistudent.employeemanagementsystem.repositories.ContractRepository;
import org.dcistudent.employeemanagementsystem.repositories.DepartmentRepository;
import org.dcistudent.employeemanagementsystem.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class WorkflowService {

  private final EntityManager entityManager;
  private final ClientRepository clientRepository;
  private final ContractRepository contractRepository;
  private final DepartmentRepository departmentRepository;
  private final EmployeeRepository employeeRepository;

  public WorkflowService(
      EntityManager entityManager,
      ClientRepository clientRepository,
      ContractRepository contractRepository,
      DepartmentRepository departmentRepository,
      EmployeeRepository employeeRepository
  ) {
    this.entityManager = entityManager;
    this.clientRepository = clientRepository;
    this.contractRepository = contractRepository;
    this.departmentRepository = departmentRepository;
    this.employeeRepository = employeeRepository;
  }

  public void create() {
    this.createDepartments();
    this.createEmployees();
    this.createClients();
    this.createContracts();
  }

  @Transactional
  protected void createDepartments() {
    // Entity graph navigation
    Department hr = new Department();
    hr.setName("Human Resources");
    hr.setLocation("Berlin");
    this.departmentRepository.save(hr);

    Department engineering = new Department();
    engineering.setName("Engineering");
    engineering.setLocation("Munich");
    this.departmentRepository.save(engineering);

    // DQL
    this.departmentRepository.create("Sales", "Hamburg");

    // Native SQL
    this.entityManager.createNativeQuery(
        "INSERT INTO department (name, location) " +
            "VALUES " +
            "('Marketing', 'Frankfurt'), " +
            "('Finance', 'Stuttgart')"
    );
  }

  @Transactional
  protected void createEmployees() {
    Employee johnDoe = new Employee();
    johnDoe.setFirstName("John");
    johnDoe.setLastName("Doe");
    johnDoe.setEmail("john.doe@example.com");
    johnDoe.setPhone("+49 30 111111");
    johnDoe.setHireDate(LocalDate.of(2024, 1, 15));
    johnDoe.setSalary(BigDecimal.valueOf(60000));
    johnDoe.setDepartment(this.departmentRepository.findById(2L).orElseThrow());
    this.employeeRepository.save(johnDoe);

    this.employeeRepository.create(
        "Jane",
        "Smith",
        "jane.smith@example.com",
        "+49 30 222222",
        LocalDate.of(2023, 3, 22),
        BigDecimal.valueOf(65000),
        this.departmentRepository.findById(3L).orElseThrow()
    );

    this.entityManager.createNativeQuery(
        "INSERT INTO employee (first_name, last_name, email, phone, date_hire, salary, department_id) " +
            "VALUES " +
            "('Emily', 'Johnson', 'emily.johnson@example.com', '+49 30 333333', '2022-07-11', 70000, 1), " +
            "('Michael', 'Brown', 'michael.brown@example.com', '+49 30 444444', '2021-11-30', 75000, 4), " +
            "('Chris', 'Davis', 'chris.davis@example.com', '+49 30 555555', '2020-05-19', 80000, 5), " +
            "('Pat', 'Wilson', 'pat.wilson@example.com', '+49 30 666666', '2019-09-25', 85000, 2), " +
            "('Alex', 'Taylor', 'alex.taylor@example.com', '+49 30 777777', '2018-02-14', 90000, 3), " +
            "('Jordan', 'Anderson', 'jordan.anderson@example.com', '+49 30 888888', '2017-06-08', 95000, 1), " +
            "('Morgan', 'Thomas', 'morgan.thomas@example.com', '+49 30 999999', '2016-12-21', 100000, 4), " +
            "('Casey', 'Moore', 'casey.moore@example.com', '+49 30 000000', '2015-08-03', 105000, 5) "
    );
  }

  @Transactional
  protected void createClients() {
    Client acme = new Client();
    acme.setName("Acme Corporation");
    acme.setIndustry("Manufacturing");
    acme.setEmail("contact@acme.com");
    acme.setPhone("+49 30 123456");
    this.clientRepository.save(acme);

    this.clientRepository.create(
        "Globex Inc.",
        "Technology",
        "info@globex.com",
        "+49 30 654321"
    );

    this.entityManager.createNativeQuery(
        "INSERT INTO client (name, industry, email, phone) " +
            "VALUES " +
            "('Soylent Corp.', 'Foo', 'support@soylent.com', '+49 30 987654'), " +
            "('Initech', 'Bar', 'hello@initech.com', '+49 30 456789'), " +
            "('Umbrella Corp.', 'Baz', 'contact@umbrella.com', '+49 30 321654')"
    );
  }

  @Transactional
  protected void createContracts() {
    Contract contract = new Contract();
    contract.setName("Standard");
    contract.setDateStart(LocalDate.of(2024, 2, 1));
    contract.setDateEnd(LocalDate.of(2025, 1, 31));
    contract.setEmployee(this.employeeRepository.findById(1L).orElseThrow());
    contract.setClient(this.clientRepository.findById(1L).orElseThrow());
    this.contractRepository.save(contract);

    this.contractRepository.create(
        "Standard",
        LocalDate.of(2023, 4, 1),
        LocalDate.of(2024, 3, 31),
        this.employeeRepository.findById(2L).orElseThrow(),
        this.clientRepository.findById(2L).orElseThrow()
    );

    this.entityManager.createNativeQuery(
        "INSERT INTO contract (name, date_start, date_end, employee_id, client_id) " +
            "VALUES " +
            "('Standard', '2022-08-01', '2023-07-31', 3, 3), " +
            "('Standard', '2021-12-01', '2022-11-30', 4, 4), " +
            "('Standard', '2020-06-01', '2021-05-31', 5, 5), " +
            "('Freelance', '2019-10-01', '2020-09-30', 6, 1), " +
            "('Freelance', '2018-03-01', '2019-02-28', 7, 2), " +
            "('Freelance', '2017-07-01', '2018-06-30', 8, 3), " +
            "('Freelance', '2016-01-01', '2016-12-31', 9, 4), " +
            "('Freelance', '2015-09-01', '2016-08-31', 10, 5)"
    );
  }
}
