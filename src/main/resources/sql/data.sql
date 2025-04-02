-- Insert test data into the client table
INSERT INTO client (client_id, name, email, phone)
VALUES
  (1, 'Acme Corporation', 'contact@acme.com', '+49 30 123456'),
  (2, 'Globex Inc.', 'info@globex.com', '+49 30 654321'),
  (3, 'Soylent Corp.', 'support@soylent.com', '+49 30 987654'),
  (4, 'Initech', 'hello@initech.com', '+49 30 456789'),
  (5, 'Umbrella Corp.', 'contact@umbrella.com', '+49 30 321654');

-- Insert test data into the department table
INSERT INTO department (department_id, name, location)
VALUES
  (1, 'Human Resources', 'Berlin'),
  (2, 'Engineering', 'Munich'),
  (3, 'Sales', 'Hamburg'),
  (4, 'Marketing', 'Frankfurt'),
  (5, 'Finance', 'Stuttgart');

-- Insert test data into the employee table
INSERT INTO employee (employee_id, first_name, last_name, email, phone, hire_date, salary, department_id)
VALUES
  (1, 'John', 'Doe', 'john.doe@example.com', '+49 30 111111', '2024-01-15', 60000, 2),
  (2, 'Jane', 'Smith', 'jane.smith@example.com', '+49 30 222222', '2023-03-22', 65000, 3),
  (3, 'Emily', 'Johnson', 'emily.johnson@example.com', '+49 30 333333', '2022-07-11', 70000, 1),
  (4, 'Michael', 'Brown', 'michael.brown@example.com', '+49 30 444444', '2021-11-30', 75000, 4),
  (5, 'Chris', 'Davis', 'chris.davis@example.com', '+49 30 555555', '2020-05-19', 80000, 5),
  (6, 'Pat', 'Wilson', 'pat.wilson@example.com', '+49 30 666666', '2019-09-25', 85000, 2),
  (7, 'Alex', 'Taylor', 'alex.taylor@example.com', '+49 30 777777', '2018-02-14', 90000, 3),
  (8, 'Jordan', 'Anderson', 'jordan.anderson@example.com', '+49 30 888888', '2017-06-08', 95000, 1),
  (9, 'Morgan', 'Thomas', 'morgan.thomas@example.com', '+49 30 999999', '2016-12-21', 100000, 4),
  (10, 'Casey', 'Moore', 'casey.moore@example.com', '+49 30 000000', '2015-08-03', 105000, 5);

-- Insert test data into the contract table
INSERT INTO contract (contract_id, client_id, employee_id, start_date, end_date, value)
VALUES
  (1, 1, 1, '2024-02-01', '2025-01-31', 120000),
  (2, 2, 2, '2023-04-01', '2024-03-31', 130000),
  (3, 3, 3, '2022-08-01', '2023-07-31', 140000),
  (4, 4, 4, '2021-12-01', '2022-11-30', 150000),
  (5, 5, 5, '2020-06-01', '2021-05-31', 160000),
  (6, 1, 6, '2019-10-01', '2020-09-30', 170000),
  (7, 2, 7, '2018-03-01', '2019-02-28', 180000),
  (8, 3, 8, '2017-07-01', '2018-06-30', 190000),
  (9, 4, 9, '2016-01-01', '2016-12-31', 200000),
  (10, 5, 10, '2015-09-01', '2016-08-31', 210000);
