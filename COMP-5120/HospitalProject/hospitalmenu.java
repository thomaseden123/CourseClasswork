
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class hospitalmenu {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "$root.54321%";

    public static void main(String[] args) {

        try (Connection connects = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Scanner scan = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n--- Hospital Database Menu ---");
                System.out.println("1. Room Utilization");
                System.out.println("2. Patient Information");
                System.out.println("3. Diagnosis and Treatment Information");
                System.out.println("4. Employee Information");
                System.out.println("5. Exit");
                System.out.print("Enter your choice (1-5): ");
                int c = scan.nextInt();
                scan.nextLine();

                switch (c) {
                    case 1:
                        room_utilization(connects, scan);
                        break;
                    case 2:
                        patient_information(connects, scan);
                        break;
                    case 3:
                        diagnosis_treatment_information(connects, scan);
                        break;
                    case 4:
                        employee_information(connects, scan);
                        break;
                    case 5:
                        System.out.println("Exiting database...");
                        return;
                    default:
                        System.out.println("Invalid input. Please select a number between 1 and 5.");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    private static void room_utilization (Connection connects, Scanner scan) throws SQLException {
        while (true) {
            System.out.println("\n--- Room Utilization ---");
            System.out.println("1.1. Occupied rooms");
            System.out.println("1.2. Unoccupied rooms");
            System.out.println("1.3. Rooms With Patient Names and Admission Dates");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            String c = scan.nextLine();
            switch (c) {
                case "1":
                    run_query(connects, "SELECT r.`roomnum`, p.`name` AS patientname, a.`admissiondate` " +
                            "FROM room r JOIN admission a ON r.`roomnum` = a.`roomnum` " +
                            "JOIN patient p ON a.`patientid` = p.`patientid` " +
                            "LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid` " +
                            "WHERE r.`occupied` = TRUE AND d.`dischargedate` IS NULL;");
                    break;
                case "2":
                    run_query(connects, "SELECT `roomnum` FROM room WHERE occupied = FALSE;");
                    break;
                case "3":
                    run_query(connects, "SELECT r.`roomnum`, p.`name` AS patientname, a.`admissiondate` " +
                            "FROM room r LEFT JOIN admission a ON r.`roomnum` = a.`roomnum` " +
                            "LEFT JOIN patient p ON a.`patientid` = p.`patientid`;");
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input. Please select a number between 1 and 4.");
            }
        }
    }

    private static void patient_information (Connection connects, Scanner scan) throws SQLException {
        while (true) {
            System.out.println("\n--- Patient Information ---");
            System.out.println("2.1. All Patients in Database");
            System.out.println("2.2. Currently Admitted Patients");
            System.out.println("2.3. Discharged Patients in Given Date Range");
            System.out.println("2.4. Admitted Patients in Given Date Range");
            System.out.println("2.5. All Admissions for Given Patients With Diagnosis");
            System.out.println("2.6. All Treatments Administered for Given Patients Grouped by Administration");
            System.out.println("2.7. List Patients Admitted To The Hospital Within 30 Days of Their Discharge Date (Extra Credit)");
            System.out.println("2.8. List Admission Statistics For Each Patient (Extra Credit)");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");
            String c = scan.nextLine();
            switch (c) {
                case "1":
                    run_query(connects, "SELECT * FROM patient;");
                    break;
                case "2":
                    run_query(connects, "SELECT DISTINCT p.`patientid`, p.`name` " +
                            "FROM patient p JOIN admission a ON p.`patientid` = a.`patientid` " +
                            "LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid` " +
                            "WHERE d.`dischargedate` IS NULL;");
                    break;
                case "3":
                    String startdate;
                    while (true) {
                        System.out.print("Enter start discharge date (YYYY-MM-DD): ");
                        startdate = scan.nextLine();
                        try {
                            LocalDate.parse(startdate);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                        }
                    }
                    String enddate;
                    while (true) {
                        System.out.print("Enter end discharge date (YYYY-MM-DD): ");
                        enddate = scan.nextLine();
                        try {
                            LocalDate.parse(enddate);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                        }
                    }
                    PreparedStatement discharge_statement = connects.prepareStatement(
                            "SELECT DISTINCT p.`patientid`, p.`name`, d.`dischargedate` " +
                                    "FROM patient p JOIN admission a ON p.`patientid` = a.`patientid` " +
                                    "JOIN discharge d ON a.`admissionid` = d.`admissionid` " +
                                    "WHERE d.`dischargedate` BETWEEN ? AND ? " +
                                    "ORDER BY d.`dischargedate` ASC;"
                    );
                    discharge_statement.setString(1, startdate);
                    discharge_statement.setString(2, enddate);
                    try (ResultSet result = discharge_statement.executeQuery()) {
                        print_result_set(result);
                    }
                    break;
                case "4":
                    String startdate2;
                    while (true) {
                        System.out.print("Enter start admission date (YYYY-MM-DD): ");
                        startdate2 = scan.nextLine();
                        try {
                            LocalDate.parse(startdate2);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                        }
                    }
                    String enddate2;
                    while (true) {
                        System.out.print("Enter end admission date (YYYY-MM-DD): ");
                        enddate2 = scan.nextLine();
                        try {
                            LocalDate.parse(enddate2);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                        }
                    }
                    PreparedStatement admission_statement = connects.prepareStatement(
                            "SELECT DISTINCT p.`patientid`, p.`name`, a.`admissiondate` " +
                                    "FROM patient p JOIN admission a ON p.`patientid` = a.`patientid` " +
                                    "JOIN discharge d ON a.`admissionid` = d.`admissionid` " +
                                    "WHERE a.`admissiondate` BETWEEN ? AND ? " +
                                    "ORDER BY a.`admissiondate` ASC;"
                    );
                    admission_statement.setString(1, startdate2);
                    admission_statement.setString(2, enddate2);
                    try (ResultSet result = admission_statement.executeQuery()) {
                        print_result_set(result);
                    }
                    break;
                case "5":
                    int patientid;
                    while (true) {
                        System.out.print("Enter patient ID (123, 124, or 125): ");
                        try {
                            patientid = Integer.parseInt(scan.nextLine());
                            if (patientid == 123 || patientid == 124 || patientid == 125) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 123, 124, or 125.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    PreparedStatement statement = connects.prepareStatement(
                            "SELECT a.`admissionid`, a.`admissiondate`, d.`dischargedate`, a.`diagnosisid` " +
                                    "FROM admission a JOIN patient p ON a.`patientid` = p.`patientid` " +
                                    "LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid` " +
                                    "WHERE a.`patientid` = ?"
                    );
                    statement.setInt(1, patientid);
                    try (ResultSet result = statement.executeQuery()) {
                        print_result_set(result);
                    }
                    break;
                case "6":
                    int patientid2;
                    while (true) {
                        System.out.print("Enter patient ID (123, 124, or 125): ");
                        try {
                            patientid2 = Integer.parseInt(scan.nextLine());
                            if (patientid2 == 123 || patientid2 == 124 || patientid2 == 125) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 123, 124, or 125.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    PreparedStatement statement2 = connects.prepareStatement(
                            "SELECT a.`admissionid`, o.`orderid`, t.`name` AS treatmentname, " +
                                    "o.`timestamp` AS order_timestamp, ta.`timestamp` AS admin_timestamp " +
                                    "FROM admission a " +
                                    "JOIN patient p ON p.`patientid` = a.`patientid` " +
                                    "JOIN treatment_order o ON a.`admissionid` = o.`admissionid` " +
                                    "JOIN treatment t ON o.`treatmentid` = t.`treatmentid` " +
                                    "JOIN treatment_administration ta ON ta.`orderid` = o.`orderid` " +
                                    "WHERE p.`patientid` = ? " +
                                    "ORDER BY a.`admissiondate` DESC, o.`timestamp` ASC;"
                    );
                    statement2.setInt(1, patientid2);
                    try (ResultSet result = statement2.executeQuery()) {
                        print_result_set(result);
                    }
                    break;
                case "7":
                    run_query(connects, "SELECT DISTINCT a2.`patientid`, p.`name`, a2.`diagnosisid`, e.`name` AS admittingdoctor " +
                            "FROM admission a2 " +
                            "JOIN patient p ON a2.`patientid` = p.`patientid` " +
                            "JOIN employee e ON a2.`doctorid` = e.`employeeid` " +
                            "WHERE EXISTS (" +
                            "   SELECT 1 FROM admission a1" +
                            "   JOIN discharge d1 ON a1.`admissionid` = d1.`admissionid` " +
                            "   WHERE a1.`patientid` = a2.`patientid` " +
                            "   AND DATEDIFF(a2.`admissiondate`, d1.`dischargedate`) BETWEEN 1 AND 30" +
                            ");");
                    break;
                case "8":
                    run_query(connects, "WITH admission_dates AS (" +
                            "    SELECT patientid, admissiondate," +
                            "    ROW_NUMBER() OVER (PARTITION BY patientid " +
                            "    ORDER BY admissiondate) AS row_num" +
                            "    FROM admission" +
                            ")," +
                            "span AS (" +
                            "    SELECT " +
                            "        now.patientid," +
                            "        DATEDIFF(now.admissiondate, previous.admissiondate) AS gap" +
                            "    FROM admission_dates now" +
                            "    JOIN admission_dates previous " +
                            "        ON now.patientid = previous.patientid AND now.row_num = previous.row_num + 1" +
                            ")," +
                            "summary AS (" +
                            "    SELECT " +
                            "        patientid," +
                            "        MIN(gap) AS shortest, " +
                            "        MAX(gap) AS longest, " +
                            "        ROUND(AVG(gap), 2) AS average " +
                            "    FROM span " +
                            "    GROUP BY patientid " +
                            ")" +
                            "SELECT " +
                            "    p.`patientid`, p.`name`, " +
                            "    (SELECT COUNT(*) FROM admission a WHERE a.`patientid` = p.`patientid`) AS total, " +
                            "    (SELECT ROUND(AVG(DATEDIFF(IFNULL(d.`dischargedate`, CURRENT_DATE), a.`admissiondate`)), 2) " +
                            "     FROM admission a " +
                            "     LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid` " +
                            "     WHERE a.patientid = p.patientid) AS avg_duration, " +
                            "    sum.shortest, sum.longest, sum.average " +
                            "FROM patient p " +
                            "LEFT JOIN summary sum ON p.`patientid` = sum.`patientid`;");
                    break;
                case "9":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input. Please select a number between 1 and 9.");
            }
        }
    }

    private static void diagnosis_treatment_information (Connection connects, Scanner scan) throws SQLException {
        while (true) {
            System.out.println("\n--- Diagnosis and Treatment Menu ---");
            System.out.println("3.1. Diagnoses Given to All Patients, Sorted by Occurrence");
            System.out.println("3.2. Diagnoses Given to Currently Admitted Patients, Sorted by Occurrence");
            System.out.println("3.3. Treatments Performed on Admitted Patients, Sorted by Occurrence");
            System.out.println("3.4. Diagnoses Associated by Patients With Highest Admission Occurrences");
            System.out.println("3.5. List the Patient and Doctor Given the Treatment Occurrence");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");
            String c = scan.nextLine();
            switch (c) {
                case "1":
                    run_query(connects, "SELECT d.`diagnosisid`, d.name, COUNT(*) AS occurrence " +
                            "FROM admission a JOIN diagnosis d ON a.`diagnosisid` = d.`diagnosisid` " +
                            "GROUP BY d.`diagnosisid`, d.name ORDER BY occurrence DESC;");
                    break;
                case "2":
                    run_query(connects, "SELECT d1.`diagnosisid`, d1.name, COUNT(*) AS occurrence " +
                            "FROM admission a JOIN diagnosis d1 ON a.`diagnosisid` = d1.`diagnosisid` " +
                            "LEFT JOIN discharge d2 ON a.`admissionid` = d2.`admissionid` WHERE d2.`dischargedate` IS NULL " +
                            "GROUP BY d1.`diagnosisid`, d1.name ORDER BY occurrence DESC;");
                    break;
                case "3":
                    run_query(connects, "SELECT t.`treatmentid`, t.name, COUNT(*) AS occurrence FROM treatment t " +
                            "JOIN treatment_order o ON o.`treatmentid` = t.`treatmentid` " +
                            "JOIN admission a ON o.`admissionid` = a.`admissionid` " +
                            "LEFT JOIN discharge d ON a.`admissionid` = d.`admissionid` WHERE d.`dischargedate` IS NULL " +
                            "GROUP BY t.`treatmentid`, t.name ORDER BY occurrence DESC;");
                    break;
                case "4":
                    run_query(connects, "WITH patient_admit_count AS (" +
                            "   SELECT patientid, COUNT(*) AS admission_count FROM admission GROUP BY patientid" +
                            ")," +
                            "top_patient AS (" +
                            "   SELECT patientid FROM patient_admit_count WHERE admission_count = (" +
                            "   SELECT MAX(admission_count) FROM patient_admit_count" +
                            "   )" +
                            ")" +
                            "SELECT a.`patientid`, d.`name` AS diagnosisname " +
                            "FROM admission a " +
                            "JOIN top_patient t ON a.`patientid` = t.`patientid` " +
                            "JOIN diagnosis d ON a.`diagnosisid` = d.`diagnosisid` " +
                            "ORDER BY d.`name` ASC;");
                    break;
                case "5":
                    int orderid;
                    while (true) {
                        System.out.print("Enter Order ID (10000, 10001, 10004, 10006, or 10010): ");
                        try {
                            orderid = Integer.parseInt(scan.nextLine());
                            if (orderid == 10000 || orderid == 10001 || orderid == 10004 || orderid == 10006 || orderid == 10010) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 10000, 10001, 10004, 10006, or 10010.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    PreparedStatement statement = connects.prepareStatement("SELECT p.`name` AS patientname, e.`name` AS doctorname " +
                            "FROM treatment_order o JOIN admission a ON o.`admissionid` = a.`admissionid` " +
                            "JOIN patient p ON a.`patientid` = p.`patientid` " +
                            "JOIN employee e ON o.`employeeid` = e.`employeeid` WHERE o.`orderid` = ? ;"
                    );
                    statement.setInt(1, orderid);
                    try (ResultSet result = statement.executeQuery()) {
                        print_result_set(result);
                    }
                    break;
                case "6":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input. Please select a number between 1 and 6.");
            }
        }
    }

    private static void employee_information (Connection connects, Scanner scan) throws SQLException {
        while (true) {
            System.out.println("\n--- Employee Information Menu ---");
            System.out.println("4.1. List All Workers At The Hospital Sorted By Last Name and Job Category");
            System.out.println("4.2. Primary Doctors of Patients With High Admission Rate (At Least 4 Admissions in One Year)");
            System.out.println("4.3. List All Diagnoses By Descending Order Of Occurrence For a Given Doctor");
            System.out.println("4.4. List All Ordered Treatments By Descending Order Of Occurrence For a Given Doctor");
            System.out.println("4.5. Employees Involved In The Treatment of Every Admitted Patient");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");
            String choice = scan.nextLine();

            switch (choice) {
                case "1":
                    run_query(connects, "SELECT `employeeid`, `name`, `role` FROM employee ORDER BY name;");
                    break;
                case "2":
                    run_query(connects, "WITH doctor_count AS (" +
                            "  SELECT patientid, doctorid, COUNT(*) AS admissioncount" +
                            "  FROM admission" +
                            "  GROUP BY patientid, doctorid" +
                            ")," +
                            "primary_doctor AS (" +
                            "  SELECT patientid, doctorid, admissioncount" +
                            "  FROM doctor_count dc" +
                            "  WHERE admissioncount = (" +
                            "    SELECT MAX(dc2.admissioncount)" +
                            "    FROM doctor_count dc2" +
                            "    WHERE dc2.patientid = dc.patientid" +
                            "  )" +
                            "  AND admissioncount >= 4" +
                            ") " +
                            "SELECT pd.`patientid`, p.`name` AS patient_name, pd.`doctorid`, " +
                            "e.`name` AS doctor_name, pd.admissioncount AS admission_count " +
                            "FROM primary_doctor pd " +
                            "JOIN employee e ON pd.`doctorid` = e.`employeeid` " +
                            "JOIN patient p ON pd.`patientid` = p.`patientid`;");
                    break;
                case "3":
                    int doctorid;
                    while (true) {
                        System.out.print("Enter Doctor ID (101, 102, or 103): ");
                        try {
                            doctorid = Integer.parseInt(scan.nextLine());
                            if (doctorid == 101 || doctorid == 102 || doctorid == 103) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 101, 102, or 103.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    PreparedStatement statement = connects.prepareStatement("SELECT d.`diagnosisid`, d.`name`, " +
                            "COUNT(*) AS occurrence FROM admission a " +
                            "JOIN diagnosis d ON a.`diagnosisid` = d.`diagnosisid` " +
                            "WHERE a.`doctorid` = ? " +
                            "GROUP BY d.`diagnosisid`, d.`name` " +
                            "ORDER BY occurrence DESC;"
                    );
                    statement.setInt(1, doctorid);
                    try (ResultSet result = statement.executeQuery()) {
                        print_result_set(result);
                    }
                    break;
                case "4":
                    int doctorid2;
                    while (true) {
                        System.out.print("Enter Doctor ID (101, 102, or 103): ");
                        try {
                            doctorid2 = Integer.parseInt(scan.nextLine());
                            if (doctorid2 == 101 || doctorid2 == 102 || doctorid2 == 103) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter 101, 102, or 103.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    PreparedStatement statement2 = connects.prepareStatement("SELECT t.`treatmentid`, t.`name`, COUNT(*) AS occurrence " +
                            "FROM treatment_order o " +
                            "JOIN treatment t ON o.`treatmentid` = t.`treatmentid` " +
                            "WHERE o.`employeeid` = ? " +
                            "GROUP BY t.`treatmentid`, t.`name` " +
                            "ORDER BY occurrence DESC;"
                    );
                    statement2.setInt(1, doctorid2);
                    try (ResultSet result = statement2.executeQuery()) {
                        print_result_set(result);
                    }
                    break;
                case "5":
                    run_query(connects, "SELECT e.`employeeid`, e.`name` " +
                            "FROM employee e " +
                            "WHERE NOT EXISTS (" +
                            "   SELECT a.`patientid` FROM admission a " +
                            "   WHERE NOT EXISTS (" +
                            "       SELECT 1 FROM treatment_order o" +
                            "       JOIN treatment_administration ta ON o.`orderid` = ta.`orderid`" +
                            "       JOIN treatment_employee te ON ta.`adminid` = te.`adminid`" +
                            "       WHERE o.`patientid` = a.`patientid` AND te.`employeeid` = e.`employeeid`" +
                            "   )" +
                            ");");
                    break;
                case "6":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid input. Please select a number between 1 and 6.");
            }
        }
    }

    private static void run_query (Connection connects, String sql) {
        try (Statement statement = connects.createStatement(); ResultSet result = statement.executeQuery(sql)) {
            print_result_set(result);
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    private static void print_result_set (ResultSet result) throws SQLException {
        ResultSetMetaData meta_data = result.getMetaData();
        int column_number = meta_data.getColumnCount();
        boolean data_found = false;
        while (result.next()) {
            for (int i = 1; i <= column_number; i++) {
                data_found = true;
                if (i > 1) System.out.print(", ");
                String column_value = result.getString(i);
                System.out.print(meta_data.getColumnName(i) + ": " + column_value);
            }
            System.out.println();
        }
        if (!data_found) {
            System.out.println("No data records have been found.");
        }
    }
}