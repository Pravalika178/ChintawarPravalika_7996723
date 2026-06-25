import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int experience=sc.nextInt();
        SalaryCalculator calc=new SalaryCalculator();
        System.out.println(calc.calculateSalary(experience));
        //System.out.println(result);
    }
}
class SalaryCalculator{
    String calculateSalary(int a){
        if(a<2){
            return "3LPA";
        }
        else if(a>=2 && a<=5){
            return "5LPA to 10LPA";
        }
        else{
            return "15LPA to 25LPA";
        }
    }
}
class EmailRepository{
    void saveToDatabase(){

    }
}
