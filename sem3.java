// Урок 3. Продвинутая работа с исключениями в Java
// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class sem3 {

    public static void main(String[] args) {
        try {
            String input = readInputFromUser();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            saveDataToFile(lastName, firstName, middleName, birthDate, phoneNumber, gender);
            System.out.println("Данные успешно сохранены в файл");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String readInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные: ");
        return scanner.nextLine();
    }

    public static void saveDataToFile(String lastName, String firstName, String middleName, String birthDate,
                                      long phoneNumber, char gender) throws IOException {
        String fileName = lastName + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender);
            writer.newLine();
        }
    }
}