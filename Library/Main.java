import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

class UserAcc{
    String username;
    String password;
    int deposit;
    ArrayList<LocalTime> borrowtime = new ArrayList<>();
    ArrayList<HashMap<String,String>> cart = new ArrayList<>();
    public static void searchbooks(ArrayList<HashMap<String,String>> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ISBN or bookname");
        String s = sc.next();
        for (HashMap<String,String> entry : x) {
            for (String key : entry.keySet()) {
              String value = entry.get(key);
                if(s.equals(value)){
                System.out.println(entry);
                
                }
             }
        }
    }
}


class Admin{
    String adminname;
    String password;
    public static void searchbooks(ArrayList<HashMap<String,String>> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ISBN or bookname");
        String s = sc.next();
        for (HashMap<String,String> entry : x) {
            for (String key : entry.keySet()) {
              String value = entry.get(key);
                if(s.equals(value)){
                System.out.println(entry);
                }
             }
        }
    }

    public static HashMap<String,String> addbooks(ArrayList<HashMap<String,String>> x){
        Scanner sc=new Scanner(System.in);
        HashMap<String,String> res = new HashMap<>();
        System.out.println("Enter ISBN");
        String i=sc.next();
        System.out.println("Enter bookname");
        String n=sc.next();
        System.out.println("Enter count");
        String co=sc.next();
        System.out.println("Enter cost");
        String cos=sc.next();
         res.put("bookname",n);
        res.put("count",co);
        res.put("ISBN",i);
        res.put("cost",cos);
        return res;

    }

    public static ArrayList<HashMap<String,String>> deletebooks(ArrayList<HashMap<String,String>> x) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ISBN or bookname to remove");
        String s = sc.next();
        for (HashMap<String,String> entry : x) {
            for (String key : entry.keySet()) {
              String value = entry.get(key);
                if(s.equals(value)){
                x.remove(entry);
                System.out.println(s + " book deleted ");
                } 
             }   
        }
        sc.close();
        return x;
    }

    public static  ArrayList<HashMap<String,String>> updatebooks(ArrayList<HashMap<String,String>> x) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HashMap<String,String>> resit =new ArrayList<>();
        HashMap<String,String> res = new HashMap<>();
        System.out.println("Enter ISBN");
        String s = sc.next();
        for (HashMap<String,String> entry : x) {
            for (String key : entry.keySet()) {
              String value = entry.get(key);
                if(s.equals(value)){
                x.remove(entry);

                }
             }
        }
      
        System.out.println("Enter bookname");
        String n=sc.next();
        System.out.println("Enter count");
        String co=sc.next();
        System.out.println("Enter cost");
        String cos=sc.next();
        res.put("ISBN",s);
        res.put("bookname",n);
        res.put("count",co);
        res.put("cost",cos);
        x.add(res);
        resit=x;
        System.out.println("Book updated successfily");
        return resit;


    }

}
public class Main{

    public static ArrayList<Integer> loginuser(ArrayList<UserAcc> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> resit = new ArrayList<>();
        System.out.println("Enter Name :");
        String inputusername = sc.nextLine();
        System.out.println("Enter password :");
        String inputpassword = sc.nextLine();
        for(int i=0;i<x.size();i++){
            if((x.get(i).username.equals(inputusername))&&(x.get(i).password.equals(inputpassword))){
                System.out.println("Welcome ! "+inputusername);
                resit.add(i);
            }
        }
        if(resit.size()!=0){
            return resit;    
        }
        else{
            resit.add(-1);
            return resit;
        }
    }

    public static String changepassword(String a){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("current password");
        String inputcurrentpassword=sc.nextLine();
        if(inputcurrentpassword.equals(a)){
            System.out.print("Enter new password : ");
            String newpassword=sc.next();
            System.out.print("Confirm new password : ");
            String cnewpassword=sc.next();
            if(newpassword.equals(cnewpassword)){
                a=newpassword;
                System.out.println("password changed successfily");
                return newpassword;
            }
                else{
                    System.out.println("new password mismatch");
                    return null;
                }
    }
    
    else{
        System.out.println("Incorrect password");
        return null;
    }
    }
    
