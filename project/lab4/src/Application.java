public class Application {
    public static void main(String[] args){
        Book a= new Book("m","q","z",20);
        a.addRating(1);
        a.addRating(4);
        a.addRating(3);
        a.addRating(5);
        System.out.println(a.getNumRatings());
        System.out.println(a.getAverageRating());
        System.out.println(a.getRatingSummary());
        Book b= new Book("y","t","a",30);
        b.addRating(5);
        b.addRating(4);
        b.addRating(3);
        b.addRating(5);
        b.addRating(5);
        System.out.println(b.getNumRatings());
        System.out.println(b.getAverageRating());
        System.out.println(b.getRatingSummary());
        Book c= new Book("z","x","y",40);
        c.addRating(5);
        c.addRating(4);
        c.addRating(3);
        c.addRating(5);
        c.addRating(5);
        c.addRating(5);
        c.addRating(5);
        System.out.println(c.getNumRatings());
        System.out.println(c.getAverageRating());
        System.out.println(c.getRatingSummary());

        HeatGrid heatGrid = new HeatGrid(9, 8);
        heatGrid.placeSource("g",3,4);
        System.out.println(heatGrid.getHeat(3,4));
        }
    }
