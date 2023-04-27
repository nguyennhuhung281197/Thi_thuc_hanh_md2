package controller;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ManageStudent manageStudent = new ManageStudent();
        boolean isRun = true;
        while (isRun) {
            System.out.println("""
                     +--------------------------------------+
                      CHỌN CHỨC NĂNG THEO SỐ (Để tiếp tục)
                      1. Xem Danh Sách Sinh Viên 
                      2. Thêm Mới
                      3. Cập Nhập 
                      4. Xóa 
                      5. Sắp Xếp
                      6. Đọc từ file
                      7. Ghi vào file
                      8 Thoát
                     +----------------------------------------+
                    """);
            System.out.println("Chọn chức năng :" +
                    "");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> manageStudent.display();
                case "2" -> manageStudent.addStudent();
                case "3" -> manageStudent.update();
                case "4" -> manageStudent.deleteStudent();
                case "5" -> manageStudent.sortStudent();
                case "6" -> manageStudent.getReadFile();
                case "7" -> manageStudent.getWriteFile();
                case "8" -> isRun = false;
                default -> System.out.println("Vui lòng chọn lại !");
            }
        }
    }

}
