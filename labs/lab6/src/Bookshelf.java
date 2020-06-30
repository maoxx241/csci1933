import java.util.Arrays;
import java.util.Comparator;

public class Bookshelf {

    private Book[] books;
    private Bookshelf bookshelf;
    //private int numComparisions = 0;

    /*
    public int getNumComparisions() {
        return numComparisions;
    }
    */

    public Bookshelf(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book[] getBooksByAuthor(String author) {
        int numMatches = 0;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                numMatches++;
            }
        }

        Book[] authored = new Book[numMatches];
        int where = 0;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                authored[where] = book;
                where++;
            }
        }

        return authored;
    }

    public Book[] getBooksFor(ReaderProfile reader) {
        int numMatches = 0;
        for (Book book : books) {
            boolean authorMatches = book.getAuthor().equals(reader.getFavoriteAuthor());
            boolean genreMatches = book.getGenre().equals(reader.getFavoriteGenre());

            double ppm = reader.getPagesPerMinute();
            boolean timeMatches = (book.getNumPages() / ppm) <= reader.getDesiredTime();

            if (authorMatches && genreMatches && timeMatches) {
                numMatches++;
            }
        }

        Book[] matches = new Book[numMatches];
        int where = 0;
        for (Book book : books) {
            boolean authorMatches = book.getAuthor().equals(reader.getFavoriteAuthor());
            boolean genreMatches = book.getGenre().equals(reader.getFavoriteGenre());

            double ppm = reader.getPagesPerMinute();
            boolean timeMatches = (book.getNumPages() / ppm) <= reader.getDesiredTime();

            if (authorMatches && genreMatches && timeMatches) {
                matches[where] = book;
                where++;
            }
        }

        return matches;
    }

    public Book getMostPopularBook() {
        Book mostPopular = null;
        for (Book book : books) {
            if (mostPopular == null || book.getNumRatings() > mostPopular.getNumRatings()) {
                mostPopular = book;
            }
        }
        return mostPopular;
    }

    public Bookshelf mergeBookshelves(Bookshelf bookshelf2,Bookshelf bookshelf, String sortBy){
        Book[] books1 = this.books;
        Book[] books2 = bookshelf2.books;
        Book[] books = bookshelf.books;


        int i1 = 0;
        int i2 = 0;
        int im=0;

        while(i1 < books1.length && i2 < books2.length){
            if(books1[i1].compareTo(books1[i1],books2[i2],sortBy)<0){
                books[im]=books1[i1];
                i1++;
            }else{
                books[im]=books2[i2];
                i2++;
            }
            im++;
        }

        System.arraycopy(books1, i1, books, im, books1.length - i1);
        System.arraycopy(books2, i2, books, im, books2.length - i2);



        return new Bookshelf(books);
    }

    public Bookshelf mergeSortBookshelf(String sortBy){

        if (this.books.length<=1){
            return this;
        }

            int a=this.books.length/2;
            int b=this.books.length-a;
            Book[] books1 = new  Book[a];//first half of the bookshelf's books
            Book[] books2 = new  Book[b];//last half of the bookshelf's books
        System.arraycopy(this.books, 0, books1, 0, books1.length);
        System.arraycopy(this.books, books1.length, books2, 0, books2.length);
        Bookshelf bookshelf1 = new Bookshelf(books1);
        Bookshelf bookshelf2 = new Bookshelf(books2);

        bookshelf1.mergeSortBookshelf(sortBy);
        bookshelf2.mergeSortBookshelf(sortBy);
        bookshelf1.mergeBookshelves(bookshelf2,this,sortBy);
        return this;


    }



    public static Book[] cloneBookArray(Book[] books, int startIndex, int endIndex){
        int diff = endIndex - startIndex;
        Book[] returnBooks = new Book[diff];
        for (int i = 0; i < returnBooks.length; i++){
            returnBooks[i] = books[startIndex + i];
        }
        return returnBooks;
    }

    public static void printBookTitles(Book[] books){
        System.out.println("");
        for (int i = 0; i < books.length; i++){
            System.out.println("title: " + books[i].getTitle());
            System.out.println("pages"+books[i].getNumPages());
        }
    }


    public Bookshelf bubbleSortBookshelf(String sortBy){
        for(int i = books.length; i > 0; i--){
            for(int j = 0; j < i-1; j++){
                if(books[j].compareTo(books[j+1], sortBy) > 0){
                    Book temp = books[j+1];
                    books[j+1] = books[j];
                    books[j] = temp;
                }
            }
        }
        return this;
    }

    public Bookshelf selectionSortBookshelf(String sortBy){
        for(int i=0;i<books.length-1;i++){
            int index=i;
            for (int j = i + 1; j < books.length; j++){
                if(books[j].compareTo(books[j],books[index],sortBy)<0){
                    index=j;

                }

            }
            Book small=books[index];
            books[index]=books[i];
            books[i]=small;

        }
        return this;
    }

    public static void main(String[] args) {

        Book[] books = {new Book("1984", "Orwell", "Fiction", 528),
        new Book("A Brief History Of Time", "Hawking", "Astronomy", 212),
        new Book("Alice's Adventures in Wonderland", "Carroll", "Fantasy", 272),
        new Book("Harry Potter : The Philosopher's Stone", "Rowling", "Fantasy", 256),
        new Book("Harry Potter : The Chamber of Secrets", "Rowling", "Fantasy", 368),
        new Book("Harry Potter : The Prisoner of Azkaban", "Rowling", "Fantasy", 464),
        new Book("JK Rowling : Autobiography", "Rowling", "Non-Fiction", 500),
        new Book("The Dark Tower: The Gunslinger", "King", "Horror", 224),
        new Book("The Dark Tower: The Drawing of the Three", "King", "Horror", 400),
        new Book("It", "King", "Horror", 1138),
        new Book("Amazing Spider-Man #1", "Ditko", "Comic", 25)};

        Bookshelf bookshelf = new Bookshelf(books);
        bookshelf.mergeSortBookshelf("numPages");
        bookshelf.printBookTitles(books);
    }
}