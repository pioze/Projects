import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class menuconsole {
    ArrayList<Book> arrayofbook = new ArrayList<>();

    void readintolist(String userpath) throws FileNotFoundException {
        File file = new File(userpath);
        Scanner inf = new Scanner(file);
        while(inf.hasNext()){
            String book_name = inf.nextLine();
            String isbn = inf.nextLine();
            String author = inf.nextLine();
            String publisher = inf.nextLine();
            String dop = inf.nextLine();
            inf.nextLine();
            Book newobj = new Book(book_name, Integer.parseInt(isbn), author, publisher, dop);
            arrayofbook.add(newobj);
        }
    }

    void displaybooks(){
        for(Book elem : arrayofbook){
            System.out.println(elem);
        }
    }

    ArrayList<Book> yearfinder(int year){
        ArrayList<Book> temparrayofbook = new ArrayList<>();
        for(Book elem : arrayofbook){
            String[] dop = elem.getDop().split(" ");
            if(Integer.parseInt(dop[2]) > year){
                temparrayofbook.add(elem);
            }
        }
        return temparrayofbook;
    }

    Book authorfinder(String author){
        for(Book elem : arrayofbook){
            if(elem.getAuthor().equals(author)){
                return elem;
            }
        }
        return new Book();
    }

    void addnewbook(String book_name, int isbn, String author, String publisher, String dop){
        Book newobj = new Book(book_name, isbn, author, publisher, dop);
        arrayofbook.add(newobj);
    }

    void savebooks(String path) throws IOException {
        FileWriter saveback = new FileWriter(path);

        for(Book elem : arrayofbook){
            saveback.write(elem.getBook_name() + "\n" + elem.getIsbn() + "\n" + elem.getAuthor() + "\n" + elem.getPublisher() + "\n" + elem.getDop());
            saveback.write("\n");
            saveback.write("\n");

        }
        saveback.close();
    }


}
