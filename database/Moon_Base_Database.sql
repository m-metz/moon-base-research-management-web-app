DROP DATABASE IF EXISTS MOON_BASE_RMS;
CREATE DATABASE MOON_BASE_RMS; 
USE MOON_BASE_RMS;

CREATE USER IF NOT EXISTS 'javauser' IDENTIFIED BY 'Java@Pass';
GRANT ALL PRIVILEGES ON *.* TO 'javauser';

DROP TABLE IF EXISTS ROCKET;
CREATE TABLE ROCKET (
	rocket_id				integer	not null auto_increment,
	name					varchar(30)	not null,
	primary key (rocket_id)
);

INSERT INTO ROCKET (name)
VALUES
('Saturn V'),
('N1'),
('Falcon 9'),
('Saturn I'),
('Artemis 1');

DROP TABLE IF EXISTS TRANSPORT;
CREATE TABLE TRANSPORT (
	transport_id			integer	not null auto_increment,
	rocket_id				integer	not null,
    arrival_departure		varchar(30) not null,
	time					DateTime,
    from_to					varchar(30)	not null,
    primary key (transport_id),
	foreign key (rocket_id) references ROCKET(rocket_id)
);

INSERT INTO TRANSPORT (rocket_id, arrival_departure, time, from_to)
VALUES
('5','depart','2022-11-16 06:47:44','Earth'),
('5','arrive','2022-11-25 12:00:00', 'Earth');



DROP TABLE IF EXISTS PERSONNEL;
CREATE TABLE PERSONNEL (
	personnel_id			integer auto_increment,
    name					varchar(30)	not null,
    country					varchar(30)	not null,

    primary key (personnel_id)
);

INSERT INTO PERSONNEL (personnel_id, name, country)
VALUES
('1','Alex','South Africa'),
('2','Mike','Canada'),
('3','Felipe','Brazil'),
('4', 'Maan','Egypt');

DROP TABLE IF EXISTS BASE;
CREATE TABLE BASE (
	base_id					integer	not null auto_increment,
	name					varchar(30)	not null,
    location				varchar(30)	not null,

    primary key (base_id)
);

INSERT INTO BASE (name, location)
VALUES
('Moon Base Alpha','Little West Crater');

DROP TABLE IF EXISTS GROUND_STATION;
CREATE TABLE GROUND_STATION (
    name				varchar(30)	not null,
    country						varchar(30)	not null,

    primary key (name)
);

INSERT INTO GROUND_STATION (name, country)
VALUES
('Houston','America');


DROP TABLE IF EXISTS MOON_RESEARCHER;
CREATE TABLE MOON_RESEARCHER (
	personnel_id			integer,
    job_title 				varchar(30)	not null,
    base_id					integer not null,

    primary key (personnel_id),
	foreign key (base_id) references BASE(base_id),
    foreign key (personnel_id) references PERSONNEL(personnel_id)
);
INSERT INTO MOON_RESEARCHER (personnel_id, job_title, base_id)
VALUES
('1','Mechanical Engineer', '1'),
('2','Electircal Engineer', '1'),
('3','Industrial Engineer', '1');

DROP TABLE IF EXISTS TRAVELS_BY;
CREATE TABLE TRAVELS_BY (
	transport_id			integer,
	personnel_id			integer,

    primary key (transport_id,personnel_id),
	foreign key (transport_id) references TRANSPORT(transport_id),
    foreign key (personnel_id) references MOON_RESEARCHER(personnel_id)
);

INSERT INTO TRAVELS_BY (transport_id, personnel_id)
VALUES
('1','1'),
('1','2'),
('1','3'),
('2','1'),
('2','2'),
('2','3');

DROP TABLE IF EXISTS MOON_MANAGER;
CREATE TABLE MOON_MANAGER (
	personnel_id					integer,

    primary key (personnel_id),
    foreign key(personnel_id) references MOON_RESEARCHER(personnel_id)
);

INSERT INTO MOON_MANAGER (personnel_id)
VALUES
('1');


DROP TABLE IF EXISTS BUILDING;
CREATE TABLE BUILDING (
	building_id						integer	not null auto_increment,
    name					varchar(30) not null,
    base_id							integer,

    primary key (building_id),
    foreign key(base_id) references BASE(base_id)
);

INSERT INTO BUILDING (name, base_id)
VALUES
('HQ','1'),
('Green House','1'),
('Sleeping Quarters','1'),
('Buggy Garage','1');

DROP TABLE IF EXISTS RESEARCH_EQUIPMENT;
CREATE TABLE RESEARCH_EQUIPMENT (
	equip_id					integer	not null auto_increment,
    name					varchar(30) not null,
    in_use						boolean,
    base_id						integer	not null,

    primary key (equip_id),
    foreign key(base_id) references BASE(base_id)
);
INSERT INTO RESEARCH_EQUIPMENT (name, in_use, base_id)
VALUES
('Buggy',false,'1'),
('Ladder',true,'1'),
('Scanner',false,'1');


DROP TABLE IF EXISTS EARTH_MANAGER;
CREATE TABLE EARTH_MANAGER (
	personnel_id					integer,
    station_name					varchar(30) not null,

    primary key (personnel_id),
    foreign key(personnel_id) references PERSONNEL(personnel_id),
    foreign key(station_name) references GROUND_STATION(name)
);

INSERT INTO EARTH_MANAGER (personnel_id, station_name)
VALUES
('4','Houston');


DROP TABLE IF EXISTS PROJECT;
CREATE TABLE PROJECT (
	project_id					integer	not null auto_increment,
    name						varchar(30) not null,
    m_manager_id				integer,
    e_manager_id				integer,
    building_id					integer	not null,

    primary key (project_id),
    foreign key(m_manager_id) references MOON_MANAGER(personnel_id),
    foreign key(e_manager_id) references EARTH_MANAGER(personnel_id),
    foreign key(building_id) references BUILDING(building_id)
);

INSERT INTO PROJECT (name,m_manager_id, e_manager_id, building_id)
VALUES
('Plants in low gravity', 1, 4, 2),
('Moon Rock Scouting', 1, 4, 4);


DROP TABLE IF EXISTS WORKS_ON;
CREATE TABLE WORKS_ON (
	personnel_id					integer not null,
    project_id						integer	not null,

    primary key (personnel_id, project_id),
    foreign key(personnel_id) references PERSONNEL(personnel_id),
    foreign key(project_id) references PROJECT(project_id)
);

INSERT INTO WORKS_ON (personnel_id, project_id)
VALUES
('1','1'),
('2','1'),
('3','1'),
('1','2'),
('2','2'),
('3','2');

DROP TABLE IF EXISTS RESEARCH_TASK;
CREATE TABLE RESEARCH_TASK(
	task_id					integer	not null auto_increment,
    title				    varchar(30),
    notes 					varchar(100),
    status		            boolean,
    project_id				integer	not null,

    primary key (task_id),
    foreign key(project_id) references PROJECT(project_id)
);

INSERT INTO RESEARCH_TASK (title, notes, status, project_id)
VALUES
('Water Plants','Watered well', true, '1'),
('Plant Potatoes','Some potatoes were rotten on arrival', true, '1'),
('Sow new bed',Null, false, '1'),
('Quick Scout','All data ligned up with radar', true, '2'),
('Change Tires',Null, false, '2');





