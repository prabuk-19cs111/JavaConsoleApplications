import java.util.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class UserAcc{
    String username;
    String pin;
    int balance;
    ArrayList<String> trans = new ArrayList<>();
    public static ArrayList<String> withdraw(int a,int[] b){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Scanner sc = new Scanner(System.in);
        ArrayList <String> ans = new ArrayList<>();
        System.out.println("Enter Withdraw Amount : ");
        int wa = sc.nextInt();
        int va =wa;
        int ha = va;
        int[] val = new int[]{100,200,500,2000};
        if(wa<=a){
        if(wa<=b[4]){
            if((a>=wa)&&(wa%100==0)){
                Boolean x =false;
                for(int i=0;i<4;i++){
                    if(wa/val[val.length-1-i]<=b[b.length-2-i]){
                        wa-=wa/val[val.length-1-i]*val[val.length-1-i];
                    }
                    else{
                        wa-=val[val.length-1-i]*b[b.length-1-i];
                    }
                }
                int[] thearray = new int[4];
            if(wa==0){
                for(int i=0;i<4;i++){
                    if(va/val[val.length-1-i]<=b[b.length-2-i]){
                        thearray[i]=va/val[val.length-1-i];
                        va-=va/val[val.length-1-i]*val[val.length-1-i];
                    }
                    else{
                        va-=val[val.length-1-i]*b[b.length-1-i];
                        thearray[i]=va/val[val.length-1-i];
                    }
                }
                for(int opo=0;opo<4;opo++){
                    ans.add(Integer.toString(thearray[thearray.length-opo-1]));
                }
                a-=ha;
                System.out.println("Amount Withdrawed Successfully");
                ans.add(Integer.toString(ha));
                ans.add("WithDrawed = "+Integer.toString(wa)+":Avail. Balance = "+Integer.toString(a) +" at "+formattedDate);
                return ans;
            }
            else{
                ans.add(null);
                return ans;
            }
            }
            else{
                System.out.println("Invalid Amount,Enter In 100's !!");
                ans.add(null);
                ans.add(null);
                return ans;
            }
    }
    else{
        System.out.println("Insufficient ATM Balance");
        ans.add(null);
        ans.add(null);
        return ans;
    }
}else{
    System.out.println("Insufficient Balance");
    ans.add(null);
    ans.add(null);
    return ans;
}
    }
    public static ArrayList<String> deposit(int a){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
    Scanner sc=new Scanner(System.in);
    int[] den =new int[4];
    System.out.println("Enter the amount to be deposited");
    int depositamt=sc.nextInt();
    System.out.println("No.of 100 notes");
    den[0]=sc.nextInt();
    System.out.println("No.of 200 notes");
    den[1]=sc.nextInt();
    System.out.println("No.of 500 notes");
    den[2]=sc.nextInt();
    System.out.println("No.of 2000 notes");
    den[3]=sc.nextInt();
    ArrayList<String> result =new ArrayList<>();
    if(den[0]*100 + den[1]*200 + den[2]*500 + den[3]*2000 == depositamt){
    if((100<=depositamt)&&depositamt%100==0){
        a+=depositamt;
        result.add(Integer.toString(depositamt));
        result.add("Deposited = "+Integer.toString(depositamt)+" : Balance "+Integer.toString(a)+" at "+formattedDate);
        result.add(Integer.toString(den[0]));
        result.add(Integer.toString(den[1]));
        result.add(Integer.toString(den[2]));
        result.add(Integer.toString(den[3]));
        System.out.println("amount deposited successfully and avail balance is "+a);
        return result;
    }
    result.add(null);
    return result;

}
    else{
        result.add(null);
        result.add(null);
        return result;
    }
}

public static ArrayList<String> AmountTransfer(ArrayList<UserAcc> x ,int fromuser , int touser){
    LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
    ArrayList<String> result =new ArrayList<>();
    System.out.println("Enter amount To transfer : ");
    Scanner sc = new Scanner(System.in);
    int amount = sc.nextInt();
    if((amount>0) && (amount<x.get(fromuser).balance)){
        System.out.println("Amount " +amount+ " transferred successfully from "+x.get(fromuser).username+" to "+x.get(touser).username );
        result.add(Integer.toString(amount));
        result.add(Integer.toString(amount)+" transferred to "+x.get(touser).username+" available balance : "+Integer.toString(x.get(fromuser).balance-amount )+"at"+formattedDate);
        result.add(Integer.toString(amount)+" transferred from "+x.get(fromuser).username+" available balance : "+Integer.toString(x.get(touser).balance+amount)+"at"+formattedDate);
        return result;
    }
    else{
        result.add("-1");
        return result;
    }
    }
}
class Admin{
    String adminname;
    String pin;
    
