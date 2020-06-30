public class Application {
    public static void main(String[] args){
        Book a=new Book("hello","Qi Mao","hhh",900);
        Book b=new Book("hello","Ti","hhhh",600);
        System.out.println(a.compareTo(a,b,"numPages"));
        System.out.println(a.compareTo(a,b,"title"));
        System.out.println(a.compareTo(a,b,"author"));
        System.out.println(a.compareTo(a,b,"genre"));

    }
}
