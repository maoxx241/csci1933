public class ReaderProfile {

    private String favoriteAuthor;
    private String favoriteGenre;
    private double pagesPerMinute;
    private int desiredTime;

    public ReaderProfile(String author, String genre, double pagesPerMinute, int desiredTime) {
        this.favoriteAuthor = author;
        this.favoriteGenre = genre;
        this.pagesPerMinute = pagesPerMinute;
        this.desiredTime = desiredTime;
    }

    public String getFavoriteAuthor() {
        return favoriteAuthor;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public double getPagesPerMinute() {
        return pagesPerMinute;
    }

    public int getDesiredTime() {
        return desiredTime;
    }
}