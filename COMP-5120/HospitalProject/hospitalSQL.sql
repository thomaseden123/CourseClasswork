-- 1.1: Occupied Rooms
SELECT r.`roomnum`, p.`name` AS patientname, a.`admissiondate`
FROM room r
JOIN admission a ON r.`roomnum` = a.`roomnum`
JOIN patient p ON a.`patientid` = p.`patientid`
LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid`
WHERE r.`occupied` = TRUE AND d.`dischargedate` IS NULL;

-- 1.2: Unoccupied Rooms
SELECT `roomnum`
FROM room
WHERE `occupied` = FALSE;

-- 1.3: Rooms With Patient Names and Admission Dates
SELECT r.`roomnum`, p.`name` AS patientname, a.`admissiondate`
FROM room r
LEFT JOIN admission a ON r.`roomnum` = a.`roomnum`
LEFT JOIN patient p ON a.`patientid` = p.`patientid`;

-- 2.1: All Patients in Database
SELECT * FROM patient;

-- 2.2: Currently Admitted Patients
SELECT DISTINCT p.`patientid`, p.`name`
FROM patient p
JOIN admission a ON p.`patientid` = a.`patientid`
LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid`
WHERE d.`dischargedate` IS NULL;

-- 2.3: Discharged Patients in Given Date Range
SET @startdate := '2025-01-01';
SET @enddate := '2025-04-20';
SELECT DISTINCT p.`patientid`, p.`name`, d.`dischargedate`
FROM patient p
JOIN admission a ON p.`patientid` = a.`patientid`
JOIN discharge d ON a.`admissionid` = d.`admissionid`
WHERE d.`dischargedate` BETWEEN @startdate AND @enddate
ORDER BY d.`dischargedate` ASC;

-- 2.4: Admitted Patients in Given Date Range
SET @startdate := '2025-01-01';
SET @enddate := '2025-04-20';
SELECT DISTINCT p.`patientid`, p.`name`, a.`admissiondate`
FROM patient p
JOIN admission a ON p.`patientid` = a.`patientid`
JOIN discharge d ON a.`admissionid` = d.`admissionid`
WHERE a.`admissiondate` BETWEEN @startdate AND @enddate
ORDER BY a.`admissiondate` ASC;

-- 2.5: All Admissions for Given Patients With Diagnosis
SET @patientid = 123;
SELECT CASE
    WHEN @patientid IN (123, 124, 125) THEN 'Patient ID is valid.'
    ELSE 'Invalid input. Please use 123, 124, or 125.'
