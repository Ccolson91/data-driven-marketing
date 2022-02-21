-- INSERT EMPLOYEES
insert into employee (employee_id, first_name, last_name, email) values (nextVal('employee_seq'), 'Nicole', 'Millet', 'nicolemillet@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextVal('employee_seq'), 'Jenn', 'Boutwell', 'jennboutwell@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextVal('employee_seq'), 'Steve', 'Reeves', 'ask_reeves@gmail.com');
insert into employee (employee_id, first_name, last_name, email) values (nextVal('employee_seq'), 'Ronda', 'White', 'ronda_white@gmail.com');


-- INSERT PROJECTS
insert into customer (customer_id, first_name, last_name, phone_number, email, hair_color) values (nextVal('customer_seq'), 'Sara', 'Kennedy', '1111111111', 'sara_k@gmail.com', 'blonde');
insert into customer (customer_id, first_name, last_name, phone_number, email, hair_color) values (nextVal('customer_seq'), 'Tabitha', 'Wilde', '2222222222', 'wilde_thang@gmail.com', 'brown');
insert into customer (customer_id, first_name, last_name, phone_number, email, hair_color) values (nextVal('customer_seq'), 'Karen', 'williams', '3333333333', 'K_williams@gmail.com', 'dark');
insert into customer (customer_id, first_name, last_name, phone_number, email, hair_color) values (nextVal('customer_seq'), 'Carly', 'Farely', '4444444444', 'msCarly@gmail.com', 'blonde');
insert into customer (customer_id, first_name, last_name, phone_number, email, hair_color) values (nextVal('customer_seq'), 'Francis', 'Jones', '5555555555', 'francis_jones@gmail.com', 'blonde');
insert into customer (customer_id, first_name, last_name, phone_number, email, hair_color) values (nextVal('customer_seq'), 'Deborah', 'James', '6666666666', 'd_james@gmail.com', 'brown');
insert into customer (customer_id, first_name, last_name, phone_number, email, hair_color) values (nextVal('customer_seq'), 'Jackie', 'Yanis', '7777777777', 'j_yanis@gmail.com', 'blonde');


-- INSERT PROJECT_EMPLOYEE_RELATION (Removed duplicates from video)
insert into customer_employee (employee_id, customer_id) (select e.employee_id, c.customer_id from employee e, customer c where e.last_name ='Millet' AND c.first_name = 'Sara');
insert into customer_employee (employee_id, customer_id) (select e.employee_id, c.customer_id from employee e, customer c where e.last_name ='Boutwell' AND c.first_name = 'Tabitha');
insert into customer_employee (employee_id, customer_id) (select e.employee_id, c.customer_id from employee e, customer c where e.last_name ='Reeves' AND c.first_name = 'Karen');
insert into customer_employee (employee_id, customer_id) (select e.employee_id, c.customer_id from employee e, customer c where e.last_name ='Reeves' AND c.first_name = 'Carly');
insert into customer_employee (employee_id, customer_id) (select e.employee_id, c.customer_id from employee e, customer c where e.last_name ='White' AND c.first_name = 'Francis');
insert into customer_employee (employee_id, customer_id) (select e.employee_id, c.customer_id from employee e, customer c where e.last_name ='Millet' AND c.first_name = 'Deborah');
insert into customer_employee (employee_id, customer_id) (select e.employee_id, c.customer_id from employee e, customer c where e.last_name ='Millet' AND c.first_name = 'Jackie');