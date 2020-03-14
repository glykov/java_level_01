public class Main04 {
    // задание 6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    private static void increaseSalary(Employee[] staff, double amount) {
        for (Employee e : staff) {
            if (e.getAge() > 45) {
                e.setSalary(e.getSalary() + amount);
            }
        }
    }

    // Задание 7. * Подсчитать средние арифметические зарплаты и возраста сотрудников из п.5
    private static int averageAge(Employee[] staff) {
        int ageAve = 0;
        for (Employee e : staff) {
            ageAve += e.getAge();
        }
        ageAve /= staff.length;
        return ageAve;
    }

    private static double averageSalary(Employee[] staff) {
        double salaryAve = 0.0;
        for (Employee e : staff) {
            salaryAve += e.getSalary();
        }
        salaryAve /= staff.length;
        return salaryAve;
    }

    public static void main(String[] args) {
        // 4. Вывести при помощи методов из пункта 3 ФИО и должность.
        Employee e1 = new Employee("William Gates", 64, "Middle Visual Basic Programmer", 40000.0);
        System.out.printf("%s is employed as %s%n and his ID is %d%n", e1.getName(), e1.getPosition(), e1.getID());
        // 5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Employee[] employees = {
                new Employee("Mark Zuckerberg", 35, "Junior PHP Programmer", 30000.0),
                new Employee("Dennis Ritchie", 70, "Senior C Programmer", 110000.0),
                new Employee("Bjarne Stroustrup", 69, "Senior C++ Programmer", 100000.0),
                new Employee("James Gosling", 64, "Senior Java Programmer", 120000.0),
                new Employee("Guido van Rossum", 64, "Senior Python Programmer", 90000.0)
        };
        for (Employee e : employees) {
            if (e.getAge() > 40) {
                System.out.println(e.showEmployeeInfo());
            }
        }
        // задание 6. тест повышения зарплаты
        System.out.println("Salaries before raising");
        for (Employee e : employees) {
            System.out.printf("Name: %s\tSalary: %.2f%n", e.getName(), e.getSalary());
        }
        increaseSalary(employees, 5000.0);
        System.out.println("Salaries after raising");
        for (Employee e : employees) {
            System.out.printf("Name: %s\tSalary: %.2f%n", e.getName(), e.getSalary());
        }
        // задание 7. тест средних
        System.out.println();
        System.out.printf("The average age is %d%n", averageAge(employees));
        System.out.printf("The average salary is %.2f%n", averageSalary(employees));
    }
}
