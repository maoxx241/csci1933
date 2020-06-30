import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookshelfTest {

    private Bookshelf bookshelf;
    private BookComparator comparator = new BookComparator();

    @Before
    public void setUp() throws Exception {
        Book[] books = new Book[]{
                new Book("1984", "Orwell", "Fiction", 528),
                new Book("A Brief History Of Time", "Hawking", "Astronomy", 212),
                new Book("Alice's Adventures in Wonderland", "Carroll", "Fantasy", 272),
                new Book("Harry Potter : The Philosopher's Stone", "Rowling", "Fantasy", 256),
                new Book("Harry Potter : The Chamber of Secrets", "Rowling", "Fantasy", 368),
                new Book("Harry Potter : The Prisoner of Azkaban", "Rowling", "Fantasy", 464),
                new Book("JK Rowling : Autobiography", "Rowling", "Non-Fiction", 500),
                new Book("The Dark Tower: The Gunslinger", "King", "Horror", 224),
                new Book("The Dark Tower: The Drawing of the Three", "King", "Horror", 400),
                new Book("It", "King", "Horror", 1138),
                new Book("Amazing Spider-Man #1", "Ditko", "Comic", 25)
        };
        bookshelf = new Bookshelf(books);
    }

    @Test
    public void TestGetBooksByAuthorSingleBook() throws Exception {
        Book[] expected = bookshelf.getBooksByAuthor("Ditko");
        Book[] actual = {new Book("Amazing Spider-Man #1", "Ditko", "Comic", 25)};
        checkBooks(expected, actual);
    }


    @Test
    public void TestGetBooksByAuthorMultipleBooks() throws Exception {
        Book[] expected = bookshelf.getBooksByAuthor("Rowling");
        Book[] actual = {
                new Book("Harry Potter : The Philosopher's Stone", "Rowling", "Fantasy", 256),
                new Book("Harry Potter : The Chamber of Secrets", "Rowling", "Fantasy", 368),
                new Book("Harry Potter : The Prisoner of Azkaban", "Rowling", "Fantasy", 464),
                new Book("JK Rowling : Autobiography", "Rowling", "Non-Fiction", 500)
        };
        checkBooks(expected, actual);
    }

    @Test
    public void TestGetBooksByAuthorNone() throws Exception {
        Book[] seuss = bookshelf.getBooksByAuthor("Suess");
        assertEquals(0, seuss.length);
    }

    @Test
    public void TestGetBooksForAll() throws Exception {
        ReaderProfile profile = new ReaderProfile("King", "Horror", 2.0, 2000);
        Book[] expected = {
                new Book("The Dark Tower: The Gunslinger", "King", "Horror", 224),
                new Book("The Dark Tower: The Drawing of the Three", "King", "Horror", 400),
                new Book("It", "King", "Horror", 1138)
        };
        Book[] actual = bookshelf.getBooksFor(profile);
        checkBooks(expected, actual);
    }

    @Test
    public void TestGetBooksForSubsetGenre() throws Exception {
        ReaderProfile profile = new ReaderProfile("Rowling", "Fantasy", 2.0, 2000);
        Book[] expected = {
                new Book("Harry Potter : The Philosopher's Stone", "Rowling", "Fantasy", 256),
                new Book("Harry Potter : The Chamber of Secrets", "Rowling", "Fantasy", 368),
                new Book("Harry Potter : The Prisoner of Azkaban", "Rowling", "Fantasy", 464)
        };
        Book[] actual = bookshelf.getBooksFor(profile);
        checkBooks(expected, actual);
    }

    @Test
    public void TestGetBooksForSubsetTime() throws Exception {
        ReaderProfile profile = new ReaderProfile("King", "Horror", 1.0, 1000);
        Book[] expected = {
                new Book("The Dark Tower: The Gunslinger", "King", "Horror", 224),
                new Book("The Dark Tower: The Drawing of the Three", "King", "Horror", 400)
        };
        Book[] actual = bookshelf.getBooksFor(profile);
        checkBooks(expected, actual);
    }

    @Test
    public void TestGetBooksForSingle() throws Exception {
        ReaderProfile profile = new ReaderProfile("Ditko", "Comic", 2.0, 30);
        Book[] expected = {
                new Book("Amazing Spider-Man #1", "Ditko", "Comic", 25)
        };
        Book[] actual = bookshelf.getBooksFor(profile);
        checkBooks(expected, actual);
    }

    @Test
    public void TestGetBooksForNone() throws Exception {
        ReaderProfile profile = new ReaderProfile("Hawkings", "Fiction", 1.0, 100);
        Book[] actual = bookshelf.getBooksFor(profile);
        assertEquals(0, actual.length);
    }

    @Test
    public void TestGetMostPopularBook() throws Exception {
        Book expected = new Book("Dictionary", "Webster", "Non-Fiction", 9999);

        // Add a bunch of ratings to make it popular
        for (int i = 0; i < 1000; i++) {
            expected.addRating(3);
        }

        Random rand = new Random();

        // Create a bunch of random books with random amounts of rating
        Book[] books = new Book[100];
        for (int i = 0; i < books.length; i++) {
            Book someBook = new Book("book vol" + i, "me", "nonfiction", 100);
            for (int j = 0; j < rand.nextInt(20); j++) {
                someBook.addRating(3);
            }
            books[i] = someBook;
        }

        // Insert the popular book in a random spot
        books[rand.nextInt(books.length)] = expected;
        Bookshelf shelf = new Bookshelf(books);

        Book actual = shelf.getMostPopularBook();
        assertTrue(expected.equals(actual));
    }

    private void checkBooks(Book[] expected, Book[] actual) throws Exception {
        assertEquals(expected.length, actual.length);

        // Just in case you are returning books in a different order
        Arrays.sort(expected, comparator);
        Arrays.sort(actual, comparator);

        for (int i = 0; i < expected.length; i++) {
            assertTrue(expected[i].equals(actual[i]));
        }
    }

    private class BookComparator implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getNumPages() - o2.getNumPages();
        }
    }

}