    public static int[] deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Amount to deposit : ");
        int[] den =new int[5];
        System.out.println("Enter the amount to be deposited");
        int depositamt=sc.nextInt();
        System.out.println("No.of 100 notes");
        den[0]=sc.nextInt();
        System.out.println("No.of 200 notes");
        den[1]=sc.nextInt();
        System.out.println("No.of 500 notes");
        den[2]=sc.nextInt();
        System.out.println("No.of 2000 notes");
        den[3]=sc.nextInt();
        if(den[0]*100 + den[1]*200 + den[2]*500 + den[3]*2000 == depositamt){
            if((100<=depositamt)&&depositamt%100==0){
                System.out.println("Amount deposited successfully");
                den[4]=depositamt;
            return den;
        }
        else{
            System.out.println("Enter valid amount");
            den[0]=-1;
        return den;
        }
}
else{
    return den;
}
    }
}
public class Main{

    public static ArrayList<Integer> loginuser(ArrayList<UserAcc> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println("Enter Name :");
        String inputusername = sc.nextLine();
        System.out.println("Enter PIN :");
        String inputpin = sc.nextLine();
        for(int i=0;i<x.size();i++){
            if((x.get(i).username.equals(inputusername))&&(x.get(i).pin.equals(inputpin))){
                System.out.println("Welcome ! "+inputusername);
                result.add(i);
            }
        }
        if(result.size()!=0){
            return result;    
        }
        else{
            result.add(-1);
            return result;
        }
    }

    public static String changepin(String a){
        Scanner sc=new Scanner(System.in);
        System.out.println("current pin");
        String inputcurrentpin=sc.nextLine();
        if(inputcurrentpin.equals(a)){
            System.out.print("Enter new pin : ");
            String newpin=sc.next();
            System.out.print("Confirm new pin : ");
            String cnewpin=sc.next();
            if(newpin.equals(cnewpin)){
                a=newpin;
                System.out.println("Pin changed successfully");
                return newpin;
            }
                else{
                    System.out.println("new pin mismatch");
                    return null;
                }
    }
    
    else{
        System.out.println("Incorrect pin");
        return null;
    }
    }
    
