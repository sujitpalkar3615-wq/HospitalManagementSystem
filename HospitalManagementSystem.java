import java.util.Scanner;

class employee{
    private  int id;
    private  String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    
}

class Doctor extends employee{
    private int PatientHandle;
    private double ConsultantFee;

    

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setConsultantFee(double ConsultantFee) {
        this.ConsultantFee = ConsultantFee;
    }

    public void setPatientHandle(int PatientHandle) {
        this.PatientHandle = PatientHandle;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getConsultantFee() {
        return ConsultantFee;
    }

    public int getPatientHandle() {
        return PatientHandle;
    }

    

    public void Display(){
        System.out.println("--------------------------------------------");
        System.out.println("the Doctor id is : " + getId() );
        System.out.println("the Doctors name is : " + getName());
        System.out.println("patients handle by Doctor is : " + getPatientHandle());
        System.out.println("consultant fee of doctor is : " + getConsultantFee());
        System.out.println("--------------------------------------------");

    }

    

    

    
}

class Nurse extends employee{
    private double salary;

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getSalary() {
        return salary;
    }

    public void display(){
        System.out.println("--------------------------------------------");
        System.out.println("Nurse id is : " + getId());
        System.out.println("the name of Nurse is : " + getName());
        System.out.println("the salary of Nurse is : " + getSalary());
        System.out.println("--------------------------------------------");

    }
}





public class HospitalManagementSystem {
    public static Scanner sc = new Scanner(System.in);

    public static int menuList(){
        System.out.println("--------------------------------------------");
        System.out.println("1. Add Doctor:"); 
        System.out.println("2. Add Nurse");
        System.out.println("3. Display Doctors");
        System.out.println("4. Display Nurses");
        System.out.println("5. Search Doctor by ID");
        System.out.println("6. Search Nurse by ID");
        System.out.println("7. Doctor who handled maximum patients");
        System.out.println("8. Nurse having lowest salary");
        System.out.println("9. Exit");
        System.out.println("---------------------------------------------");
        System.out.print("enter your choice:");
        int choice  = sc.nextInt();
        System.out.println("----------------------------------------------");

        return choice;
    }
    public static void main(String args[]) {

        employee emp[] = new employee[10];
        int count = 0;

        int choice;

        while ((choice=menuList())!=9) {
            switch (choice) {
                case 1:
                    if (count==emp.length) {
                        System.out.println("the place is full.....");
                        break;
                    }

                    Doctor d = new Doctor();

                    System.out.print("enter Doctor id : ");
                    d.setId(sc.nextInt());

                    sc.nextLine();

                    System.out.print("enter Doctor name:");
                    d.setName(sc.nextLine());

                    System.out.println();

                    System.out.print("Number of patients handle by Doctors:");
                    d.setPatientHandle(sc.nextInt());

                    System.out.print("consultant fee of doctor is :");
                    d.setConsultantFee(sc.nextDouble());

                    emp[count] = d;
                    count++;
                    break;
                
                case 2:
                    if (count==emp.length) {
                        System.out.println("the place is full.....");
                        break;
                    }

                    Nurse n = new Nurse();

                    System.out.print("enter Nerse id  is:");
                    n.setId(sc.nextInt());

                    sc.nextLine();

                    System.out.print("enter nerse name:");
                    n.setName(sc.nextLine());

                    System.out.println();

                    System.out.print("enter nerse salary:");
                    n.setSalary(sc.nextDouble());

                    emp[count] = n;
                    count++;
                    break;

                case 3:

                    for(int i = 0;i  < count;i++){
                        if (emp[i] instanceof Doctor) {
                            ((Doctor)emp[i]).Display();
                        }
                    }
                    break;

                case 4:
                    for(int i = 0; i < count ; i++){
                        if (emp[i] instanceof Nurse) {
                            ((Nurse)emp[i]).display();
                        }
                    }
                    break;

                case 5:
                    int findNum ;
                    System.out.print("enter the Doctor id :");
                    findNum = sc.nextInt();

                    for(int i= 0; i < count ; i++){
                        if (emp[i] instanceof Doctor) {
                            if (emp[i].getId()==findNum) {
                                ((Doctor)emp[i]).Display();
                                break;
                            }
                        }
                    }
                    break;

                case 6:
                    int findNum2 ;
                    System.out.print("enter the Doctor id :");
                    findNum2 = sc.nextInt();

                    for(int i= 0; i < count ; i++){
                        if (emp[i] instanceof Nurse) {
                            if (emp[i].getId()==findNum2) {
                                ((Nurse)emp[i]).display();
                                break;
                            }
                        }
                    }
                    break;

                case 7:
                    Doctor maxDoctor = null;

                    for (int i = 0; i < count; i++) {
                        if (emp[i] instanceof Doctor) {
                            if (maxDoctor == null ||
                                ((Doctor) emp[i]).getPatientHandle() > maxDoctor.getPatientHandle()) {

                                maxDoctor = (Doctor) emp[i];
                            }
                        }
                    }

                    if (maxDoctor != null) {
                        System.out.println("Doctor with maximum patients: " + maxDoctor.getName());
                    }
                    break;



                case 8:
                    Nurse lowestNurse = null;

                    for (int i = 0; i < count; i++) {
                        if (emp[i] instanceof Nurse) {

                            if (lowestNurse == null ||
                                ((Nurse) emp[i]).getSalary() < lowestNurse.getSalary()) {

                                lowestNurse = (Nurse) emp[i];
                            }
                        }
                    }

                    
                    

                    if (lowestNurse != null) {
                        System.out.println("Nurse with lowest salary: " + lowestNurse.getName());
                    } else {
                        System.out.println("No nurse found.");
                    }

                    break;

                case 9:
                    System.out.println("Thank you...");
                    return;   
                        
                    
            
                default:
                    System.out.println("error...");
                    break;
            }
        }
    }
}


