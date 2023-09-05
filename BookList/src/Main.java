import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> bookLists=new ArrayList<>();
        bookLists.add(new Book("b1",100,"y1",2000));
        bookLists.add(new Book("b2",190,"y2",2001));
        bookLists.add(new Book("b3",200,"y3",2002));
        bookLists.add(new Book("b4",110,"y4",2003));
        bookLists.add(new Book("b5",80,"y5",2004));
        bookLists.add(new Book("b6",60,"y6",2005));
        bookLists.add(new Book("b7",160,"y7",2006));
        bookLists.add(new Book("b8",190,"y8",2007));
        bookLists.add(new Book("b9",130,"y9",2008));
        bookLists.add(new Book("b10",50,"y10",2009));

        Map<String,String > map= bookLists.stream().collect(Collectors.toMap(Book::getBookName,Book::getAuthorName));
        System.out.println("Book Title - Author Name Matches:");
        map.forEach((i,j)-> System.out.println(i+"-"+j));

        List<Book> bookListMore100= bookLists.stream().filter(book->book.getPageNumber()>100).collect(Collectors.toList());

        System.out.println("More than 100");
        bookListMore100.forEach(book -> System.out.println(book.getPageNumber()));
    }
}
