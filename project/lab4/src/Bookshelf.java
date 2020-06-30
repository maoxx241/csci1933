public class Bookshelf {
    private Book[] array = new Book[0];


    public Bookshelf(Book[] books) {
        array = books;

    }


    public Book[] getBooksByAuthor(String author) {
        Book[] temp1 = new Book[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getauthor().equals(author)) {
                Book[] temp = new Book[1 + temp1.length];
                if (temp.length == 0) {
                    temp1 = temp;
                    temp1[temp1.length] = array[i];
                } else {
                    int ind;
                    for (ind = 0; ind < temp1.length; ind++) {
                        temp[ind] = temp1[ind];

                    }
                    temp1 = temp;
                    temp1[temp1.length-1] = array[i];
                }


            }


        }
        return temp1;
    }

    public Book[] getBooksFor(ReaderProfile reader) {
        Book[] temp1 = new Book[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getauthor().equals(reader.getfavoriteAuthor())&&array[i].getgenre().equals(reader.getfavoriteGenre())&&array[i].getNumPages()<=reader.getpagesPerMinute()*reader.getdesiredTime()) {
                Book[] temp = new Book[1 + temp1.length];
                if (temp.length == 0) {
                    temp1 = temp;
                    temp1[temp1.length] = array[i];
                } else {
                    int ind;
                    for (ind = 0; ind < temp1.length; ind++) {
                        temp[ind] = temp1[ind];

                    }
                    temp1 = temp;
                    temp1[temp1.length-1] = array[i];
                }


            }


        }
        return temp1;




    }


    public Book getMostPopularBook() {
        int rate = 0;
        Book book1 = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getNumRatings() > rate) {
                rate = array[i].getNumRatings();
                book1 = array[i];
            }

        }

        return book1;

    }
}
