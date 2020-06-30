public class ReaderProfile {
    private String favoriteAuthor;
    private String favoriteGenre;
    private double pagesPerMinute;
    private int desiredTime;

    public ReaderProfile(String a,String b, double c, int d){
        favoriteAuthor=a;
        favoriteGenre=b;
        pagesPerMinute=c;
        desiredTime=d;
    }

    public String getfavoriteAuthor(){
        return favoriteAuthor;
    }
    public String getfavoriteGenre(){
        return favoriteGenre;
    }
    public double getpagesPerMinute(){
        return pagesPerMinute;
    }
    public int getdesiredTime(){
        return desiredTime;
    }





}
