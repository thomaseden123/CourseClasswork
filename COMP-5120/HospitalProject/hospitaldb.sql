-- made schema called 'hospital'

CREATE TABLE `patient` (
    `patientid` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `DOB` DATE NOT NULL,
    `emergencycontact` VARCHAR(45),
    `insurance` VARCHAR(45)
);

CREATE TABLE `employee` (
    `employeeid` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `role` ENUM('doctor', 'nurse', 'technician', 'admin') NOT NULL
);

CREATE TABLE `room` (
    `roomnum` INT PRIMARY KEY CHECK (`roomnum` BETWEEN 1 AND 20),
    `occupied` BOOLEAN DEFAULT FALSE
);

CREATE TABLE `diagnosis` (
	`diagnosisid` INT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL
);   

CREATE TABLE `admission` (
    `admissionid` INT PRIMARY KEY AUTO_INCREMENT,
    `patientid` INT NOT NULL,
    `roomnum` INT NOT NULL,
    `admissiondate` DATE NOT NULL,
    `doctorid` INT NOT NULL,
    `diagnosisid` INT,
    FOREIGN KEY (`patientid`) REFERENCES `patient`(`patientid`),
    FOREIGN KEY (`roomnum`) REFERENCES `room`(`roomnum`),
    FOREIGN KEY (`diagnosisid`) REFERENCES `diagnosis`(`diagnosisid`),
    FOREIGN KEY (`doctorid`) REFERENCES `employee`(`employeeid`)
);

CREATE TABLE `discharge` (
    `admissionid` INT PRIMARY KEY,
    `dischargedate` DATE NOT NULL,
    `summary` TEXT,
    FOREIGN KEY (`admissionid`) REFERENCES `admission`(`admissionid`)
);

CREATE TABLE `primarydoctor` (
	`admissionid` INT PRIMARY KEY NOT NULL,
    `employeeid` INT NOT NULL,
    `patientid` INT NOT NULL,
    `isprimary` BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (`admissionid`) REFERENCES `admission`(`admissionid`),
    FOREIGN KEY (`employeeid`) REFERENCES `employee`(`employeeid`),
    FOREIGN KEY (`patientid`) REFERENCES `patient`(`patientid`) ON DELETE CASCADE
);

CREATE TABLE `treatment` (
    `treatmentid` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `type` ENUM('medication', 'procedure') NOT NULL
);

CREATE TABLE `treatment_order` (
    `orderid` INT PRIMARY KEY AUTO_INCREMENT,
    `admissionid` INT NOT NULL,
    `patientid` INT NOT NULL,
    `treatmentid` INT NOT NULL,
    `employeeid` INT NOT NULL, -- primary doctor
    `timestamp` DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`admissionid`) REFERENCES `admission`(`admissionid`),
    FOREIGN KEY (`patientid`) REFERENCES `patient`(`patientid`) ON DELETE CASCADE,
    FOREIGN KEY (`treatmentid`) REFERENCES `treatment`(`treatmentid`),
    FOREIGN KEY (`employeeid`) REFERENCES `employee`(`employeeid`)
);

CREATE TABLE `treatment_administration` (
    `adminid` INT PRIMARY KEY AUTO_INCREMENT,
    `orderid` INT NOT NULL,
    `timestamp` DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`orderid`) REFERENCES `treatment_order`(`orderid`)
);

CREATE TABLE `treatment_employee` (
    `adminid` INT NOT NULL,
    `employeeid` INT NOT NULL,
    PRIMARY KEY (`adminid`, `employeeid`),
    FOREIGN KEY (`adminid`) REFERENCES `treatment_administration`(`adminid`),
    FOREIGN KEY (`employeeid`) REFERENCES `employee`(`employeeid`)
);

-- SET FOREIGN_KEY_CHECKS = 0; 
-- DROP TABLE `primarydoctor`; 
-- SET FOREIGN_KEY_CHECKS = 1;