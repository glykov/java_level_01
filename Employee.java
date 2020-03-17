/*
 * 1. Создать класс "Сотрудник" с полями: Фамилия, зарплата, возраст, должность;
 * 2. Конструктор класса должен заполнять эти поля при создании объекта
 * 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
 */
class Employee {
    // задание 1
    private String name;
    private double salary;
    private int age;
    private String position;
    private static int numberOfEmployees = 0;
    private int employeeID;

    // задание 2.
    // 8. *** Продумать конструктор таким образом,
    // чтобы при создании каждому сотруднику присваивался
    // личный уникальный идентификационный порядковый номер
    public Employee(String name, int age, String position, double salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        // 8.1. это простейший вариант, который мне пришел на ум, в рамках изученного
        numberOfEmployees++;
        this.employeeID = numberOfEmployees;
        /*
         * Однако, можно и так
         * 8.2. this.employeeID = this.name.hashCode();
         * правда, String.hashCode() может возвращать отрицательные значения
         * 8.3. можно переодпределить унаследованный от Object метод hasCode(),
         * однако, наследование и аннотацию @Override не изучали )))
         * 8.4. можно написать функцию и назвать ее, например,
         * generateID() - приведена ниже
         * и вызывать ее из конструктора после инициализации полей
         * this.employeeID = generateID();
         */
    }

    // задание 2а.
    public Employee(String name, int age) {
        this(name, age, "Junior Java Programmer", 45000.0);
    }

    // задание 3.
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        salary = newSalary;
    }

    public int getID() {
        return employeeID;
    }

    // задание 8. Создание уникального номера для сотрудника
    private int generateID() {
        int id = 0;
        for (int i = 0; i < name.length(); i++) {
            id += (int) name.charAt(i);
        }
        return id += age;
    }

    public String showEmployeeInfo() {
        return String.format("Name: %s%nAge: %d%nPosition: %s%nSalary: %.2f%nID: %d%n",
                this.getName(), this.getAge(), this.getPosition(), this.getSalary(), this.getID());
    }
}
