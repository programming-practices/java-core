package IO;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author Cay Horstmann
 * @version 1.13 2016-07-11
 */
public class ExampleRandomAccessFile {
    private static final String path = "src/main/resources/IO/randomAccess/employee.dat";

    public static void main(String[] args) throws IOException {
//---------------------------------------------------------------------------------------------------------------------
        EmployeeRAF[] staff = new EmployeeRAF[3];

        staff[0] = new EmployeeRAF("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new EmployeeRAF("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new EmployeeRAF("Tony Tester", 40000, 1990, 3, 15);

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(path))) {
            // save all employee records to the file employee.dat
            for (EmployeeRAF e : staff)
                writeData(out, e);
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r")) {
            // retrieve all records into a new array

            // compute the array size
            int n = (int) (randomAccessFile.length() / EmployeeRAF.RECORD_SIZE);
            EmployeeRAF[] newStaff = new EmployeeRAF[n];

            // read employees in reverse order
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new EmployeeRAF();
                randomAccessFile.seek(i * EmployeeRAF.RECORD_SIZE);
                newStaff[i] = readData(randomAccessFile);
            }

            // print the newly read employee records
            for (EmployeeRAF e : newStaff)
                System.out.println(e);
        }
//---------------------------------------------------------------------------------------------------------------------
        String filePath = "src/main/resources/IO/RandomAccessFile/Pruebas.txt";
        RandomAccessFile rAF = new RandomAccessFile(filePath, "r");
        rAF.seek(1);
        byte[] bytes = new byte[5];
        rAF.read();
        rAF.close();
        System.out.println(Arrays.toString(bytes));

        File file = new File(filePath);
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
//---------------------------------------------------------------------------------------------------------------------
    }

    /**
     * Writes employee data to a data output
     *
     * @param out the data output
     * @param e   the employee
     */
    public static void writeData(DataOutput out, EmployeeRAF e) throws IOException {
        DataIO.writeFixedString(e.getName(), EmployeeRAF.NAME_SIZE, out);
        out.writeDouble(e.getSalary());

        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }

    /**
     * Reads employee data from a data input
     *
     * @param in the data input
     * @return the employee
     */
    public static EmployeeRAF readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(EmployeeRAF.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new EmployeeRAF(name, salary, y, m - 1, d);
    }
}


class DataIO {
    public static String readFixedString(int size, DataInput in) throws IOException {
        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean more = true;
        while (more && i < size) {
            char ch = in.readChar();
            i++;
            if (ch == 0) more = false;
            else b.append(ch);
        }
        in.skipBytes(2 * (size - i));
        return b.toString();
    }

    public static void writeFixedString(String s, int size, DataOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
            char ch = 0;
            if (i < s.length()) ch = s.charAt(i);
            out.writeChar(ch);
        }
    }
}

class EmployeeRAF {
    public static final int NAME_SIZE = 40;
    public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;

    private String name;
    private double salary;
    private LocalDate hireDay;

    public EmployeeRAF() {
    }

    public EmployeeRAF(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    /**
     * Raises the salary of this employee.
     *
     * @byPercent the percentage of the raise
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return getClass().getName()
                + "[name=" + name
                + ",salary=" + salary
                + ",hireDay=" + hireDay
                + "]";
    }
}


/*
-----------------------------------------------------------------------------------------------------------------------
RandomAccessFile — класс пакета Java IO API, он позволяет перемещаться по файлу, читать из него или писать
в него, как вам будет угодно. Вы также сможете заменить существующие части файла, речь идет о обновлении
содержимого файла, а точней о обновлении фрагмента файла. Это невозможно сделать с помощью FileInputStream
или FileOutputStream, но RandomAccessFile даст вам эту возможность.
-----------------------------------------------------------------------------------------------------------------------
*/