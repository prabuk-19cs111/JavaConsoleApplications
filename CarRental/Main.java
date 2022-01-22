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
    int amt;
}


class Car{
    int id;
    int nos;
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
        z.nos=nocs;
        z.pay=cpay;
        if(!cond){
            z.id=carid;
        }else{
            z.id=-1;
        }
        return z;

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
        a.name="user1";
        a.password="1111";
        b.name="user2";
        b.password="2222";
        users.add(a);
        users.add(b);
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();
        c1.id=11;
        c2.id=22;
        c3.id=33;
        c1.nos=5;
        c2.nos=11;
        c3.nos=4;
        c1.pay=500;
        c2.pay=1000;
        c3.pay=2000;
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
                            break;
                            case 2: int d = delcars(cars);
                            if(d!=-1){
                            cars.remove(d);
                            System.out.println("cars available");
                            System.out.println(cars);
                            }
                            break;
                            case 3:for(int j=0;j<cars.size();j++){
                                System.out.println(j+"  - car_id = "+cars.get(j).id + " - no.of seats = "+cars.get(j).nos + " - payperhour = "+cars.get(j).pay);
                                System.out.println("_______________________________________________________");
                            }
                            System.out.println("CAR to be edited");
                            int ind=sc.nextInt();
                            System.out.println("Enter 0 for to edit no.of seats in car");
                            System.out.println("Enter 1 for to edit pat in car");
                            int c=sc.nextInt();
                            if(c==0){
                                System.out.println("no.of seats to be updated");
                                int us=sc.nextInt();
                                cars.get(ind).nos=us;
                            }
                            else if(c==1){
                                System.out.println("payperhour to be updated");
                                int pp=sc.nextInt();
                                cars.get(ind).pay=pp;
                            }
                            else{
                                System.out.println("Enter valid option");
                            }

                            break;
                            case 6:for(int j=0;j<cars.size();j++){
                                System.out.println("car_id = "+cars.get(j).id + " - no.of seats = "+cars.get(j).nos + " - payperhour = "+cars.get(j).pay);
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
                                    System.out.println(j+"  - car_id = "+cars.get(j).id + " - no.of seats = "+cars.get(j).nos + " - payperhour = "+cars.get(j).pay);
                                    System.out.println("_______________________________________________________");
                                }
                                System.out.println("Car to be booked");
                                int ind=sc.nextInt();
                               
                                    if(ind!=-1){
                                    System.out.println("Enter the Day You Want to Pickup the car : in (dd-mm-yyyy)");
                                    String pdate = sc.next();
                                    System.out.println("Enter the time You Want to Pickup the car : in (HH:MM)");
                                    String ptime = sc.next();
                                    String ppickup =pdate+" "+ptime;
                                    System.out.println("Enter the Day You Want to drop the car : in (dd-mm-yyyy)");
                                    String ddate = sc.next();
                                    System.out.println("Enter the time You Want to drop the car : in (HH:MM)");
                                    String dtime = sc.next();
                                    String ddrop = ddate+" "+dtime;
                                    long ad = avail_date(cars.get(ind),ppickup,ddrop);
                                    if(ad!=-1){
                                    System.out.println("Total Amount is : "+ad);
                                    System.out.println("Do You Wish to book ?");
                                    System.out.println("Press 1 to confirm");
                                    int con = sc.nextInt();
                                    if(con==1){
                                    Date pickup = f.parse(ppickup);
                                    Date drop = f.parse(ddrop);
                                    Booked bk = new Booked();
                                    bk.pickup = pickup;
                                    bk.drop = drop;
                                    bk.user = users.get(l).name;
                                    cars.get(ind).time.add(bk);
                                    Bill bill = new Bill();
                                    bill.amt = (int)ad;
                                    bill.pickup = pickup;
                                    bill.drop = drop;
                                    bill.id = cars.get(ind).id;
                                    users.get(l).bookedcar.add(bill);
                                    System.out.println("Booked Successflly");
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
                                        System.out.println("Drop Time : "+users.get(l).bookedcar.get(j).drop);
                                        System.out.println("Total Amount : "+users.get(l).bookedcar.get(j).amt);
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
                                       
                                       
                                        break;
                                        case 3:for(int j=0;j<users.get(l).bookedcar.size();j++){
                                            System.out.println("Car ID : "+users.get(l).bookedcar.get(j).id);
                                            System.out.println("Pickup Time : "+users.get(l).bookedcar.get(j).pickup);
                                            System.out.println("Drop Time : "+users.get(l).bookedcar.get(j).drop);
                                            System.out.println("Total Amount : "+users.get(l).bookedcar.get(j).amt);
                                            }
                                            break;
                                
                                
                                        case 4:user_exit_status=true;
                                        break;
                                        default : System.out.println("Enter valid option");

                            }
                            
                        }

                    }
                }
                   
                    break;
                    case 3: whole_exit_status=true;
                    break;
    
                    default:System.out.println("Enter a valid choice");
                }    
        }
        System.out.println("Come again");
    }
}
