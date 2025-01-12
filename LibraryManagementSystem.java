import java.util.*;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true;
    }
    
    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Member {
    private String name;
    private String ID;

    public Member(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;
    private Map<String, String> issuedBooks; // ISBN -> Member ID

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        issuedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void borrowBook(String ISBN, String memberID) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && book.isAvailable()) {
                book.setAvailable(false);
                issuedBooks.put(ISBN, memberID);
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not found or not available.");
    }

    public void returnBook(String ISBN) {
        if (issuedBooks.containsKey(ISBN)) {
            for (Book book : books) {
                if (book.getISBN().equals(ISBN)) {
                    book.setAvailable(true);
                    issuedBooks.remove(ISBN);
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
        }
        System.out.println("Book not found or not issued.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getISBN() + ", Available: " + book.isAvailable());
        }
    }

    public void displayIssuedBooks() {
        for (Map.Entry<String, String> entry : issuedBooks.entrySet()) {
            System.out.println("Book ISBN: " + entry.getKey() + ", Issued to Member ID: " + entry.getValue());
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add sample books
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "9780261102354"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));

        // Add sample members
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));

        // Borrow a book
        library.borrowBook("9780261102354", "M001");

        // Return a book
        library.returnBook("9780261102354");

        // Display books
        library.displayBooks();

        // Display issued books
        library.displayIssuedBooks();
    }
}