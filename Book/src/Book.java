
public class Book implements Comparable<Book> {
    private String bookName;
    private String authorName;
    private int pageNo;
    private int publishDate;

    public Book(String bookName, String authorName, int pageNo, int publicDate) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.pageNo = pageNo;
        this.publishDate = publicDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }


    @Override
    public int compareTo(Book o) {
        return this.getPageNo()-o.getPageNo();
    }
}
