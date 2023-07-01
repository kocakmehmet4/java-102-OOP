public class Employee {
    String name;
    double salary;
    int hireYear;
    int workHours;

    Employee(String name,double salary,int hireYear,int workHours){
        this.workHours=workHours;
        this.hireYear=hireYear;
        this.name=name;
        this.salary=salary;
    }

    double Tax(){
        if(workHours>40){
            return this.salary * 0.03;
        }
        return this.salary;
    }
    double Gift(){
        if(salary>1000){
            return ((workHours-40)*30);
        }
        return 0;
    }
    double raiseSalary(){
        if(this.hireYear+10>2021){
            return this.salary*0.05;
        }
        else if(this.hireYear+20>2021 && this.hireYear+9<2021){
            return this.salary*0.10;
        }
        else if(this.hireYear+19<2021){
            return this.salary*0.15;
        }
        return this.salary;
    }
    void ToString(){
        System.out.println("Name: "+this.name);
        System.out.println("Work Hours:  "+this.workHours);
        System.out.println("Hire Year: "+this.hireYear);
        System.out.println("Tax: "+Tax());
        System.out.println("Gift: "+Gift());
        System.out.println("Salary Decrease: "+raiseSalary());
        System.out.println("Tax,Gift and Total Salary: "+(this.salary+(Gift()-Tax())));
        System.out.println("Salary: "+(this.salary+raiseSalary()+Gift()-Tax()));


    }
}
