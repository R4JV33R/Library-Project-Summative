import java.util.Scanner;
import java.io.*;
public class LoginTutorial
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        do
        {
            boolean isLogin=login1();
            if(isLogin)
            {
                System.out.println("This usernname is already in use! Please choose a new one");
                break;
            }
        }while(false);


                //Scanner sc=new Scanner(System.in);
                String home = System.getProperty("user.home");
                File file1 = new File(home + File.separator + "Desktop" + File.separator +"Library Project"+ File.separator + "src" +File.separator + "account.txt");

                FileWriter file=new FileWriter(file1,true);
                BufferedWriter b=new BufferedWriter(file);
                System.out.println("Please do the registeration");
                System.out.println("enter the username");
                String user=sc.next();

do {

    System.out.println("enter the password");
    String pass = sc.next();
    System.out.println("Re-enter the password");
    String pass1 = sc.next();
    if (pass.equals(pass1)) {
        //String pass=sc.next(){


        b.write(user);
        b.write("\t");

        b.write(pass);

        b.newLine();
        b.close();
        file.close();
        System.out.println("registration completed successfully");
        break;
    }
    else
    {
        System.out.println("Password not matching");

    }
}while(true);
        System.out.println("please login to check your account");



        do
        {
            boolean isLogin1=login();
            if(isLogin1)
            {
                System.out.println("Login Successful");
                break;
            }
            else
            {
                System.out.println("Login Failed");
            }
        }while(true);


    }
    public static boolean login() {
        boolean isAuthenticated = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();




        String home = System.getProperty("user.home");
        File file = new File(home + File.separator + "Desktop" + File.separator + "Library Project" + File.separator + "src" + File.separator + "account.txt");

        try {
            Scanner inputBuffer = new Scanner(file);
            while (inputBuffer.hasNext()) {
                String line = inputBuffer.nextLine();
                String[] values = line.split("\t");

                if (values[0].equals(username)) {
                    if (values[1].equals(password)) {
                        isAuthenticated = true;
                    }
                }
            }
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }

        return isAuthenticated;

    }

        public static boolean login1()
        {
            boolean isAuthenticated=false;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your username");
            String username=sc.next();






            String home = System.getProperty("user.home");
            File file = new File(home + File.separator + "Desktop" + File.separator +"Library Project"+ File.separator + "src" +File.separator + "account.txt");

            try
            {
                Scanner inputBuffer=new Scanner(file);
                while(inputBuffer.hasNext())
                {
                    String line=inputBuffer.nextLine();
                    String[] values=line.split("\t");

                    if(values[0].equals(username))
                    {

                            isAuthenticated=true;

                    }
                }
            }
            catch(FileNotFoundException fe)
            {
                fe.printStackTrace();
            }

            return isAuthenticated;
    }
}