END AS patient_validation;
SELECT a.`admissionid`, a.`admissiondate`, d.`dischargedate`, a.`diagnosisid`
FROM admission a
JOIN patient p ON a.`patientid` = p.`patientid`
LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid`
WHERE a.`patientid` = @patientid;

-- 2.6: All Treatments Administered for Given Patients Grouped by Administration
SET @patientid = 123;
SELECT CASE
    WHEN @patientid IN (123, 124, 125) THEN 'Patient ID is valid.'
    ELSE 'Invalid input. Please use 123, 124, or 125.'
END AS patient_validation;
SELECT a.`admissionid`, o.`orderid`, t.`name` AS treatmentname, 
       o.`timestamp` AS order_timestamp, ta.`timestamp` AS admin_timestamp
FROM admission a
JOIN patient p ON p.`patientid` = a.`patientid`
JOIN treatment_order o ON a.`admissionid` = o.`admissionid`
JOIN treatment t ON o.`treatmentid` = t.`treatmentid`
JOIN treatment_administration ta ON ta.`orderid` = o.`orderid`
WHERE p.`patientid` = @patientid
ORDER BY a.`admissiondate` DESC, o.`timestamp` ASC;

-- 2.7: List Patients Admitted To The Hospital Within 30 Days of Their Discharge Date (Extra Credit)
SELECT DISTINCT a2.`patientid`, p.`name`, a2.`diagnosisid`, e.`name` AS admittingdoctor
FROM admission a2
JOIN patient p ON a2.`patientid` = p.`patientid`
JOIN employee e ON a2.`doctorid` = e.`employeeid`
WHERE EXISTS (
	SELECT 1
	FROM admission a1
	JOIN discharge d1 ON a1.admissionid = d1.admissionid
	WHERE a1.`patientid` = a2.`patientid`
	AND DATEDIFF(a2.`admissiondate`, d1.`dischargedate`) BETWEEN 1 AND 30
);

-- 2.8: List Admission Statistics For Each Patient (Extra Credit)
WITH admission_dates AS (
    SELECT patientid, admissiondate,
	ROW_NUMBER() OVER (PARTITION BY patientid 
    ORDER BY admissiondate) AS row_num
    FROM admission
),
span AS (
    SELECT 
        now.patientid,
        DATEDIFF(now.admissiondate, previous.admissiondate) AS gap
    FROM admission_dates now
    JOIN admission_dates previous 
        ON now.patientid = previous.patientid AND now.row_num = previous.row_num + 1
),
summary AS (
    SELECT 
        patientid,
        MIN(gap) AS shortest,
        MAX(gap) AS longest,
        ROUND(AVG(gap), 2) AS average
    FROM span
    GROUP BY patientid
)
SELECT 
    p.`patientid`, p.`name`,
    (SELECT COUNT(*) FROM admission a WHERE a.`patientid` = p.`patientid`) AS total,
    (SELECT ROUND(AVG(DATEDIFF(IFNULL(d.`dischargedate`, CURRENT_DATE), a.`admissiondate`)), 2)
     FROM admission a
     LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid`
     WHERE a.patientid = p.patientid) AS avg_duration,
    sum.shortest, sum.longest, sum.average
FROM patient p
LEFT JOIN summary sum ON p.`patientid` = sum.`patientid`;

-- 3.1: Diagnoses Given to All Patients, Sorted by Occurrence
SELECT d.`diagnosisid`, d.`name`, COUNT(*) AS occurrence
FROM admission a
JOIN diagnosis d ON a.`diagnosisid` = d.`diagnosisid`
GROUP BY d.`diagnosisid`, d.`name`
ORDER BY occurrence DESC;

-- 3.2: Diagnoses Given to Currently Admitted Patients, Sorted by Occurrence
SELECT d1.`diagnosisid`, d1.`name`, COUNT(*) AS occurrence
FROM admission a
JOIN diagnosis d1 ON a.`diagnosisid` = d1.`diagnosisid`
LEFT JOIN discharge d2 ON a.`admissionid` = d2.`admissionid`
WHERE d2.`dischargedate` IS NULL
GROUP BY d1.`diagnosisid`, d1.`name`
ORDER BY occurrence DESC;

