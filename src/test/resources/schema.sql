CREATE SEQUENCE IF NOT EXISTS employee_seq;

CREATE TABLE IF NOT EXISTS employee (

employee_id BIGINT NOT NULL DEFAULT nextval('employee_seq') PRIMARY KEY,
email VARCHAR(100) NOT NULL,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS customer_seq;

CREATE TABLE IF NOT EXISTS customer (

customer_id BIGINT NOT NULL DEFAULT nextval('customer_seq') PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
phone_number VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
hair_color VARCHAR(100) NOT NULL

);


CREATE TABLE IF NOT EXISTS customer_employee (

customer_id BIGINT REFERENCES customer,
employee_id BIGINT REFERENCES employee

);