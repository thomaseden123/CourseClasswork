INSERT INTO `room` (`roomnum`, `occupied`) VALUES 
			(1, FALSE), (2, FALSE), (3, FALSE), (4, FALSE), (5, FALSE), (6, FALSE), 
			(7, FALSE), (8, FALSE), (9, FALSE), (10, FALSE), (11, FALSE), (12, FALSE), (13, FALSE), 
			(14, TRUE), (15, TRUE), (16, TRUE), (17, TRUE), (18, TRUE), (19, TRUE), (20, TRUE);
UPDATE room
SET occupied = TRUE
WHERE roomnum IN (7, 9, 11);            

INSERT INTO `employee` (`employeeid`, `name`, `role`) VALUES 
					(101, 'Dr. John Williams', 'doctor'),
                    (102, 'Dr. Carlos Sanchez', 'doctor'),
                    (103, 'Dr. Maria Rodriguez', 'doctor'),
					(104, 'Nurse Gloria', 'nurse'),
                    (105, 'Nurse Patricia', 'nurse'),
					(106, 'Tech Liam', 'technician'),
					(107, 'Admin Ruben', 'admin');

INSERT INTO `patient` (`patientid`, `name`, `DOB`, `emergencycontact`, `insurance`) VALUES 
					(123, 'Alexandra Robinson', '1957-07-15', 'Matthew Robinson - 333-3333', 'United Health Group'),
                    (124, 'Carrie Hernandez', '1955-12-09', 'David Hernandez - 444-4444', 'Elevance Health'),
                    (125, 'Jerry Smith', '1952-03-24', 'Natalie Smith - 555-5555', 'BlueCross');
                
INSERT INTO `diagnosis` (`diagnosisid`, `name`) VALUES 
				(800, 'autoimmune epilepsy'),
                (801, 'autoimmune epilepsy (secondary)'),
                (804, 'type 2 diabetes'),
                (806, 'alzheimers');
                
INSERT INTO `admission` (`admissionid`, `patientid`, `roomnum`, `admissiondate`, `doctorid`, `diagnosisid`) VALUES 	
				(500, 123, 2, '2025-01-07', 101, 800),
                (501, 123, 4, '2025-01-11', 101, 801),
                (502, 123, 5, '2025-01-18', 102, 801),
                (503, 123, 6, '2025-01-25', 102, 801),
                (504, 124, 7, '2025-02-01', 103, 804),
                (505, 124, 9, '2025-02-06', 103, 804),
                (506, 124, 7, '2025-02-10', 103, 804),
                (507, 125, 10, '2025-02-20', 103, 806),
                (508, 125, 11, '2025-02-26', 103, 806),
                (509, 125, 10, '2025-03-02', 103, 806),
                (510, 125, 11, '2025-03-07', 103, 806);
                
                
INSERT INTO `primarydoctor` (`admissionid`, `employeeid`, `patientid`, `isprimary`) VALUES
				(500, 101, 123, TRUE),
                (501, 101, 123, TRUE),
                (502, 102, 123, FALSE),
                (503, 102, 123, FALSE),
                (504, 103, 124, FALSE),
                (505, 103, 124, FALSE),
                (506, 103, 124, FALSE),
                (507, 103, 125, TRUE),
                (508, 103, 125, TRUE),
                (509, 103, 125, TRUE),
                (510, 103, 125, TRUE);
                
       
INSERT INTO `discharge` (`admissionid`, `dischargedate`, `summary`) VALUES
				(500, '2025-01-08', 'Patient was discharged and responded well with treatments.'),
                (501, '2025-01-12', 'Patient was discharged and responded well with treatments.'),
                (502, '2025-01-18', 'Patient was discharged and responded well with treatments.'),
                (504, '2025-02-01', 'Patient was discharged and responded well with treatments.'),
                (506, '2025-02-10', 'Patient was discharged and responded well with treatments.'),
                (510, '2025-03-07', 'Patient was discharged and responded well with treatments.');
                
                
INSERT INTO `treatment` (`treatmentid`, `name`, `type`) VALUES
				(700, 'antibiotics', 'medication'),
                (701, 'antibiotics part 2', 'medication'),
                (704, 'ozempic', 'medication'),
                (706, 'memantine', 'medication');
                
INSERT INTO `treatment_order` (`orderid`, `admissionid`, `patientid`, `treatmentid`, `employeeid`, `timestamp`) VALUES
				(10000, 500, 123, 700, 101, '2025-01-07 11:30'),
                (10001, 501, 123, 701, 101, '2025-01-11 1:45'),
                (10004, 504, 123, 701, 102, '2025-01-18 10:15'),
                (10006, 506, 124, 704, 103, '2025-02-10 1:00'),
                (10010, 510, 125, 706, 103, '2025-03-08 2:30'),
				(10020, 503, 123, 701, 102, '2025-01-25 10:00'),
				(10021, 505, 124, 704, 103, '2025-02-06 09:15'),
				(10022, 507, 125, 706, 103, '2025-02-20 14:00'),
				(10023, 508, 125, 706, 103, '2025-02-26 15:00'),
				(10024, 509, 125, 706, 103, '2025-03-02 16:00');                
                
INSERT INTO `treatment_administration` (`adminid`, `orderid`, `timestamp`) VALUES
				(1500, 10000, '2025-01-07 11:30'),
                (1501, 10001, '2025-01-11 1:45'),
                (1502, 10004, '2025-01-18 10:15'),
                (1506, 10006, '2025-02-10 1:00'),
                (1510, 10010, '2025-03-07 2:30');
                
INSERT INTO `treatment_employee` (`adminid`, `employeeid`) VALUES
				(1500, 104),
                (1501, 105),
                (1502, 105),
                (1506, 104),
                (1510, 104);
                
-- UPDATE room
-- SET occupied = FALSE
-- WHERE roomnum IN (10);                
				
-- DELETE FROM `patient`
-- WHERE `patientid` = 125;
-- SELECT * FROM `patient`; 

-- DELETE FROM `diagnosis`
-- WHERE `diagnosisid` = 801;
-- SELECT * FROM `diagnosis`;   
--  
-- DELETE FROM `admission`
-- WHERE `admissionid` = 501;
-- SELECT * FROM `admission`;

-- DELETE FROM `primarydoctor`
-- WHERE `admissionid` = 501;
-- SELECT * FROM `primarydoctor`;

-- DELETE FROM `discharge`
-- WHERE `admissionid` = 503;
-- SELECT * FROM `discharge`;

-- DELETE FROM `treatment`
-- WHERE `treatmentid` = 700;
-- SELECT * FROM `treatment`;

-- DELETE FROM `treatment_order`
-- WHERE `orderid` = 10000;
-- SELECT * FROM `treatment_order`;
--  
-- DELETE FROM `treatment_administration`
-- WHERE `adminid` = 1500;
-- SELECT * FROM `treatment_administration`; 

-- DELETE FROM `treatment_employee`
-- WHERE `adminid` = 1500;
-- SELECT * FROM `treatment_employee`;            

-- UPDATE `admission`
-- SET `dischargedate` = '2025-03-22'
-- WHERE `admissionid` = 500;				
                