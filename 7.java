package pgrm;

class Employee {
    private double salary = 50000;

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    void showSalary() {
        System.out.println("Employee Salary: " + getSalary());
    }
}

class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.showSalary();
    }
}
