import java.util.Scanner;
public class Sorting {
    public static void main(String[] args) {
    String str;
    Scanner scan=new Scanner(System.in);

    String Bookname[]=new String[40];

    //int nbooks=scan.nextInt();
    int nbooks=4;
    System.out.println("Enter book name");
    for(int i=0;i<nbooks;i++)
    {
        Bookname[i]=scan.next();
    }
    for (int i = 0; i < nbooks; i++) {
        for (int j = i+1 ; j < nbooks; j++) {
            if (Bookname[i].compareTo(Bookname[j]) < 0) {
                str = Bookname[i];
                Bookname[i] = Bookname[j];
                Bookname[j] = str;
            }
        }
    }
    System.out.println("booknames in descending order");
    for (int i = 0; i <nbooks; i++)
    {
        System.out.println(Bookname[i]+",");
    }

}
}

