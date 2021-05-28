import java.util.Scanner;

public class MainLibrary
{
    String user; String password;
    void createUser(String user, String password)
    {
        //Scanner sc = new Scanner(System.in);
        user = this.user;
        password = this.password;
        Scanner sc = new Scanner(System.in);
        String sp=" ";
        System.out.println("Enter the Username");
        user = sc.nextLine();
        if((user.contains(sp)) || user.length()<4){
            System.out.println("Invalid Username");
            return;
        }

        System.out.println("Enter the Password");
        password= sc.nextLine();
        if((password.contains(sp)) || password.length()<8){
            System.out.println("Invalid Password");
            return;
        }

        System.out.println(user+" you are Registered Successfully");




    }
    void login(String user, String password)
    {
        user = this.user;
        password = this.password;

    }
}
