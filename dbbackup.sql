DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS desks;
DROP TABLE IF EXISTS permessi;
DROP TABLE IF exists bookings;


create table users (
	id int PRIMARY KEY,
	nome VARCHAR(100),
	cf VARCHAR(16) unique not null,
	password VARCHAR(255),
	flag_attivo bool
);

create table roles (
	id int PRIMARY KEY,
	name VARCHAR (50) unique not null
);

create table user_role (
    user_id int,
    role_id int,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id),    
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

create table desks (
	id int primary key,
	code varchar (50) unique,
	x integer,
	y integer
);

create table permessi (
	id int primary key,
	role_id int,
	azione varchar(100),
	foreign key (role_id) references roles (id)
);

create table bookings (
	id int primary key,
	user_id int,
	desk_id int,
	booking_date date,
	foreign key (user_id) references users(id),
	foreign key (desk_id) references desks(id)
);