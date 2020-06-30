public class Application  {
   public static void main(String[] args){
     System.out.println("Hello world!");
     int BornYear = 1997;
     int CurrentYear = 2017;
     int days = (CurrentYear - BornYear)*365;
     System.out.println(days);
     int numerator = 1;
     float denominator = 2;
     System.out.println(numerator/denominator);
     float numberatorF = 1;
     float denominatorF = 2;
     System.out.println(numberatorF/denominatorF);
     String Firstname = "Qi";
     String Lastname = "Mao";
     String Fullname = Firstname+" "+ Lastname;
     System.out.println("My first name is - "+ Firstname);
     System.out.println("My last name is - "+ Lastname);
     System.out.println("My full name is _" + Fullname);
     System.out.println(Fullname+ ". The number of days between " +BornYear+" and "+CurrentYear+" is "+days);
     BankAccount myAccount = new BankAccount("Java", "CSCI1933 rules!", 100.50);
     myAccount.password = " CSCI1933 rules!";
     myAccount.deposit("CSCI1933 rules !", 100.50);
     System.out.println("My account's balance is: " + myAccount.balance);
     myAccount.setPassword(" CSCI1933 rules!","MQQ");
     myAccount.setName("MQQ1");
     System.out.println("My account's balance is: "+ myAccount.getBAlance("MQQ"));
   	}
   }
