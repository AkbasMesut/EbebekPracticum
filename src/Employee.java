public class Employee {
    public String name;
    public double salary;
    public int workHours;
    public int hireYear;
    public double taxAmount;
    public double bonusAmount;
    public double netSalaryWithoutRise;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (this.salary >= 1000) {
            taxAmount = this.salary * 0.03;
        }
        return taxAmount;
    }

    public double bonus() {
        if (workHours > 40) {
            bonusAmount = (workHours - 40) * 30;
        }
        return bonusAmount;
    }

    public double getNetSalaryWithoutRise() {
        netSalaryWithoutRise = salary + bonus() - tax();
        return netSalaryWithoutRise;
    }

    public double raiseSalary() {
        int yearDifference = 2021 - hireYear;
        double salaryRaise = 0;

        if (yearDifference < 10) {
            salaryRaise = getNetSalaryWithoutRise() * 0.05;
        } else if (9 < yearDifference && yearDifference < 20) {
            salaryRaise = getNetSalaryWithoutRise() * 0.1;
        } else if (19 < yearDifference) {
            salaryRaise = getNetSalaryWithoutRise() * 0.15;
        }
        return salaryRaise;
    }

    public double totalSalary() {
        double totalSalary = getNetSalaryWithoutRise() + raiseSalary();
        return totalSalary;
    }

    @Override
    public String toString() {
        return "{" +
                "Adı = " + name +
                ", maaş = " + salary +
                ", çalışma saati = " + workHours +
                ", başlangıç yılı = " + hireYear +
                ", vergi = " + tax() + " tl" +
                ", bonus = " + bonus() + " tl" +
                ", vergi ve bonusla birlikte maaş = " + getNetSalaryWithoutRise() + " tl" +
                ", maaş artışı = " + raiseSalary() + " tl" +
                ", toplam maaş = " + totalSalary() + " tl" +
                '}';

    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Okan",10_000,45,1998);
        Employee employee2 = new Employee("Huseyin",100_000,35,2002);
        Employee employee3 = new Employee("Serdar",10_000,40,2010);
        Employee employee4 = new Employee("Bilal",10_000,40,1994);
        Employee employee5 = new Employee("Mesut",10000,60,2016);

        System.out.println();
        System.out.println("employee1 = " + employee1);
        System.out.println();
        System.out.println("employee2 = " + employee2);
        System.out.println();
        System.out.println("employee3 = " + employee3);
        System.out.println();
        System.out.println("employee4 = " + employee4);
        System.out.println();
        System.out.println("employee5 = " + employee5);
    }
}
