public class Book {

    private String title;
    private String author;
    private String genre;
    private int numPages;

    private int[] ratings;

    public Book(String title, String author, String genre, int numPages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numPages = numPages;

        ratings = new int[5];
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumPages() {
        return numPages;
    }

    public void addRating(int rating) {
        ratings[rating-1]++;
    }

    public double getAverageRating() {
        int total = 0;
        double numRaters = 0;
        for (int i = 0; i < ratings.length; i++) {
            total += ((i + 1) * ratings[i]);
            numRaters += ratings[i];
        }
        if (numRaters == 0) {
            return 0;
        } else {
            return total / numRaters;
        }
    }

    public int getNumRatings() {
        int total = 0;
        for (int i = 0; i < ratings.length; i++) {
            total += ratings[i];
        }
        return total;
    }

    public String getRatingSummary() {
        String summary = "Avg Rating : " + getAverageRating() + "\n";
        for (int i = 0; i < ratings.length; i++) {
            summary = summary + (i + 1) + " | ";
            for (int j = 0; j < ratings[i]; j++) {
                summary += "*";
            }
            summary += "\n";
        }
        return summary;
    }

    public boolean equals(Book other) {
        boolean authorMatches = author.equals(other.getAuthor());
        boolean titleMatches = title.equals(other.getTitle());
        boolean avgMatches = Math.abs(getAverageRating() - other.getAverageRating()) < 0.0001;
        return authorMatches && titleMatches && avgMatches;
    }

    public int compareTo(Book a, Book b, String sortBy){
        int result= 0;
        if(sortBy.equals("title")){
            if(a.title.equals(b.getTitle())){
                result=0;
            }else{
                result=1;
            }

        }else if(sortBy.equals("author")){
            if(a.author.equals(b.getAuthor())){
                result=0;
            }else{
                result=1;
            }

        }else if(sortBy.equals("genre")){
            if(a.genre.equals(b.getGenre())){
                result=0;
            }else{
                result=1;
            }

        }else if(sortBy.equals("numPages")){
            if(a.numPages==b.getNumPages()){
                result=0;
            }else{
                result=a.numPages-b.getNumPages();
            }

        }
        return result;
    }

    public int compareTo( Book b, String sortBy){
        int result= 0;
        if(sortBy.equals("title")){
            if(title.equals(b.getTitle())){
                result=0;
            }else{
                result=1;
            }

        }else if(sortBy.equals("author")){
            if(author.equals(b.getAuthor())){
                result=0;
            }else{
                result=1;
            }

        }else if(sortBy.equals("genre")){
            if(genre.equals(b.getGenre())){
                result=0;
            }else{
                result=1;
            }

        }else if(sortBy.equals("numPages")){
            if(numPages==b.getNumPages()){
                result=0;
            }else{
                result=numPages-b.getNumPages();
            }

        }
        return result;
    }

}