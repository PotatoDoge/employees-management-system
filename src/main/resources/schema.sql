DROP TABLE IF EXISTS roles;
create table roles(
    id int not null AUTO_INCREMENT,
    name varchar(100) not null,
    description varchar(100),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS employees;
create table employees(
  id int not null AUTO_INCREMENT,
  first_name varchar(100) not null,
  last_name varchar(100) not null,
  role int not null,
  PRIMARY KEY (id),
  FOREIGN KEY(role) REFERENCES roles(id) ON DELETE CASCADE ON UPDATE CASCADE
);
