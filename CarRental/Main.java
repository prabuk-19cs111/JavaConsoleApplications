import java.util.*;
import java.text.SimpleDateFormat;
class Admin{
    String name;
    String password;
}

class Booked{
    Date pickup;
    Date drop;
    String user;
}
class Bill{
    Date pickup;
    Date drop;
    int id;
    int amount;
}
class Car{
    int id;
    int noofseats;
    int pay;
    ArrayList<Booked> time = new ArrayList<>();
}
class User{
    String name;
    String password;
    ArrayList<Bill> bookedcar = new ArrayList<>();
   
}
public class Main{
    public static int loginuser(ArrayList<User> x){
        Scanner sc = new Scanner(System.in);
        int ans=-1;
        System.out.println("Enter your name");
        String uname=sc.next();
        System.out.println("Enter password");
        String upassword=sc.next();
        for(int i=0;i<x.size();i++){
            if(x.get(i).name.equals(uname) && x.get(i).password.equals(upassword)){
                ans=i;
            }
        }
        return ans;
    }
    public static User reguser(ArrayList<User> x){
        Scanner sc=new Scanner(System.in);
        User z = new User();
        System.out.println("Enter username");
        String usernmae=sc.next();
        System.out.println("Enter password");
        String upasswd=sc.next();
        z.name=usernmae;
        z.password=upasswd;
        return z;

    }

    public static int loginadmin(ArrayList<Admin> x){
        Scanner sc = new Scanner(System.in);
        int ans=-1;
        System.out.println("Enter your name");
        String uname=sc.next();
        System.out.println("Enter password");
        String upassword=sc.next();
        for(int i=0;i<x.size();i++){
            if(x.get(i).name.equals(uname) && x.get(i).password.equals(upassword)){
                ans=i;
            }
        }
        return ans;
    }

    public static long avail_date(Car x,String spickup,String sdrop) throws Exception{
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date pickup = f.parse(spickup);
        Date drop = f.parse(sdrop);
        long res = -1;
        Boolean y = false;
        if(x.time.size()!=0){
        for(int i=0;i<x.time.size();i++){
            if(pickup.before(x.time.get(i).pickup)&&drop.before(x.time.get(i).pickup)||pickup.after(x.time.get(i).drop)&&drop.after(x.time.get(i).drop)){
                y=true;
            }
        }
    }
    else{
        res=x.pay*(drop.getTime()-pickup.getTime())/3600000;
    }
    if(y){
        res=x.pay*(drop.getTime()-pickup.getTime())/3600000;
    }
        return res;
    }

