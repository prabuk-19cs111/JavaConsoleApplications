import java.util.*;
class User{
    String name;
    String password;
    int amount;
    ArrayList<Contact>grouplistx = new ArrayList<>();
    
}
class Contact{
    String name;
    int amountneedtobepaid;
    ArrayList<String> contact_list = new ArrayList<>();

}
class Splitwise{
    static Scanner sc = new Scanner(System.in);
    public static User createuser(){
        User x = new User();
        System.out.println("Enter your mailid : ");
        x.name = sc.next();
        System.out.println("Enter password : ");
        x.password = sc.next();
        System.out.println("Enter  wallet amount : ");
        x.amount = sc.nextInt();
        return x;
    }
    public static int valid_user(ArrayList<User> x){
        int val = -1;
        System.out.println("Enter your name : ");
        String name = sc.next();
        System.out.println("Enter your name : ");
        String password = sc.next();
        for(int i=0;i<x.size();i++){
            if(x.get(i).name.equals(name) && x.get(i).password.equals(password)){
                val = i;
            }
        }
        return val;

    }
    public static void main(String[] args) {
    ArrayList<User> users = new ArrayList<>();
        User a = new User();
        User b = new User();
        a.name = "user1";
        a.password = "1111";
        a.amount = 50000;
        b.name = "user2";
        b.password = "2222";
        b.amount = 70000;
        users.add(a);
        users.add(b);
        ArrayList<Contact> contact_list = new ArrayList<>();
        Contact c1 = new Contact();
        Contact c2 = new Contact();
        Contact c3 = new Contact();
        Contact c4 = new Contact();
        Contact c5 = new Contact();
        
        c1.name = "contact1";
        c1.amountneedtobepaid = 0;
        c2.name = "contact2";
        c2.amountneedtobepaid = 0;
        c3.name = "contact3";
        c3.amountneedtobepaid = 0;
        c4.name = "contact4";
        c4.amountneedtobepaid = 0;
        c5.name = "contact5";
        c5.amountneedtobepaid = 0;
        
        contact_list.add(c1);
        contact_list.add(c2);
        contact_list.add(c3);
        contact_list.add(c4);
        contact_list.add(c5);
    
        ArrayList<Contact> newgroup = new ArrayList<>();
        ArrayList<HashMap<String,String>> transaction_list = new ArrayList<>();
        Boolean whole_exit = false;
        while (!whole_exit){
            System.out.println("1.New User");
            System.out.println("2.Existing User");
            System.out.println("3.Exit");
            System.out.println("Enter your choice : ");
            int loginchoice = sc.nextInt();
            switch (loginchoice){
                case 1: {
                    users.add(createuser());
                    System.out.println("New User Created Successfully");
                }
                    break;
                case 2:{
                    int u = valid_user(users);
                    if(u != -1){
                        Boolean user_exit = false;
                        while (!user_exit){
                            System.out.println("1.Add an Expense");
                            System.out.println("2.Update their Wallet Amount");
                            System.out.println("3.Add Friends into the Group");
                            System.out.println("4.remove Friends into the Group");
                            System.out.println("5.View and pay Pending Dues");
                            System.out.println("6.View their Transaction History");
                            System.out.println("7.LogOut");
                            System.out.println("Enter your choice : ");
                            int userchoice = sc.nextInt();
                            switch (userchoice){
                                case 1:{
                                    System.out.println("Enter the name of the expense");
                                    String expname = sc.next();
                                    System.out.println("Enter the total expense amount");
                                    int expamount = sc.nextInt();
                                    users.get(u).amount=users.get(u).amount-expamount;
                                    System.out.println("Enter the type\n"+"1.Non Group Expense\n"+"2.Group Expense\n"+"3.Exit");
                                    int echoice = sc.nextInt();
                                    if(echoice == 1) {

                                        HashMap<String, String> y = new HashMap<>();
                                        for (int i = 0; i < contact_list.size(); i++) {
                                            System.out.println((i+1) + "." + contact_list.get(i).name);
                                        }
                                        System.out.println("Select the contact you need to add expense : ");
                                        int select_contact = sc.nextInt();
                                        if (select_contact <= contact_list.size()) {
                                            contact_list.get(select_contact).amountneedtobepaid += expamount / 2;
                                            y.put("name", expname);
                                            y.put("contact", contact_list.get(select_contact).name);
                                            y.put("amount", Integer.toString(expamount / 2));
                                            transaction_list.add(y);
                                            System.out.println(transaction_list);
                                        }
                                    }
                                        else{
                                            System.out.println("Enter 0 for existing group");
                                            System.out.println("Enter 1 for creating a new group");
                                            int c=sc.nextInt();
                                            if(c==0){
                                           
                                            for(int i=0;i<users.get(u).grouplistx.size();i++){
                                                HashMap<String,String> y = new HashMap<>();
                                                users.get(u).grouplistx.get(i).amountneedtobepaid+=expamount/users.get(u).grouplistx.size();
                                                y.put("name",expname);
                                                y.put("contact",users.get(u).grouplistx.get(i).name);
                                                y.put("amount",Integer.toString(expamount/users.get(u).grouplistx.size()));
                                                transaction_list.add(y);
                                            }
                                        System.out.println(transaction_list);
                                        }
                                        else{
                                            if(users.get(u).grouplistx.size()!=0){
                                                for(int i=0;i<contact_list.size();i++){
                                                    Boolean h =true;
                                                for(int k=0;k<users.get(u).grouplistx.size();k++){
                                                    if(contact_list.get(i).name.equals(users.get(u).grouplistx.get(k).name)){
                                                        h=false;
                                                   }
                                                     }
                                                if(h){System.out.println((i+1)+ " . "+contact_list.get(i).name);}
                                                  }
                                            }
                                            else{
                                                for(int i=0;i<contact_list.size();i++){
                                                System.out.println((i+1)+ " . "+contact_list.get(i).name);
                                                       }
                                              }
                                            System.out.println("Number of contacts to be grouped");
                                            int n=sc.nextInt();
                                            System.out.println("Select contacts to be grouped");
                                            int[] arr= new int[n];
                                            for(int k=0;k<n;k++){
                                                arr[k]=sc.nextInt();
                                                
                                            }
                                            for(int k=0;k<n;k++){
                                    
                                                users.get(u).grouplistx.add(contact_list.get(arr[k]));
                                                
                                            }
                                            for(int i=0;i<users.get(u).grouplistx.size();i++){
                                                System.out.println((i+1)+ " . "+users.get(u).grouplistx.get(i).name);
                                            }
                                            System.out.println(users.get(u).grouplistx);
                                             
                                            for(int i=0;i< users.get(u).grouplistx.size();i++){
                                                HashMap<String,String> y = new HashMap<>();
                                                users.get(u).grouplistx.get(i).amountneedtobepaid+=expamount/users.get(u).grouplistx.size();

                                                y.put("name",expname);
                                                y.put("contact", users.get(u).grouplistx.get(i).name);
                                                y.put("amount",Integer.toString(expamount/users.get(u).grouplistx.size()));
                                                transaction_list.add(y);
                                            }
                                            System.out.println(transaction_list); }
                                        }
                                    }
                                    break;
                                    case 2: System.out.println(" Enter 1 for add money to wallet\n Enter 2 for deduce money from wallet\n Enter 3 for view balance\n Enter 0 for exit\n");
                                        int ch=sc.nextInt();
                                        if(ch==1){
                                            System.out.println("Enter amount to be added  ");
                                            int ad=sc.nextInt();
                                            users.get(u).amount=users.get(u).amount+ad;
                                        }
                                        else if(ch==2){
                                            System.out.println("Enter amount to be deduce  ");
                                            int ad=sc.nextInt();
                                            users.get(u).amount=users.get(u).amount-ad;
                                        }
                                        else if(ch==3){
                                            System.out.println(users.get(u).amount);
                                          
                                        }
                                        else if(ch==0){
                                            break;
                                        }
                                        else{
                                            System.out.println("Enter valid amount");
                                        }

                                    

                                    break;

                                    case 3:if(users.get(u).grouplistx.size()!=0){
                                        for(int i=0;i<contact_list.size();i++){
                                            Boolean h =true;
                                        for(int k=0;k<users.get(u).grouplistx.size();k++){
                                            if(contact_list.get(i).name.equals(users.get(u).grouplistx.get(k).name)){
                                                h=false;
                                           }
                                             }
                                        if(h){System.out.println((i+1)+ " . "+contact_list.get(i).name);}
                                          }
                                    }
                                    else{
                                        for(int i=0;i<contact_list.size();i++){
                                        System.out.println((i+1)+ " . "+contact_list.get(i).name);
                                               }
                                      }
                                    System.out.println("Number of contacts to be grouped");
                                    int n=sc.nextInt();
                                    System.out.println("Select contacts to be grouped");
                                    int[] arr= new int[n];
                                    for(int k=0;k<n;k++){
                                        arr[k]=sc.nextInt();
                                        
                                    }
                                    for(int k=0;k<n;k++){
                            
                                        users.get(u).grouplistx.add(contact_list.get(arr[k]));
                                        
                                    }
                                    for(int i=0;i<users.get(u).grouplistx.size();i++){
                                        System.out.println((i+1)+ " . "+users.get(u).grouplistx.get(i).name);
                                    }
                                 break; 
                                 case 4 :  for(int i=0;i<users.get(u).grouplistx.size();i++){
                                    System.out.println("Refer code :"+(i+1)+ " for "+users.get(u).grouplistx.get(i).name);
                                 }
                                    System.out.println("Number of contacts to be deleted from group");
                                    int rn=sc.nextInt();
                                    System.out.println("select contact to be deleted from group");
                                    int[] ar= new int[rn];
                                    for(int k=0;k<rn;k++){
                                        ar[k]=sc.nextInt();
                                        
                                    }
                                    for(int k=0;k<rn;k++){
                                        users.get(u).grouplistx.remove(contact_list.get(ar[k]));
                                        
                                    }
                                    for(int c=0;c<users.get(u).grouplistx.size();c++){
                                        System.out.println((c+1)+ " . "+users.get(u).grouplistx.get(c).name);
                                    }
                         break; 
                         case 5:for(int i=0;i<contact_list.size();i++){
                            System.out.println(contact_list.get(i).name+" pay due "+contact_list.get(i).amountneedtobepaid);
                        }
                        break;

                     case 6:System.out.println(transaction_list);
                      break;

                      case 7:user_exit=true;
                      break;
                             }
                        }
                    }
                }
                case 3:whole_exit=true;
                break;
            }
        }

    }
}
