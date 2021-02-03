/**
 * @Author: lty
 * @Date: 2020/11/24 15:37
 */
public class Activity {
    private String id;
    private String name;
    private String bookno;
    private String bookprice;
    private Stack stack;

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bookno='" + bookno + '\'' +
                ", bookprice='" + bookprice + '\'' +
                ", stack=" + stack +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
}
