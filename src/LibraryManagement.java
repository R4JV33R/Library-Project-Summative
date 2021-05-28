import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LibraryManagement {
    String user = "";
    String password = "";
    int nbooks = 4;
    String Bookname[] = new String[nbooks];
    String Bookauthor[] = new String[nbooks];
    String Bookgenre[] = new String[nbooks];
    String Bookreleasedate[] = new String[nbooks];

    void createUser() {
        //Scanner sc = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);
        String sp = " ";
        System.out.println("Enter the Username");
        user = sc.nextLine();
        if ((user.contains(sp)) || user.length() < 4) {
            System.out.println("Invalid Username");
            return;
        }

        System.out.println("Enter the Password");
        password = sc.nextLine();
        if ((password.contains(sp)) || password.length() < 4) {
            System.out.println("Invalid Password");
            return;
        }

        System.out.println(user + " you are Registered Successfully");
        String u1 = user;
        String p1 = password;
        System.out.println("Type yes if you would like to login");
        String chk = sc.nextLine();
        //chk=chk.toLowerCase();
        if (chk.equals("yes")) {
            System.out.println("Enter the Username");
            String user = sc.nextLine();
            System.out.println("Enter the Password");
            String password = sc.nextLine();

            if (user.equals(u1) && password.equals(p1)) {
                System.out.println("Welcome " + user + " you have Logged-in Successfully");
            } else {
                System.out.println("Username or password Mismatch");
            }
        }
    }

    void addBooks() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many books would you like to add?");
        int nbooks = scan.nextInt();
        System.out.println("Please enter the details of " + nbooks + "books");

        String home = System.getProperty("user.home");
        File file1 = new File(home + File.separator + "Desktop" + File.separator + "Library Project" + File.separator + "src" + File.separator + "books.txt");




            FileWriter file = null;
            file = new FileWriter(file1, true);
            BufferedWriter b = new BufferedWriter(file);
            for (int i = 0; i < nbooks; i++) {
                System.out.println("Enter the book name: " + (1 + i));
                Bookname[i] = scan.next();
                System.out.println("Enter the author of the book: " + (1 + i));
                Bookauthor[i] = scan.next();
                System.out.println("Enter the genre of the book: " + (1 + i));
                Bookgenre[i] = scan.next();
                System.out.println("Enter the release date of the book: " + (1 + i));
                Bookreleasedate[i] = scan.next();
                b.write(Bookname[i]);
                b.write("\t\t\t");
                b.write(Bookauthor[i]);
                b.write("\t\t\t");
                b.write(Bookgenre[i]);
                b.write("\t\t\t");
                b.write(Bookreleasedate[i]);
                b.newLine();





            }
             b.close();

             file.close();

        //String home = System.getProperty("user.home");
        File file23 = new File(home + File.separator + "Desktop" + File.separator + "Library Project" + File.separator + "src" + File.separator + "books.txt");


        //File file2 =
               // new File("C:\\Users\\pankaj\\Desktop\\test.txt");
        Scanner sc = new Scanner(file23);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

            System.out.println("List of available books: ");
            System.out.println("Sr.No       Book Name       Author of Book      Genre of Book       Release Date");
            for (int k = 0; k <= nbooks - 1; k++) {
                int p;
                p = k + 1;
                System.out.println(p + "             " + Bookname[k] + "               " + Bookauthor[k] + "             " + Bookgenre[k] + "              " + Bookreleasedate[k]);
            }

        throw new IOException("Error");


        }


    void Browse() throws IOException {
        System.out.println("Press 1 to sort the books alphabetically through the book name");
        System.out.println("Press 2 to browse the books by their name");


        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        switch (n1) {
            case 1: {


                String home = System.getProperty("user.home");
                File file123 = new File(home + File.separator + "Desktop" + File.separator + "Library Project" + File.separator + "src" + File.separator + "books.txt");
                File file2 = new File(home + File.separator + "Desktop" + File.separator + "Library Project" + File.separator + "src" + File.separator + "sorted.txt");
                File fin = new File(String.valueOf(file123));
                File fout = new File(String.valueOf(file2));


                FileInputStream fis = new FileInputStream(fin);
                FileOutputStream fos = new FileOutputStream(fout);

                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

                String aLine;
                ArrayList<String> al = new ArrayList<String>();


                int i = 0;
                while ((aLine = in.readLine()) != null) {
                    //get the lines you want, here I don't want something starting with - or empty
                    if (!aLine.trim().startsWith("-") && aLine.trim().length() > 0) {
                        al.add(aLine);
                        i++;
                    }
                }

                Collections.sort(al);
                //output sorted content to a file
                for (String s : al) {
                    System.out.println(s);
                    out.write(s);
                    out.newLine();
                    out.write("-----------------------------------------");
                    out.newLine();
                }

                in.close();
                out.close();


                break;
            }
            case 2: {


                System.out.println("Enter the book name to check the availability");
                String searchword = scan.next();


                try {


                    // Keep track of the line we are on and what the line is.

                    int LineCount = 0;

                    String line = "";


                    // Create a reader which reads our file. In this example searchfile.txt is the file we are searching.
                    String home = System.getProperty("user.home");
                    File file123 = new File(home + File.separator + "Desktop" + File.separator + "Library Project" + File.separator + "src" + File.separator + "books.txt");
                    BufferedReader bReader = new BufferedReader(new FileReader(file123));


                    // While we loop through the file, read each line until there is nothing left to read.

                    // This assumes we have carriage returns ending each text line.


                    while ((line = bReader.readLine()) != null) {

                        LineCount++;


                        // See if the searchword is in this line, if it is, it will return a position.

                        int posFound = line.indexOf(searchword);


                        // If we found the word, print the position and our current line.

                        if (posFound > -1) {

                            System.out.println("Book is avaiable" + " on sr.no" + LineCount);
                            break;

                        }

                        // They obviosly didn't provide a search term when starting the program.

                        continue;
                    }


                    // Close the reader.

                    bReader.close();


                }catch(IOException e){

                        // We encountered an error with the file, print it to the user.

                        System.out.println("Error: " + e.toString());

                    }




                System.out.println("Book is not avaiable");
            System.out.println("Please choose one of the following: ");
            System.out.println("1. Check in a book");
            System.out.println("2. Check out a book");


            int choice= scan.nextInt();
            switch (choice)
            {
                case 1: {
                    Scanner sc = new Scanner(System.in);
                    String home = System.getProperty("user.home");
                    File file1 = new File(home + File.separator + "Desktop" + File.separator + "Library Project" + File.separator + "src" + File.separator + "checkin.txt");

                    FileWriter file = new FileWriter(file1, true);
                    BufferedWriter b = new BufferedWriter(file);
                    //System.out.println("Please complete the registeration");
                    System.out.println("enter the username to check in a book");
                    String user = sc.next();
















                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();


                    b.write(searchword);
                    b.write("\t");
                    b.write(user);
                    b.write("\t");
                    b.write("checkin");
                    b.write("\t");
                    b.write(formatter.format(date));
                    b.newLine();
                    b.close();
                    file.close();
                    System.out.println("You have successfully checked in this book "+ searchword+" at "+formatter.format(date));
                    break;
                }
                case 2:
                    Scanner sc=new Scanner(System.in);
                    String home = System.getProperty("user.home");
                    File file1 = new File(home + File.separator + "Desktop" + File.separator +"Library Project"+ File.separator + "src" +File.separator + "checkin.txt");

                    FileWriter file=new FileWriter(file1,true);
                    BufferedWriter b=new BufferedWriter(file);
                    System.out.println("enter the username to check out a book");
                    String user=sc.next();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();


                    b.write(searchword);
                    b.write("\t");
                    b.write(user);
                    b.write("\t");
                    b.write("checkout");
                    b.write("\t");
                    b.write(formatter.format(date));
                    b.newLine();
                    b.close();
                    file.close();
                    System.out.println("You have successfully checked out the book "+ searchword+" at "+formatter.format(date));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

            }}



    }
    void regist() throws IOException
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
        chlogin();
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
    void chlogin() throws IOException {
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
        System.out.println("press 1 to add/donate a book");
        System.out.println("press 2 to search through the library by book name");
        int chkd;
        Scanner scan = new Scanner(System.in);
        chkd = scan.nextInt();
        switch (chkd)
        {
            case 1:
            {
               addBooks();

            }
            case 2:
            {
                Browse();
            }

        }
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











    public static class LibraryManagement1 {

        public static void main(String[] args) throws IOException {
            LibraryManagement obj = new LibraryManagement();
            System.out.println("Welcome to Library Management");
            System.out.println("Please do the registration");
            System.out.println("Do not add any SPACES when typing something into our system!");
            System.out.println("1. New Registeration");
            System.out.println("2. Login");
            Scanner scan = new Scanner(System.in);

            int n = scan.nextInt();
            switch (n)
            {
                case 1: {
                    obj.regist();
                    break;
                }

                case 2: {
                    obj.chlogin();
                    break;
                }
            }




            }
        }
    }