    public static ArrayList<Integer> loginadmin(ArrayList<Admin> x){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> resit = new ArrayList<>();
        System.out.println("Enter adminname:");
        String inputadminname=sc.nextLine();
        System.out.println("Enter password");
        String inputpassword=sc.nextLine();
        for(int i=0;i<x.size();i++){
            if((x.get(i).adminname.equals(inputadminname))&&(x.get(i).password.equals(inputpassword))){
                System.out.println("Welcome ! "+inputadminname);
                resit.add(i);
            }
        }
        if(resit.size()!=0){
            return resit;    
        }
        else{
            resit.add(-1);
            return resit;
        }
    
    
}
   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        UserAcc a=new UserAcc();
        UserAcc b=new UserAcc();
        UserAcc c=new UserAcc();
        Admin ad1=new Admin();
        Admin ad2=new Admin();
        Admin ad3=new Admin();
        a.username="usera";
        a.password="1111";
        a.deposit=1000;
        b.username="useco";
        b.password="2222";
        b.deposit=5000;
        c.username="userc";
        c.password="3333";
        c.deposit=400;
        ad1.adminname="admin1";
        ad1.password="111";
        ad2.adminname="admin2";
        ad2.password="222";
        ad3.adminname="admin3";
        ad3.password="333";

        ArrayList<UserAcc> users =new ArrayList<>();
        ArrayList<Admin> admins =new ArrayList<>();
        users.add(a);
        users.add(b);
        users.add(c);
        admins.add(ad1);
        admins.add(ad2);
        admins.add(ad3);
        ArrayList<HashMap<String,String>> books = new ArrayList<>();
        HashMap<String,String> x = new HashMap<>();
        x.put("bookname", "planets");
        x.put("count","3");
        x.put("ISBN","01");
        x.put("cost","500");
        HashMap<String,String> y = new HashMap<>();
        y.put("bookname", "Bolt");
        y.put("count","1");
        y.put("ISBN","02");
        y.put("cost","1000");
        books.add(x);
        books.add(y);
        boolean complete_exit=false;
        while(!complete_exit){
            System.out.println("Enter Your Choice : ");
            System.out.println("1-User");
            System.out.println("2-Admin");
            System.out.println("3-Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:int i = loginuser(users).get(0);
                if(i!=-1){
                Boolean exit_status_users=false;
                while(!exit_status_users){
                    System.out.println("1-List of books");
                    System.out.println("2-Search books");
                    System.out.println("3-books to cart");
                    System.out.println("4-view cart");
                    System.out.println("5-deposit amount");
                    System.out.println("6-return book");
                    System.out.println("7-Exit");
                    int ch = sc.nextInt();
                    switch(ch){
                        case 1:System.out.println(books);
                        break;
                        case 2:users.get(i).searchbooks(books);
                        break;
                        case 3:
                        HashMap<String,String>  res = new HashMap<>();
                        if((users.get(i).deposit>=500) && (users.get(i).cart.size())<3){
                            for(int j=0;j<books.size();j++){
                                System.out.println("Refer code = "+ j+" for "+books.get(j).get("ISBN")+" "+books.get(j).get("bookname"));
                            }
                        System.out.print("enter the refer code for book to be add to cart");
                        int co=sc.nextInt();
                        books.get(co).put("count",Integer.toString((Integer.parseInt(books.get(co).get("count"))-1)));
                        res.put("ISBN",books.get(co).get("ISBN"));
                        res.put("bookname",books.get(co).get("bookname"));
                        res.put("cost",books.get(co).get("cost"));
                        users.get(i).cart.add(res);
                        users.get(i).borrowtime.add(LocalTime.now());
                    }
                    break;
                        case 4:System.out.println(users.get(i).cart);
                        break;
                        case 5: 
                        int dep =sc.nextInt();
                        int olddep=users.get(i).deposit;
                        int finaldep=olddep+dep;
                         users.get(i).deposit=finaldep;
                         System.out.println("Current balance is "+users.get(i).deposit);
                         break;
                         case 6:
                         for(int j=0;j<users.get(i).cart.size();j++){
                                 System.out.println("Refer code = "+ j+" for "+users.get(i).cart.get(j).get("ISBN")+" "+users.get(i).cart.get(j).get("bookname"));
                             }
                         System.out.print("enter the refer code for book to be returned");
                         int co=sc.nextInt();
                        LocalTime t1 = users.get(i).borrowtime.get(co);
                        LocalTime t2 = LocalTime.now();
                        long finetime =ChronoUnit.HOURS.between(t1,t2)*60+ChronoUnit.MINUTES.between(t1,t2);
                        if(finetime<1){
                            String z = users.get(i).cart.get(co).get("ISBN");
                         users.get(i).cart.remove(co);
                         for(int k=0;k<books.size();k++){
                             if(books.get(k).get("ISBN")==z){
                                books.get(k).put("count",Integer.toString(Integer.parseInt(books.get(k).get("count"))+1));
                             }
                         }
                        System.out.println("Book returned in-time");
                        }
                        else{
                            System.out.println("Book returning date expired");
                            long fineamount = 0;
                            finetime-=1;
                            int theit=1;
                            while(finetime>0){
                                if(finetime>=10){
                                    fineamount += 10*((int)Math.pow(2,theit));
                                    finetime-=10;
                                    }
                                    else{
                                        fineamount += finetime*((int)Math.pow(2,theit));
                                        finetime=0;
                                    }
                                    theit+=1;
                            }
                            if(fineamount>Integer.parseInt(users.get(i).cart.get(co).get("cost"))*0.8){
                                fineamount = (long) Integer.parseInt(users.get(i).cart.get(co).get("cost"))/2;
                            }
                            System.out.println("Your fine amount is : "+fineamount);
                            System.out.println("1-pay from wallet");
                            System.out.println("2-pay by other means");
                            System.out.println("3-Not now");
                            System.out.println("Enter Your Choice : ");
                            int fc = sc.nextInt();
                            switch(fc){
                                case 1:users.get(i).deposit-=fineamount;
                                String z = users.get(i).cart.get(co).get("ISBN");
                                 users.get(i).cart.remove(co);
                                 for(int k=0;k<books.size();k++){
                                 if(books.get(k).get("ISBN")==z){
                                books.get(k).put("count",Integer.toString(Integer.parseInt(books.get(k).get("count"))+1));
                                     }
                                 }
                                users.get(i).borrowtime.remove(co);
                                break;
                                case 2: String z1 = users.get(i).cart.get(co).get("ISBN");
                                users.get(i).cart.remove(co);
                                for(int k=0;k<books.size();k++){
                                if(books.get(k).get("ISBN")==z1){
                               books.get(k).put("count",Integer.toString(Integer.parseInt(books.get(k).get("count"))+1));
                                    }
                                }
                                users.get(i).borrowtime.remove(co);
                                break;
                                case 3: System.out.println("Please pay the fine early");
                                break;
                            }
                        }    
                    break;
                    case 7:exit_status_users=true;
                        break;

                        default:System.out.println("Invalid Choice");
                    }
                }
            }
            else{
                System.out.println(" ** Enter valid username or password ** ");
            }
                break;
                case 2:int choice2 = loginadmin(admins).get(0);
                 if(choice2!=-1){
                    Boolean exit_status_admin=false;
                    while(!exit_status_admin){
                        System.out.println("1-List of books");
                        System.out.println("2-Search books");
                        System.out.println("3-Add a book");
                        System.out.println("4 delete book");
                        System.out.println("5-Update books");
                        System.out.println("6-Exit");
                        System.out.println("Enter Your Choice: ");
                        int selchoice = sc.nextInt();
                        switch(selchoice){
                        case 1: System.out.println(books);
                        break;
                        case 2:admins.get(choice2).searchbooks(books);
                        break;
                        case 3:HashMap<String,String> res = admins.get(choice2).addbooks(books);
                        books.add(res);
                        System.out.println(books);
                        break;
                        case 4:ArrayList<HashMap<String,String>> delbo = admins.get(choice2).deletebooks(books);
                        books=delbo;
                        break;
                        case 5:ArrayList<HashMap<String,String>> z=admins.get(choice2).updatebooks(books);
                        books=z;
                        System.out.println(books);
                        break;
                        case 6:exit_status_admin = true;
                        break;
                        default:System.out.println("Invalid Choice");
                        break;
                    }
                }
            }
            else{
                System.out.println(" ** Enter valid adminname or password ** ");
            }
                break;
                case 3:complete_exit=true;
                break;
                default:System.out.println("Invalid Choice");
            }
        }
        System.out.println("Knowledge is power");
        }
}
    