-- 3.3: Treatments Performed on Admitted Patients, Sorted by Occurrence
SELECT t.`treatmentid`, t.`name`, COUNT(*) AS occurrence
FROM treatment t
JOIN treatment_order o ON o.`treatmentid` = t.`treatmentid`
JOIN admission a ON o.`admissionid` = a.`admissionid`
LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid`
WHERE d.`dischargedate` IS NULL
GROUP BY t.`treatmentid`, t.`name`
ORDER BY occurrence DESC;

-- 3.4: Diagnoses Associated by Patients With Highest Admission Occurrences
WITH patient_admit_count AS (
    SELECT patientid, COUNT(*) AS admission_count
    FROM admission
    GROUP BY patientid
),
top_patient AS (
    SELECT patientid
    FROM patient_admit_count
    WHERE admission_count = (
        SELECT MAX(admission_count) FROM patient_admit_count
    )
)
SELECT a.`patientid`, d.`name` AS diagnosisname
FROM admission a
JOIN top_patient t ON a.`patientid` = t.`patientid`
JOIN diagnosis d ON a.`diagnosisid` = d.`diagnosisid`
ORDER BY d.`name` ASC;

-- 3.5: List the Patient and Doctor Given the Treatment Occurrence
SET @orderid = 10000;
SELECT CASE
    WHEN @orderid IN (10000, 10001, 10004, 10006, 10010) THEN 'Order ID is valid.'
    ELSE 'Invalid input. Please use 10000, 10001, 10004, 10006, or 10010.'
END AS doctor_validation;
SELECT p.`name` AS patientname, e.`name` AS doctorname
FROM treatment_order o
JOIN admission a ON o.`admissionid` = a.`admissionid`
JOIN patient p ON a.`patientid` = p.`patientid`
JOIN employee e ON o.`employeeid` = e.`employeeid`
WHERE o.`orderid` = @orderid 
AND @orderid IN (10000, 10001, 10004, 10006, 10010);

-- 4.1: List All Workers At The Hospital Sorted By Last Name and Job Category
SELECT `employeeid`, `name`, `role`
FROM employee
ORDER BY `name`;

-- 4.2: Primary Doctors of Patients With High Admission Rate (At Least 4 Admissions in One Year)
WITH doctor_count AS (
  SELECT patientid, doctorid, COUNT(*) AS admissioncount
  FROM admission
  GROUP BY patientid, doctorid
),
primary_doctor AS (
  SELECT patientid, doctorid, admissioncount
  FROM doctor_count dc
  WHERE admissioncount = (
    SELECT MAX(dc2.admissioncount)
    FROM doctor_count dc2
    WHERE dc2.patientid = dc.patientid
  )
  AND admissioncount >= 4
)
SELECT pd.`patientid`, p.`name` AS patient_name, pd.`doctorid`, 
	e.`name` AS doctor_name, pd.admissioncount AS admission_count
FROM primary_doctor pd
JOIN employee e ON pd.`doctorid` = e.`employeeid`
JOIN patient p ON pd.`patientid` = p.`patientid`;

-- 4.3: List All Diagnoses By Descending Order Of Occurrence For a Given Doctor
SET @doctorid = 101;
SELECT CASE
    WHEN @doctorid IN (101, 102, 103) THEN 'Doctor ID is valid.'
    ELSE 'Invalid input. Please use 101, 102, or 103.'
END AS doctor_validation;
SELECT d.`diagnosisid`, d.`name`, COUNT(*) AS occurrence
FROM admission a
JOIN diagnosis d ON a.`diagnosisid` = d.`diagnosisid`
WHERE a.`doctorid` = @doctorid 
AND @doctorid IN (101, 102, 103)
GROUP BY d.`diagnosisid`, d.`name`
ORDER BY occurrence DESC;

-- 4.4: List All Ordered Treatments By Descending Order Of Occurrence For a Given Doctor
SET @doctorid = 101;
SELECT CASE
    WHEN @doctorid IN (101, 102, 103) THEN 'Doctor ID is valid.'
    ELSE 'Invalid input. Please use 101, 102, or 103.'
END AS doctor_validation;
SELECT t.`treatmentid`, t.`name`, COUNT(*) AS occurrence
FROM treatment_order o
JOIN treatment t ON o.`treatmentid` = t.`treatmentid`
WHERE o.`employeeid` = @doctorid
AND @doctorid IN (101, 102, 103)
GROUP BY t.`treatmentid`, t.`name`
ORDER BY occurrence DESC;

-- 4.5: Employees Involved In The Treatment of Every Admitted Patient
SELECT e.`employeeid`, e.`name`
FROM employee e
WHERE NOT EXISTS (
	SELECT a.`patientid`
	FROM admission a
	WHERE NOT EXISTS (
		SELECT 1
		FROM treatment_order o
		JOIN treatment_administration ta ON o.`orderid` = ta.`orderid`
		JOIN treatment_employee te ON ta.`adminid` = te.`adminid`
		WHERE o.`patientid` = a.`patientid` AND te.`employeeid` = e.`employeeid`
	)
);