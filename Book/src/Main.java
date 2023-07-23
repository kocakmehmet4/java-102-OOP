import com.sun.source.tree.Tree;

import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books=new TreeSet<>();
        books.add(new Book("Hunger Games","Suzanne Collins",600,2002));
        books.add(new Book("Philosophers Stone","J.K Rowling",200,2002));
        books.add(new Book("Chamber of Secrets","J.K Rowling",500,2002));
        books.add(new Book("Prisoner of Azkaban","J.K Rowling",1000,2002));
        books.add(new Book("Goblet of Fire","J.K Rowling",400,2002));

        Iterator<Book> iterator= books.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next().getBookName());
        }

    }
}
