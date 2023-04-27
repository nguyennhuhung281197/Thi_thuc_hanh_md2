package controller;

import fileio.ReadFile;
import fileio.WriteFile;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManageStudent {
    Scanner sc = new Scanner(System.in);

    private List<Student> studentList;
    private ReadFile<Student> readFile;
    private WriteFile<Student> writeFile;

    public ManageStudent() {
        studentList = new ArrayList<>();
        readFile = new ReadFile<>();
        writeFile = new WriteFile<>();
    }

    public ManageStudent(List<Student> studentList) {
        this.studentList = studentList;
    }


    public void addStudent() {
        System.out.println("Nhập Mã Sinh Viên : ");
        String codeStudent = sc.nextLine();

        System.out.println("Nhập Họ Và Tên :  ");
        String nameStudent = sc.nextLine();

        System.out.println("Nhập Tuổi Sinh Viên : ");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại tuổi !");
            }
        }
        System.out.println("Giới Tính : ");
        String sexStudent = sc.nextLine();

        System.out.println("Địa Chỉ : ");
        String addressStudent = sc.nextLine();

        System.out.println("Nhập điểm trung bình : ");
        double medium = sc.nextDouble();
        sc.nextLine();

        boolean check = false;
        for (Student student : studentList) {
            if (student.getCode().equalsIgnoreCase(codeStudent)) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("""
                    +---------------------+
                    | Trùng Mã Sinh viên !|
                    +---------------------+""");
        } else {
            Student student = new Student(codeStudent, nameStudent, age, sexStudent, addressStudent, medium);
            studentList.add(student);
        }

    }

    public void display() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public void update() {
        System.out.println("Nhập mã sinh viên muốn sửa ");
        String check = sc.nextLine();
        if (getById(check) == -1) {
            System.out.println("Mã sinh viên không tồn tại ");
        } else {
            int index = getById(check);
            System.out.println("Bạn Muốn Sửa Gì");
            System.out.println("1. Sửa mã sinh viên");
            System.out.println("2. Sửa tên");
            System.out.println("3.Sửa tuổi");
            System.out.println("4.Sửa giới Tính ");
            System.out.println("5.Sửa địa chỉ ");
            System.out.println("6. Sửa điểm trung bình");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập mã sinh viên Muốn Thay Đổi ");
                    String newCode = sc.nextLine();
                    studentList.get(index).setCode(newCode);
                    System.out.println("Thành Công ");

                    break;
                case 2:
                    System.out.println("Nhập Tên Muốn Thay Đổi ");
                    String name = sc.nextLine();
                    studentList.get(index).setName(name);
                    System.out.println("Thành Công ");
                    break;
                case 3:
                    System.out.println("Nhập tuổi muốn sửa");
                    int age = Integer.parseInt(sc.nextLine());
                    studentList.get(index).setAge(age);
                    break;
                case 4:
                    System.out.println("Nhập giới Tính Muốn Thay Đổi ");
                    String newSex = sc.nextLine();
                    studentList.get(index).setSex(newSex);
                    System.out.println("Thành Công ");
                    break;
                case 5:
                    System.out.println("Nhập địa chỉ muốn thay đổi");
                    String address = sc.nextLine();
                    studentList.get(index).setAddress(address);
                    System.out.println("Thành công");
                    break;
                case 6:
                    System.out.println("Nhập điểm trung bình muốn thay đổi");
                    Double diem = Double.parseDouble(sc.nextLine());
                    studentList.get(index).setMediumScore(diem);
                    break;
                default:
                    System.out.println("Vui long chọn lại !");
                    break;

            }

        }

    }


    public void deleteStudent() {
        String yes = "Y";
        System.out.println("Nhập mã sinh viên muốn xóa : ");
        String deleteCode = sc.nextLine();
        if (getById(deleteCode) == -1) {
            System.out.println("Mã không tồn tại ");
        } else {
            System.out.println("Bạn có muốn xóa không (Nếu muốn xóa hãy nhấp 'Y')");
            String yesDelete = sc.nextLine();
            if (yesDelete.equals(yes)) {
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getCode().equals(deleteCode)) {
                        studentList.remove(i);
                    }
                }
            } else {
                System.out.println("Vui Lòng chọn mục khác");
            }
        }
    }

        public void sortStudent () {
            System.out.println("""
                    +---------------------------------------+
                    | Bạn muốn xếp sếp theo thứ tự như nào  |
                    | 1. Sắp xếp điểm trung bình tăng dần   |
                    | 2. Sắp xếp điểm trung bình giảm dần   |
                    | 3. Thoát                              |
                    +---------------------------------------+
                    """);
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    studentList.sort(Comparator.comparing(student -> student.getMediumScore()));
                    break;
                case "2":
                    studentList.sort(Comparator.comparing((Student student) -> student.getMediumScore()).reversed());
                    break;

                case "3":
                    break;
                default:
                    System.out.println("Nhập số không hợp lệ !");
            }
        }

        public void getReadFile () {
            String yesFile = "yes";
            System.out.println(" Bạn có đồng ý đọc file không (* Cảnh Báo nếu có ấn 'yes' và sẽ xóa hết sinh viên trong bộ nhớ) ");
            String yes = sc.nextLine();
            if (yesFile.equals(yes)) {
                studentList = readFile.readToFile();
                System.out.println("Đọc Thành Công.....");

            } else {
                System.out.println("Đọc không thành công....");
            }

        }

        public void getWriteFile () {
            writeFile.writeToFile(studentList);
            System.out.println("Ghi Thành Công.... ");
        }

        public int getById (String code){
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getCode().equals(code)) {
                    return i;
                }

            }
            return -1;
        }
    }
