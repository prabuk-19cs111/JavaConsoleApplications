import java.util.*;
class User{
    String name;
    String password;
    ArrayList<User> friendslist = new ArrayList<>();
    ArrayList<User> requests = new ArrayList<>();
    ArrayList<Expense> expenses = new ArrayList<>();
    ArrayList<Group> groups = new ArrayList<>();
    int wallet;
}
class Expense{
    String name;
    User fromuser;
    User touser;
    int amount;
}
class GroupExpense{
    String name;
    User fromuser;
    ArrayList<User> touser = new ArrayList<>();
    ArrayList<User> completed = new ArrayList<>();
    int amount;
}
class Group{
    String name;
    ArrayList<User> friendsingroup = new ArrayList<>();
    ArrayList<GroupExpense> groupexpenses = new ArrayList<>();
}
public class Main{
    public static User createuser(){
        Scanner sc = new Scanner(System.in);
        User u = new User();
        System.out.println("Enter Name : ");
        u.name = sc.next();
        System.out.println("Enter password : ");
        u.password = sc.next();
        System.out.println("Enter Amount u need to be added in wallet : ");
        u.wallet = sc.nextInt();
        if(u.wallet<0){
            u.wallet = 0;
            System.out.println("Invalid Amount");
        }
        return u;
    }
    public static ArrayList<Integer> addmember(User x){
        ArrayList<Integer> res = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<x.groups.size();i++){
            System.out.println(i+" - Group Name : "+x.groups.get(i).name);
        }
        System.out.println("Enter the Group : ");
        int grupname = sc.nextInt();
        res.add(grupname);
        for(int i=0;i<x.friendslist.size();i++){
            Boolean b  = true;
            for(int j=0;j<x.groups.get(grupname).friendsingroup.size();j++){
            if(x.friendslist.get(i).name.equals(x.groups.get(grupname).friendsingroup.get(j).name)){
                b=false;
            }
        }
        if(b){
            System.out.println(i+" - "+x.friendslist.get(i).name);
        }
        }
        System.out.println("Enter the Number of friends to be added in friendlist : ");
        int nof = sc.nextInt();
        res.add(nof);
        for(int i=0;i<nof;i++){
            int k = sc.nextInt();
            for(int j=0;j<x.groups.get(grupname).friendsingroup.size();j++){
                if(!x.friendslist.get(k).name.equals(x.groups.get(grupname).friendsingroup.get(j).name)){
                    res.add(k);
                }
                else{
                    System.out.println("User Already in group");
                }
            }
        }
        return res;
    }
    public static int valid_user(ArrayList<User> x){
        int res = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Your password : ");
        String password = sc.nextLine();
        for(int i=0;i<x.size();i++){
            if(x.get(i).name.equals(name)&&x.get(i).password.equals(password)){
                res=i;
            }
        }
        return res;
    }
    public static int addfriendsintolist(ArrayList<User> x,ArrayList<User> y,int z){
        int res = -1;
        Scanner sc = new Scanner(System.in);
        Boolean p = false;
        if(y.size()>0){
        for(int i=0;i<x.size();i++){
            Boolean b= true;
            for(int j=0;j<y.size();j++){
                if((x.get(i).name.equals(y.get(j).name))||(x.get(i).name.equals(x.get(z).name))){
            b = false;
                }
            }
            if(b){
            System.out.println(i+"-"+x.get(i).name);
            p=true;
            }
        }
    }
    else{
        for(int i=0;i<x.size();i++){
                if(!x.get(i).name.equals(x.get(z).name)){
                    p = true;
            System.out.println(i+"-"+x.get(i).name);
                }
        }
    }
    if(p){
        System.out.println("Choose option  : ");
        int ch = sc.nextInt();
        if(ch>=0&&ch<x.size()){
            res = ch;
        }
    }
        return res;
    }
    public static int addwallet(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount  need to be added : ");
        int amount =sc.nextInt();
        return amount;
    }
    public static int acceptfriendsreq(ArrayList<User> x){
        int res = -1;
        if(x.size()>0){
        for(int i=0;i<x.size();i++){
            System.out.println(i+"-"+x.get(i).name);
        }
        System.out.println("Choose option  : ");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        if(ch>=0&&ch<x.size()){
            res=ch;
        }
    }
        return res;
    }
    public static Expense addExpense(ArrayList<User> x,User u){
        Scanner sc = new Scanner(System.in);
        Expense exp = new Expense();
        if(x.size()>0){
        System.out.println("Enter the name of Expense");
        exp.name = sc.nextLine();
        for(int i=0;i<x.size();i++){
            System.out.println(i+"-"+x.get(i).name);
        }
        System.out.println("Select the user : ");
        int ch = sc.nextInt();
        System.out.println("Enter the expense amount : ");
        int amount = sc.nextInt();
        if(ch>=0&&ch<x.size()&&amount>0){
            exp.fromuser = u;
            exp.touser = x.get(ch);
            exp.amount = amount;
        }
        else{
            exp.amount=-1;
        }
    }
    else{
        exp.amount = -2;
    }
        return  exp;
    }
    public static Expense expensepayup(ArrayList<Expense> expenses,User u){
        Scanner sc = new Scanner(System.in);
        Expense  exp = new Expense();
        Boolean b= false;
        for(int i=0;i<expenses.size();i++){
            if(expenses.get(i).touser.name.equals(u.name)){
                b=true;
            }
        }
        if(b){
        for(int i=0;i<expenses.size();i++){
            if(expenses.get(i).touser.name.equals(u.name)){
            System.out.println("Expense ID : "+i);
            System.out.println("Expense name : "+expenses.get(i).name);
            System.out.println("Expense Amount : "+expenses.get(i).amount);
            System.out.println("Payed By : "+expenses.get(i).fromuser.name);
            System.out.println("Owed By : "+expenses.get(i).touser.name);
            System.out.println("--------------------------------------------");
            }
        }
        System.out.println("Enter the ID of the Expense : ");
        int id = sc.nextInt();
        if(id>=0&&id<expenses.size()){
            exp=expenses.get(id);
        }
        else{
            exp.amount=-1;
        }
    }
    else{
        exp.amount=-2;
    }
    return  exp;
    }
    public static Group creategroup(ArrayList<User> x,User y){
        Group grup = new Group();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Group name : ");
        String name = sc.nextLine();
        grup.name = name;
        grup.friendsingroup.add(y);
        for(int i=0;i<x.size();i++){
                System.out.println(i+" __ "+x.get(i).name);
        }
        System.out.println("Enter the no.of friends need to be added : ");
        int nof = sc.nextInt();
        if(nof<=x.size()&&nof>0){
        System.out.println("Enter the users need to be added : ");
        for(int i=0;i<nof;i++){
            int k = sc.nextInt();
            for(int j=0;j<grup.friendsingroup.size();j++){
                if(!x.get(k).name.equals(grup.friendsingroup.get(j).name)){
                    grup.friendsingroup.add(x.get(k));
                }
            }
        }
        for(int i=0;i<grup.friendsingroup.size();i++){
        int c=0;
        for(int j=0;j<grup.friendsingroup.size();j++){
            if(grup.friendsingroup.get(i).name.equals(grup.friendsingroup.get(j).name)){
                c+=1;
            }
        }
        if(c>1){
            grup.friendsingroup.remove(i);
        }
    }
    for(int i=0;i<grup.friendsingroup.size();i++){
        System.out.println(grup.friendsingroup.get(i).name);
    }
}
    else{
        grup.name="request";
    }
        return grup;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        u1.name = "usera";
        u1.password ="aaaa";
        u1.wallet = 5000;
        u2.name = "userb";
        u2.password ="bbbb";
        u2.wallet = 7000;
        u3.name = "userc";
        u3.password ="cccc";
        u3.wallet = 2200;
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.get(0).friendslist.add(users.get(1));
        users.get(0).friendslist.add(users.get(2));
        users.get(1).friendslist.add(users.get(0));
        users.get(2).friendslist.add(users.get(0));
        Boolean whole_exit = false;
        while(!whole_exit){
            System.out.println("1-New User");
            System.out.println("2-Existing User");
            System.out.println("3-Exit");
            int ch = sc.nextInt();
            switch(ch){
                case 1:users.add(createuser());
                break;
                case 2 : int z = valid_user(users);
                if(z!=-1){
                    Boolean login_status=true;
                    while(login_status){
                       
                        System.out.println("1-Create Expense");
                        System.out.println("2-Show Expense");
                        System.out.println("3-Pay Up");
                        System.out.println("4-Create Group");
                        System.out.println("5-Add Members touser Group");
                        System.out.println("6-Add Expense To Group");
                        System.out.println("7-Show Group Stats");
                        System.out.println("8-Payup in Group");
                        System.out.println("9-Show friendslist");
                        System.out.println("10-Add friendsintolist");
                        System.out.println("11-Accept Friend Request");
                        System.out.println("12-Show Wallet Balance or update Wallet");
                        System.out.println("13-LogOut");
                        int choi = sc.nextInt();
                        switch(choi){
                            
                            case 1:Expense  exp = addExpense(users.get(z).friendslist,users.get(z));
                            if( exp.amount>0){
                                users.get(z).expenses.add( exp);
                                users.get(users.indexOf(exp.touser)).expenses.add(exp);
                            }
                            else if( exp.amount==-2){
                                System.out.println("You have no friends in friends list ,kindly add some");
                            }
                            else{
                                System.out.println("Invalid Options Entered");
                            }
                            break;
                            case 2:for(int i=0;i<users.get(z).expenses.size();i++){
                                System.out.println("Expense name : "+users.get(z).expenses.get(i).name);
                                System.out.println("Expense Amount : "+users.get(z).expenses.get(i).amount);
                                System.out.println("Paid By : "+users.get(z).expenses.get(i).fromuser.name);
                                System.out.println("past due By : "+users.get(z).expenses.get(i).touser.name);
                               
                            }
                            System.out.println("________________________________________");
                            break;
                            case 3:Expense payup = expensepayup(users.get(z).expenses,users.get(z));
                            if(payup.amount>0){
                                users.get(users.indexOf(payup.fromuser)).wallet+=payup.amount/2;
                                users.get(users.indexOf(payup.touser)).wallet-=payup.amount/2;
                                users.get(users.indexOf(payup.fromuser)).expenses.remove(payup);
                                users.get(users.indexOf(payup.touser)).expenses.remove(payup);
                                System.out.println("Payed Up Successfzly");
                            }
                            else if(payup.amount==-1){
                                System.out.println("Enter a valid ID");
                            }
                            else if(payup.amount==-2){
                                System.out.println("No Pay due needed");
                            }
                            System.out.println("________________________________________");
                            break;
                            case 4:Group grup = creategroup(users.get(z).friendslist,users.get(z));
                            if(!grup.name.equals("request")){
                            users.get(z).groups.add(grup);
                            for(int i=0;i<grup.friendsingroup.size();i++){
                                if(!grup.friendsingroup.get(i).name.equals(users.get(z).name)){
                                    users.get(users.indexOf(grup.friendsingroup.get(i))).groups.add(grup);
                                }
                            }
                            System.out.println("Group Created Successfzly");
                        }
                        System.out.println("________________________________________");
                            break;
                            case 5 : ArrayList<Integer> am = addmember(users.get(z));
                            if(am.get(0)!=-1){
                                for(int i=0;i<am.get(1);i++){
                                    users.get(z).groups.get(am.get(0)).friendsingroup.add(users.get(z).friendslist.get(am.get(i+2)));
                                }
                                int grupname=-1;
                                for(int i=0;i<am.get(1);i++){
                                    for(int j=0;j<users.size();j++){
                                        if(users.get(j).name.equals(users.get(z).friendslist.get(am.get(i+2)).name)){
                                        grupname = j;
                                        }
                                    }
                                    users.get(grupname).groups.add(users.get(z).groups.get(am.get(0)));
                                    System.out.println(users.get(grupname).name);
                                }
                            }
                            System.out.println("________________________________________");
                            break;
                            case 6:
                            GroupExpense age = new GroupExpense();
                            for(int i=0;i<users.get(z).groups.size();i++){
                                System.out.println(i+"-"+users.get(z).groups.get(i).name);
                            }
                            System.out.println("Choose the Group : ");
                            int ageo = sc.nextInt();
                            System.out.println("Enter the expense name : ");
                            age.name = sc.next();
                            System.out.println("Enter the expense amount : ");
                            age.amount = sc.nextInt();
                            age.fromuser = users.get(z);
                            for(int i=0;i<users.get(z).groups.get(ageo).friendsingroup.size();i++){
                                age.touser.add(users.get(z).groups.get(ageo).friendsingroup.get(i));
                            }
                            age.touser.remove(users.get(z));
                            if(age.amount!=-1){
                                users.get(z).groups.get(ageo).groupexpenses.add(age);
                            }
                            System.out.println("________________________________________");
                            break;
                            case 7:
                            for(int i=0;i<users.get(z).groups.size();i++){
                                System.out.println("Group name : "+users.get(z).groups.get(i).name);
                                for(int j=0;j<users.get(z).groups.get(i).groupexpenses.size();j++){
                                    System.out.println("Expense name : "+users.get(z).groups.get(i).groupexpenses.get(j).name);
                                    System.out.println("Expense Amount : "+users.get(z).groups.get(i).groupexpenses.get(j).amount);
                                    System.out.println("Paid By : "+users.get(z).groups.get(i).groupexpenses.get(j).fromuser.name);
                                    for(int k=0;k<users.get(z).groups.get(i).groupexpenses.get(j).touser.size();k++){
                                        System.out.println("past due By : "+users.get(z).groups.get(i).groupexpenses.get(j).touser.get(k).name);
                                    }
                                    for(int k=0;k<users.get(z).groups.get(i).groupexpenses.get(j).completed.size();k++){
                                        System.out.println("completed due : "+users.get(z).groups.get(i).groupexpenses.get(j).completed.get(k).name);
                                    }
                                    System.out.println("________________________________________");
                                }
                                System.out.print("Group Members : ");
                                for(int j=0;j<users.get(z).groups.get(i).friendsingroup.size();j++){
                                    System.out.print(users.get(z).groups.get(i).friendsingroup.get(j).name);
                                }
                                System.out.println();
                            }
                            System.out.println("________________________________________");
                            break;
                            case 8:for(int i=0;i<users.get(z).groups.size();i++){
                                System.out.println(i+"-"+users.get(z).groups.get(i).name);
                            }
                            float pa=0;
                            int pg = sc.nextInt();
                            for(int i=0;i<users.get(z).groups.get(pg).groupexpenses.size();i++){
                                if(!users.get(z).groups.get(pg).groupexpenses.get(i).fromuser.equals(users.get(z))){
                                    Boolean b = true;
                                    for(int j=0;j<users.get(z).groups.get(pg).groupexpenses.get(i).completed.size();j++){
                                        if(users.get(z).groups.get(pg).groupexpenses.get(i).completed.get(j).equals(users.get(z))){
                                            b=false;
                                        }
                                    }
                                    if(b){
                                    System.out.println(i+"-"+users.get(z).groups.get(pg).groupexpenses.get(i).name);
                                }
                                }
                            }
                            System.out.println("Choose the expense : ");
                            int pe  = sc.nextInt();
                            pa=(float)users.get(z).groups.get(pg).groupexpenses.get(pe).amount/(users.get(z).groups.get(pg).groupexpenses.get(pe).touser.size()+1);
                            if(pa>0){
                                System.out.println("0-Wallet payment ");
                                System.out.println("1-pay later");
                                int uuc = sc.nextInt();
                                if(uuc==0){
                                    if(users.get(z).wallet>pa){
                                        System.out.println(users.get(z).wallet);
                                        System.out.println(pa);
                                        users.get(z).wallet-=pa;
                                        users.get(z).groups.get(pg).groupexpenses.get(pe).completed.add(users.get(z));
                                        users.get(z).groups.get(pg).groupexpenses.get(pe).fromuser.wallet+=pa;
                                    }
                                    else{
                                        System.out.println("Insuffiecient Balance");
                                    }
                                }   
                            }
                            System.out.println("________________________________________");
                            break;
                            case 9:for(int i = 0;i<users.get(z).friendslist.size();i++){
                                System.out.println(users.get(z).friendslist.get(i).name);
                            }
                            break;
                            case 10:int af = addfriendsintolist(users,users.get(z).friendslist,z);
                            if(af!=-1){
                                users.get(af).requests.add(users.get(z));
                                System.out.println("Friend Request has been sent");
                            }
                            else{
                                System.out.println("Choose a valid option");
                            }
                            break;
                            case 11:int ar = acceptfriendsreq(users.get(z).requests);
                            if(ar!=-1){
                                int en = -1;
                                users.get(z).friendslist.add(users.get(z).requests.get(ar));
                                for(int i=0;i<users.size();i++){
                                    if(users.get(z).requests.get(ar).name.equals(users.get(i).name)){
                                        en = i;
                                    }
                                }
                                users.get(en).friendslist.add(users.get(z));
                                users.get(z).requests.remove(users.get(en));
                                System.out.println("Accepted Friend Request");
                            }
                            else{
                                System.out.println("Enter a valid number");
                            }
                            System.out.println("________________________________________");
                            break;
                            case 12:System.out.println("Enter 0 for check wallet balance\nEnter 1 for add wallet balance\nEnter 2 for deduce wallet balance");
                            int w=sc.nextInt();
                            if(w==0){
                                System.out.println("Available Balance is : "+users.get(z).wallet);
                            System.out.println("________________________________________");

                            }
                            else if(w==1){
                                int amount = addwallet();
                            if(amount>0){
                                users.get(z).wallet+=amount;
                            }
                            System.out.println("wallet balance is : "+users.get(z).wallet);
                            System.out.println("________________________________________");
                            }
                            else if(w==2){
                                int amount = addwallet();
                            if(amount>0){
                                users.get(z).wallet-=amount;
                            }
                            System.out.println("wallet balance is : "+users.get(z).wallet);
                            System.out.println("________________________________________");
                            
                            }
                            else{
                                System.out.println("Enter valid option");
                            }
                            
                            break;
                            
                            case 13:login_status = false;
                            break;
                            default : System.out.println("Enter a valid Option"); 
                        }
                    }
                }
                break;
                case 3 : whole_exit = true;
                break;
                default : System.out.println("Enter a valid option");
            }
        }
        System.out.println("Share love : share happiness");
    }
}