    public static Car addcars(ArrayList<Car> x){
        Scanner sc=new Scanner(System.in);
        Car z = new Car();
        System.out.println("Enter car id");
        int carid=sc.nextInt();
        boolean cond = false;
        for(int i=0;i<x.size();i++){
            if(x.get(i).id==carid){
                cond=true;
            }
        }
        System.out.println("Enter no.of seats");
        int nocs=sc.nextInt();
        System.out.println("Enter pay per hour");
        int cpay=sc.nextInt();
        z.noofseats=nocs;
        z.pay=cpay;
        if(!cond){
            z.id=carid;
        }else{
            z.id=-1;
        }
        return z;
    }
    public static ArrayList<Integer> editcar(ArrayList<Car> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> n = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            System.out.println(i+"-"+x.get(i).id);
        }
        System.out.println("Choose the car to edit : ");
        int ch = sc.nextInt();
        if(ch>=0 && ch<x.size()){
            System.out.println("Enter 0 for Number Of Seats");
            System.out.println("Enter 1 for pay");
            System.out.println("Choose The option You Should Edit : ");
            n.add(ch);
            int opt = sc.nextInt();
            if(opt<2&&opt>-1){
                System.out.println("Enter what it needs to be : ");
                int val = sc.nextInt();
                n.add(opt);
                n.add(val);
            }
            else{
                n.add(-1);
            }
        }
        else{
            n.add(-1);
        }
        return n;
    }

    public static int  delcars(ArrayList<Car> x){
        Scanner sc=new Scanner(System.in);
        int ans=-1;
        for(int i=0;i<x.size();i++){
            System.out.println(i+" car-id "+x.get(i).id);
        }
        int z=sc.nextInt();
        if(z<x.size() &&  z>0){
            ans=z;
        }
        return ans;

    }
    public static void main(String[] args) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Scanner sc=new Scanner(System.in);
        ArrayList<User> users =new ArrayList<>();
        ArrayList<Car> cars =new ArrayList<>();
        ArrayList<Admin> admins =new ArrayList<>();
        User a = new User();
        User b = new User();
        a.name="usera";
        a.password="aaaa";
        b.name="userb";
        b.password="bbbb";
        users.add(a);
        users.add(b);
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();
        c1.id=11;
        c2.id=22;
        c3.id=33;
        c1.noofseats=5;
        c2.noofseats=11;
        c3.noofseats=4;
        c1.pay=100;
        c2.pay=200;
        c3.pay=500;
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        Admin a1=new Admin();
        Admin a2=new Admin();
        a1.name="admin1";
        a1.password="111";
        a2.name="admin2";
        a2.password="222";
        admins.add(a1);
        admins.add(a2);
        
        Boolean whole_exit_status=false;
        while(!whole_exit_status){
            System.out.println("1-Admin");
            System.out.println("2-User");
            System.out.println("3-Exit");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:int i=loginadmin(admins);
                System.out.println("WELCOME ADMIN :) ");
                if(i!=-1){
                    Boolean admin_exit_status=false;
                    while(!admin_exit_status){
                        System.out.println("1-Add cars");
                        System.out.println("2-Delete cars");
                        System.out.println("3-Edit cars");
                        System.out.println("4-view booked cars");
                        System.out.println("6-view all cars");
                        System.out.println("7-Exit");
                        System.out.println("Enter Your Choice : ");
                        int ch=sc.nextInt();
                        switch(ch){
                            case 1: Car q = addcars(cars);
                            cars.add(q);
                            System.out.println("car added successfully");
                            System.out.println("_______________________________________________");
                            break;
                            case 2: int d = delcars(cars);
                            if(d!=-1){
                            cars.remove(d);
                            System.out.println("cars available");
                            System.out.println(cars);
                            System.out.println("_______________________________________________");
                            }
                            break;
                            case 3:ArrayList<Integer> edcar = editcar(cars);
                            if(edcar.get(0)!=-1){
                                if(edcar.get(1)!=-1){
                                    if(edcar.get(1)==0){
                                        cars.get(edcar.get(0)).noofseats=edcar.get(2);
                                        System.out.println("No.of seats edited");
                                        System.out.println("_______________________________________________");
                                    }
                                    else{
                                        cars.get(edcar.get(0)).pay=edcar.get(2);
                                        System.out.println("Pay edited");
                                        System.out.println("_______________________________________________");
                                    }
                                }
                                else{
                                    System.out.println("Enter a valid Option");
                                }
                            }
                            else{
                                System.out.println("Enter a valid option");
                            }
                            break;
                            case 6:for(int j=0;j<cars.size();j++){
                                System.out.println("car_id = "+cars.get(j).id + " - no.of seats = "+cars.get(j).noofseats + " - payperhour = "+cars.get(j).pay);
                                System.out.println("_______________________________________________________");
                            }
                            break;
                            case 7:admin_exit_status=true;
                            break;
                            default:System.out.println("Enter valid option");
                            }
                        }

                    }
                    break;
                    case 2:
                    System.out.println("1-New user");
                    System.out.println("2-Existing user");
                    System.out.println("3-Exit");
                    System.out.println("Enter Your Choice : ");
                    int mo =sc.nextInt();
                    switch(mo){
                        case 1: User newuser=reguser(users);
                        users.add(newuser);
                        System.out.println("Registered Successflly");
                        break;
                    case 2:int l=loginuser(users);
                    if(l!=-1){
                        Boolean user_exit_status=false;
                        while(!user_exit_status){
                            System.out.println("1-Book cars");
                            System.out.println("2-Cancel booking");
                            System.out.println("3-view booked cars");
                             System.out.println("4-Exit");
                            System.out.println("Enter Your Choice : ");
                            int ch=sc.nextInt();
                            switch(ch){
                                case 1: for(int j=0;j<cars.size();j++){
                                    System.out.println(j+"  - car_id = "+cars.get(j).id + " - no.of seats = "+cars.get(j).noofseats + " - payperhour = "+cars.get(j).pay);
                                    System.out.println("_______________________________________________________");
                                }
                                System.out.println("Car to be booked");
                                int ind=sc.nextInt();
                               
                                    if(ind!=-1){
                                    System.out.println("Enter the Day You Want to Pickup the car : in (dd-mm-yyyy)");
                                    String dateu = sc.next();
                                    System.out.println("Enter the time You Want to Pickup the car : in (HH:MM)");
                                    String ptime = sc.next();
                                    String pickupu =dateu+" "+ptime;
                                    System.out.println("Enter the Day You Want to return the car : in (dd-mm-yyyy)");
                                    String ddate = sc.next();
                                    System.out.println("Enter the time You Want to return the car : in (HH:MM)");
                                    String dtime = sc.next();
                                    String dropu = ddate+" "+dtime;
                                    long ad = avail_date(cars.get(ind),pickupu,dropu);
                                    if(ad!=-1){
                                    System.out.println("Total Amount is : "+ad);
                                    System.out.println("Do You Wish to book ?");
                                    System.out.println("Press 0 to confirm");
                                    int con = sc.nextInt();
                                    if(con==0){
                                    Date pickup = f.parse(pickupu);
                                    Date drop = f.parse(dropu);
                                    Booked bk = new Booked();
                                    bk.pickup = pickup;
                                    bk.drop = drop;
                                    bk.user = users.get(l).name;
                                    cars.get(ind).time.add(bk);
                                    Bill bill = new Bill();
                                    bill.amount = (int)ad;
                                    bill.pickup = pickup;
                                    bill.drop = drop;
                                    bill.id = cars.get(ind).id;
                                    users.get(l).bookedcar.add(bill);
                                    System.out.println(" Car Booked Successflly");
                                    System.out.println("_______________________________________________");
                                    }
                                    else{
                                    System.out.println("Booking Cancelled By User");
                                    }
                                    }else{
                                    System.out.println("Car Not Available");
                                    }
                                    }
                                    else{
                                    System.out.println("Incorrect ID Entered");
                                    }
                                    break;
                                    case 2:for(int j=0;j<users.get(l).bookedcar.size();j++){
                                        System.out.println("Car ID : "+users.get(l).bookedcar.get(j).id);
                                        System.out.println("Pickup Time : "+users.get(l).bookedcar.get(j).pickup);
                                        System.out.println("return Time : "+users.get(l).bookedcar.get(j).drop);
                                        System.out.println("Total Amount : "+users.get(l).bookedcar.get(j).amount);
                                        }
                                        System.out.println("Enter The car ID You want to book : ");
                                        int caID = sc.nextInt();
                                        int carindex=-1;
                                        for(int j=0;j<cars.size();j++){
                                        if(cars.get(j).id==caID){
                                        carindex=j;
                                        }
                                        }
                                        int tcarindex=-1;
                                        for(int j=0;j<cars.get(carindex).time.size();j++){
                                        if(cars.get(carindex).time.get(j).user==users.get(l).name){
                                        tcarindex=j;
                                        }
                                        }
                                        int Hcarindex =-1;
                                        for(int j=0;j<users.get(l).bookedcar.size();j++){
                                        if(users.get(l).bookedcar.get(j).id==caID){
                                        Hcarindex = j;
                                        }
                                        }
                                        users.get(l).bookedcar.remove(Hcarindex);
                                        cars.get(carindex).time.remove(tcarindex);
                                        System.out.println("booking cancelled successfully");
                                        
                                       
                                        break;
                                        case 3:for(int j=0;j<users.get(l).bookedcar.size();j++){
                                            System.out.println("Car ID : "+users.get(l).bookedcar.get(j).id);
                                            System.out.println("Pickup Time : "+users.get(l).bookedcar.get(j).pickup);
                                            System.out.println("return Time : "+users.get(l).bookedcar.get(j).drop);
                                            System.out.println("Total Amount : "+users.get(l).bookedcar.get(j).amount);
                                            System.out.println("_______________________________________________");
                                            }
                                            break;
                                
                                
                                        case 4:System.out.println("Logged out successfully");
                                        user_exit_status=true;
                                        break;
                                        default : System.out.println("Enter valid option");

                            }
                            
                        }

                    }
                    else{
                        System.out.println("Enter valid username and password");
                    }
                }
                   
                    break;
                    case 3: whole_exit_status=true;
                    break;
    
                    default:System.out.println("Enter a valid choice");
                }    
        }
        System.out.println("Come again :)");
        System.out.println("_______________________________________________");
    }
}
