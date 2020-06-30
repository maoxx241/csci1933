public class Book {
    private String title;
    private String author;
    private String genre;
    private int numPages;
    private int[] array=new int[2];
    public Book(String title_value,String author_value,String genre_value,int numPages_value){
        title=title_value;
        author=author_value;
        genre=genre_value;
        numPages=numPages_value;

    }

    public String getauthor(){
        return author;
    }

    public String getgenre(){
        return genre;
    }
    public int getNumPages(){
        return numPages;
    }

    public void addRating(int rating){
        int index;
        int a=0;
        for(index=0;index<array.length;index++){
            if(array[index]!=0){
                a=a+1;
            }else{
                int[] temp=new int[1+array.length];
                int ind;
                for(ind=0;ind<array.length;ind++){
                    temp[ind]=array[ind];
                }
                array=temp;
                break;
            }
        }


            array[a]= rating;

    }

    public double getAverageRating(){
        double tol=0.0;
        int index;
        int a=0;
        for(int i=0; i<array.length;i++){
            tol=tol+array[i];
        }
        for(index=0;index<array.length;index++){
            if(array[index]!=0){
                a=a+1;
            }else{
                break;
            }
        }
        return tol/(a);

    }

    public int getNumRatings(){
         int in;
         int a=0;
        for(in=0;in<array.length;in++){
            if(array[in]!=0){
                a=a+1;
            }else{
                break;
            }
        }

        return a;

    }

    public boolean equals(Book other){
        boolean result = true;

        return result;
    }

    public String getRatingSummary(){
        double average=getAverageRating();
        int a=0;
        int b =0;
        int c=0;
        int d=0;
        int e=0;
        String out;
        for(int i=0;i<array.length;i++){
            if(array[i]==5){
                a=a+1;

            }else if(array[i]==4){
                b=b+1;

            }else if(array[i]==3){
                c=c+1;

            }else if(array[i]==2){
                d=d+1;

            }else if(array[i]==1){
                e=e+1;

            }
        }
        String Star="*";

        String Star5="";
        for(int i=0;i<a;i++){
            Star5=Star5+Star;
        }
        String Star4="";
        for(int i=0;i<b;i++){
            Star4=Star4+Star;
        }
        String Star3="";
        for(int i=0;i<c;i++){
            Star3=Star3+Star;
        }
        String Star2="";
        for(int i=0;i<d;i++){
            Star2=Star2+Star;
        }
        String Star1="";
        for(int i=0;i<e;i++){
            Star1=Star1+Star;
        }
        return out="Avg Rating "+ String.valueOf(average)+"\n"+"1 | "+Star1+"\n"+"2 | "+Star2+"\n"+"3 | "+Star3+"\n"+"4 | "+Star4+"\n"+"5 | "+Star5;


    }
}
