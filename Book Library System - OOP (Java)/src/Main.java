import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        menuconsole menu = new menuconsole();
        Scanner inp = new Scanner(System.in);
        System.out.println("Welcome to my application");
        while(true){
            try{
                System.out.println("Please specify the path for your text file");
                String userpath = inp.nextLine();
                menu.readintolist(userpath);
                break;
            }catch (FileNotFoundException excep){
                System.out.println("Please input a valid file");
            }
        }
        System.out.println();
        System.out.println("What would u like to run?");

        System.out.println();
        while(true){
            System.out.println("1 - Display all books");
            System.out.println("2 - Find books published after year");
            System.out.println("3 - Find a book published by an author");
            System.out.println("4 - Add a new book");
            System.out.println("5 - Save all books");
            int value = inp.nextInt();
            switch (value){
                case 1:
                    menu.displaybooks();
                    break;
                case 2:
                    System.out.println("Please enter the year you would like to search after");
                    int year = inp.nextInt();
                    for(Book elem : menu.yearfinder(year)){
                        System.out.println(elem);
                    }
                    break;
                case 3:
                    inp.nextLine();
                    System.out.println("Please enter the author whose books you would like to search for");
                    String author = inp.nextLine();
                    System.out.println(menu.authorfinder(author));
                    break;
                case 4:
                    inp.nextLine();
                    System.out.println("Please enter the book name");

                    String newname = inp.nextLine();
                    System.out.println("Please enter the ISBN");
                    int newisbn = inp.nextInt();
                    System.out.println("Please enter the author");
                    inp.nextLine();
                    String newauthor = inp.nextLine();
                    System.out.println("Please enter the book publisher");
                    String newpublishing = inp.nextLine();
                    System.out.println("Please enter the date of publishing");
                    String newdate = inp.nextLine();
                    menu.addnewbook(newname, newisbn, newauthor, newpublishing, newdate);
                    System.out.println("Would you like to save the file? (y/n)");
                    String yon = inp.nextLine();
                    if(yon.equalsIgnoreCase("N")){
                        break;
                    }
                    else if(yon.equalsIgnoreCase("Y")){

                    }
                    else {
                        System.out.println("Invalid Choice");
                        break;
                    }
                case 5:
                    while(true){
                        Scanner newscanner = new Scanner(System.in);
                        System.out.println("Where would you like to save the file?");
                        String filedir = newscanner.nextLine();
                        try{
                            menu.savebooks(filedir);
                            break;
                        }
                        catch(FileNotFoundException excep){
                            System.out.println("Please try again");
                        }
                    }
                    break;
            }
            System.out.print("Do you wish to exit (Y/N) : ");
            String nextinput = inp.next();
            if(nextinput.equalsIgnoreCase("N")){
                continue;
            }
            else if(nextinput.equalsIgnoreCase("Y")){
                System.exit(1);
            }
            else{
                System.out.println("Invalid Choice");
                continue;
            }
        }

    }
}
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class menuconsole {
//    ArrayList<Book> arrayofbook = new ArrayList<>();
//
//    void readintolist(String userpath) throws FileNotFoundException {
//        File file = new File(userpath);
//        Scanner inf = new Scanner(file);
//        while(inf.hasNext()){
//            String book_name = inf.nextLine();
//            String isbn = inf.nextLine();
//            String author = inf.nextLine();
//            String publisher = inf.nextLine();
//            String dop = inf.nextLine();
//            inf.nextLine();
//            Book newobj = new Book(book_name, Integer.parseInt(isbn), author, publisher, dop);
//            arrayofbook.add(newobj);
//        }
//    }
//
//    void displaybooks(){
//        for(Book elem : arrayofbook){
//            System.out.println(elem);
//        }
//    }
//
//    ArrayList<Book> yearfinder(int year){
//        ArrayList<Book> temparrayofbook = new ArrayList<>();
//        for(Book elem : arrayofbook){
//            String[] dop = elem.getDop().split(" ");
//            if(Integer.parseInt(dop[2]) > year){
//                temparrayofbook.add(elem);
//            }
//        }
//        return temparrayofbook;
//    }
//
//    Book authorfinder(String author){
//        for(Book elem : arrayofbook){
//            if(elem.getAuthor().equals(author)){
//                return elem;
//            }
//        }
//        return new Book();
//    }
//
//    void addnewbook(String book_name, int isbn, String author, String publisher, String dop){
//        Book newobj = new Book(book_name, isbn, author, publisher, dop);
//        arrayofbook.add(newobj);
//    }
//
//    void savebooks(String path) throws IOException {
//        FileWriter saveback = new FileWriter(path);
//
//        for(Book elem : arrayofbook){
//            saveback.write(elem.getBook_name() + "\n" + elem.getIsbn() + "\n" + elem.getAuthor() + "\n" + elem.getPublisher() + "\n" + elem.getDop());
//            saveback.write("\n");
//            saveback.write("\n");
//
//        }
//        saveback.close();
//    }
//
//
//}+9s
