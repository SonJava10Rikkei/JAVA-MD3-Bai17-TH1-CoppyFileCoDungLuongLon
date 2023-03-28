package rikkei.academy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

    // B2 Tạo method main cho phép nhập vào đường dẫn của file nguồn,
    // đường dẫn của thư mục đích và gọi 2 method trên và kiểm tra kết quả
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap duong dan File la: ");
        String sourcePath = in.nextLine();
        System.out.println("Nhap duong dan File muon coppy den la: ");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            System.out.println("Hoan thanh sao chep (Copy completed)");
        } catch (IOException ioe) {
            System.err.println("Không thể sao chép tập tin đó");
            System.err.println(ioe.getMessage());
        }
    }

    // B1.1 Trong lớp Main thực hiện tạo 2 phương thức private static

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }
    // B1.2 copyFileUsingStream

    private static void copyFineUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
