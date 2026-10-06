import java.util.*;
import java.util.Comparator;

// Lớp đại diện cho Sinh viên
class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

// Lớp So sánh hai sinh viên theo yêu cầu đề bài

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        // 1. So sánh điểm CGPA (Giảm dần: y so với x)
        if (Double.compare(y.getCgpa(), x.getCgpa()) != 0) {
            return Double.compare(y.getCgpa(), x.getCgpa());
        }

        // 2. So sánh Tên (Tăng dần theo bảng chữ cái)
        if (!x.getFname().equals(y.getFname())) {
            return x.getFname().compareTo(y.getFname());
        }

        // 3. So sánh Mã ID (Tăng dần: x so với y)
        return Integer.compare(x.getId(), y.getId());
    }
}
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // Sắp xếp danh sách sử dụng Comparator đã định nghĩa
        Collections.sort(studentList, new StudentComparator());

        // In kết quả (in ra tên các sinh viên sau khi đã sắp xếp)
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }

        in.close();
    }
}