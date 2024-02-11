import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    String firstName;
    String lastName;
    String middleName;
    String yearOfBirth;
    long numberPhone;
    char gender;

    Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

       Main main = new Main();
       main.SaveDataEnter();

    }

     void EnterFirstName() {
        System.out.println("Введите имя:");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }
     void EnterLastName() {
        System.out.println("Введите фамилию:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

     void EnterMiddleName() {
        System.out.println("Введите отчество");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    void EnterYearOfBirth() {
        System.out.println("Введите ваш возраст:");
        yearOfBirth = scan.nextLine();
        if (yearOfBirth.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

     void EnterNumberPhone() {
        try {
            System.out.println("Введите ваш номер телефона:");
            String number = scan.nextLine();
            if (number.isEmpty()) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
            
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.println("Введите ваш пол (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов \nпопробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");
        }
    }

    private void OutPutData() {
        System.out.println("\nИмя \t- \t" + firstName + "\n" + "Фамилия \t- \t" + lastName + "\n" + "Отчество \t- \t" + middleName + "\n" + "Возраст \t- \t" + yearOfBirth + "\n" + "Номер телефона \t- \t" + numberPhone + "\n" + "под   \t- \t" + gender);
    }


    // Метод для сохранения данных в файл
    public  void SaveDataEnter() {

        EnterFirstName();
        EnterLastName();
        EnterMiddleName();
        EnterYearOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();

        String file = "data/" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + middleName + "> " + "<" + yearOfBirth + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Чтото пошло не так!");
        }
    }
}
