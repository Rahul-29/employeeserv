drop table if exists Employee;
drop table if exists Address;
drop table if exists Address_entity;
drop table if exists Employee_entity;
drop sequence address_sequence;
create table Address
(
    id INT not null PRIMARY KEY,
    address_line1 VARCHAR(250) NOT NULL,
    address_line2 VARCHAR(250) NULL,
    city VARCHAR(250) NOT NULL,
    state VARCHAR(250) NOT NULL,
    country VARCHAR(250) NOT NULL,
    zip_code VARCHAR(250) NOT NULL,
);

create table Employee
(
    id INT not null,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    date_of_birth VARCHAR(250) NOT NULL,
    addressid INT,
    constraint employee_pk primary key (id),
    foreign key (addressid) references Address(id)
);
CREATE SEQUENCE address_sequence
START WITH 1
INCREMENT BY 1;