    public static ArrayList<Integer> loginadmin(ArrayList<Admin> x){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println("Enter adminname:");
        String inputadminname=sc.nextLine();
        System.out.println("Enter pin");
        String inputpin=sc.nextLine();
        for(int i=0;i<x.size();i++){
            if((x.get(i).adminname.equals(inputadminname))&&(x.get(i).pin.equals(inputpin))){
                System.out.println("Welcome ! "+inputadminname);
                result.add(i);
            }
        }
        if(result.size()!=0){
            return result;    
        }
        else{
            result.add(-1);
            return result;
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
        a.balance=10000;
        a.pin="1111";
        b.username="userb";
        b.balance=15000;
        b.pin="2222";
        c.username="userc";
        c.balance=9000;
        c.pin="3333";
        ad1.adminname="admin1";
        ad1.pin="111";
        ad2.adminname="admin2";
        ad2.pin="222";
        ad3.adminname="admin3";
        ad3.pin="333";
        int[] deno=new int[] {20,20,10,100,211000};
        ArrayList<UserAcc> users =new ArrayList<>();
        ArrayList<Admin> admins =new ArrayList<>();
        users.add(a);
        users.add(b);
        users.add(c);
        admins.add(ad1);
        admins.add(ad2);
        admins.add(ad3);
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
                    System.out.println("1-withdraw");
                    System.out.println("2-deposit");
                    System.out.println("3-Balance Check");
                    System.out.println("4-Mini Statement");
                    System.out.println("5-Amount Transfer");
                    System.out.println("6-Pin change");
                    System.out.println("7-Exit");
                    System.out.println("Enter Your Choice: ");
                    int ch = sc.nextInt();
                    switch(ch){
                        case 1:ArrayList<String> z =users.get(i).withdraw(users.get(i).balance,deno);
                        if(z.get(0)!=null){
                        users.get(i).balance-=Integer.parseInt(z.get(4));
                        deno[4]-=Integer.parseInt(z.get(4));
                        users.get(i).trans.add(z.get(5));
                        for(int d=0;d<4;d++){
                            deno[d]-=Integer.parseInt(z.get(d));
                        }
                        }
                        else{
                            System.out.println("Insufficient Denominations");
                        }
                        break;
                        case 2:
                        ArrayList<String> dep=users.get(i).deposit(users.get(i).balance);
                        if(dep.get(0)!=null){
                        users.get(i).balance+=Integer.parseInt(dep.get(0));
                        deno[4]+=Integer.parseInt(dep.get(0));
                        users.get(i).trans.add(dep.get(1));
                        for(int v=0;v<4;v++){
                            deno[v]+=Integer.parseInt(dep.get(v+2));
                        }
                        }
                        else{
                            System.out.println("enter valid amount and denomination");
                        }
                        break;
                        case 3:System.out.println("Your Balance is "+users.get(i).balance);
                        break;
                        case 4:
                        System.out.println(users.get(i).trans);
                        break;
                        case 5: for(int k=0;k<users.size();k++){
                            if(k!=i){
                                System.out.println(k+"-"+users.get(k).username);
                            }
                        }
                                int transferamonut = sc.nextInt();
                                if((transferamonut!=i)&&(transferamonut<users.size())&&(transferamonut>=0)){
                                ArrayList<String> transarr =users.get(i).AmountTransfer(users,i,transferamonut);
                                if(transarr.get(0)!="-1"){ 
                                users.get(i).balance-=Integer.parseInt(transarr.get(0));
                                users.get(transferamonut).balance+=Integer.parseInt(transarr.get(0));
                                users.get(i).trans.add(transarr.get(1));
                                users.get(transferamonut).trans.add(transarr.get(2));
                                    }
                                    else{
                                        System.out.println("Enter a Valid Amount");
                                    }
                                }
                                else{
                                    System.out.println("Enter a valid User ");
                                }
                                break;
                        case 7:exit_status_users = true;
                        break;
                        case 6:users.get(i).pin=changepin(users.get(i).pin);
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
                        System.out.println("1-deposit");
                        System.out.println("2-Balance Check");
                        System.out.println("3-Exit");
                        System.out.println("Enter Your Choice: ");
                        int selchoice = sc.nextInt();
                        switch(selchoice){
                        case 1:int [] n =admins.get(choice2).deposit();
                        if(n[0]!=-1){
                            for(int v=0;v<5;v++){
                                deno[v]+=n[v];
                            }

                        }

                        break;
                        case 2:System.out.println("Your Balance is "+(deno[4]));
                        System.out.println("number 100 notes "+(deno[0]));
                        System.out.println("number 200 notes "+(deno[1]));
                        System.out.println("number 500 notes "+(deno[2]));
                        System.out.println("number 2000 notes "+(deno[3]));
                        break;
                        case 3:exit_status_admin = true;
                        break;
                        default:System.out.println("Invalid Choice");
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
        System.out.println("visit again");
        }
}
    
