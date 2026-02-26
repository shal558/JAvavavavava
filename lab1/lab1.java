public class Main {

    public static void main(String[] args) {

        StudentInfo student = new StudentInfo(
                "Маркелов Дмитрий Сергеевич",
                "ИВТ-21",
                "Информационные технологии"
        );

        student.printInfo();
    }
}

// Класс с информацией о студенте
class StudentInfo {

    private String fullName;
    private String group;
    private String specialty;

    // Конструктор
    public StudentInfo(String fullName, String group, String specialty) {
        this.fullName = fullName;
        this.group = group;
        this.specialty = specialty;
    }

    // Геттеры (для правильной инкапсуляции)
    public String getFullName() {
        return fullName;
    }

    public String getGroup() {
        return group;
    }

    public String getSpecialty() {
        return specialty;
    }

    // Метод вывода информации
    public void printInfo() {
        System.out.println("ФИО: " + getFullName());
        System.out.println("Группа: " + getGroup());
        System.out.println("Специальность: " + getSpecialty());
    }
}
