import java.util.*;
class User{
    String name;
    String password;
    ArrayList<HashMap<String,String>> Orders = new ArrayList<>();
    ArrayList<HashMap<String,String>> cart = new ArrayList<>();
    public static ArrayList<String> addtocart(ArrayList<Merchant> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            if(x.get(i).approval){
                for(int j=0;j<x.get(i).products.size();j++){
                    System.out.println(i+""+j+"-"+x.get(i).products.get(j));
                }
            }
        }
        System.out.println("Enter Your choice : ");
        String c = sc.next();
        int f=Character.getNumericValue(c.charAt(0));
        int s=Character.getNumericValue(c.charAt(1));
        if((f<x.size())&&(f>=0)&&(s<x.get(f).products.size())&&(s>=0)){
            ans.add(Integer.toString(f));
            ans.add(Integer.toString(s));
            return ans;
        }
        else{
            ans.add(null);
            return ans;
        }
        
    }
    public static ArrayList<String> buyfromcart(ArrayList<HashMap<String,String>> x){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<x.size();i++){
            System.out.println(i+"-"+x.get(0));
        }
        System.out.println("Enter Your choice : ");
        int c = sc.nextInt();
        if((c<x.size())&&(c>=0)){
            ans.add(Integer.toString(c));
            ans.add(x.get(c).toString());
            return ans;
        }
        else{
            ans.add(null);
            return ans;
        }
        
    }
}

class Merchant{
    String password;
    String name;
    ArrayList<HashMap<HashMap<String,String>,String>> SalesReport = new ArrayList<>();
    ArrayList<HashMap<String,String>> products = new ArrayList<>();
    Boolean approval =false;
    public static HashMap<String,String> addprod(ArrayList<String> ct,String x){
        Scanner sc =new Scanner(System.in);
        HashMap<String,String> res =new HashMap<>();
        System.out.println("Enter the category:");
        for (int i=0;i<ct.size();i++){
            System.out.println(i+" - " +ct.get(i));
        }
        int ch=sc.nextInt();
        res.put("Merchant=",x);
        System.out.println("enter price :");
        String price=sc.next();
        res.put("price",price);
        System.out.println("Enter product name :");
        String name=sc.next();
        res.put("name",name);
        res.put("category",ct.get(ch));
        return res;
    }
    public static ArrayList<String> updprod(ArrayList<HashMap<String,String>> p){
        Scanner sc =new Scanner(System.in);
        ArrayList<String> res =new ArrayList<>();
        for(int i=0;i<p.size();i++){
            System.out.println(i+" - "+p.get(i));
        }
        System.out.println("What need to be updates :");
        int pro=sc.nextInt();
        res.add(Integer.toString(pro));
        System.out.println("0-name");
        System.out.println("1-price");
        int cho=sc.nextInt();
        switch(cho){
            case 0:res.add("name");
            break;
            case 1:res.add("price");
            break;
            default:res.add(null);
        }
        System.out.println("Enter what need to be updated ");
        String v=sc.next();
        res.add(v);
        return res;      
    }    
}

class Admin{
    String password;
    String name;
    public static int findingmerchant(ArrayList<Merchant> x, String add){
        Scanner sc = new Scanner(System.in);
        int i=-1;
        for(int j=0;j<x.size();j++){
            System.out.println(j+" - "+x.get(j).name);
        }
        System.out.println("Enter the merchant to be "+add);
        i=sc.nextInt();
        if((i<x.size()) && (i>=0))
            return i;
        else
            return -1;
    }

    
    public static int approvemerchant(ArrayList<Merchant> x,String add){
        Scanner sc = new Scanner(System.in);
        int i=-1;
        int c=0;
        for(int v=0;v<x.size();v++){
            if(!x.get(v).approval){
            System.out.println(v+"-"+x.get(v).name);
            c+=1;
            }
        }
        if(c>0){
        System.out.println("Enter the merchant You Want To "+add);
        i=sc.nextInt();
        if((i<x.size())&&(i>=0)){
            return i;
        }
        else{
            return -1;
        }
    }else{
        return -1;
    }
}

    public static ArrayList<String> viewcat(ArrayList<String> x){
        Scanner sc=new Scanner(System.in);
        String addcate = sc.nextLine();
        x.add(addcate);
        return x;
    }

}

public class Main{
    public static User createuser(){
        Scanner sc = new Scanner(System.in);
        User x =new User();
        System.out.print("Enter Your name : ");
        x.name = sc.next();
        System.out.println("Enter Your Password : ");
        x.password = sc.next();
        return x;
}

public static Merchant createmerchant(){
    Scanner sc = new Scanner(System.in);
    Merchant x =new Merchant();
    System.out.print("Enter Your name : ");
    x.name = sc.next();
    System.out.println("Enter Your Password : ");        
    x.password = sc.next();
    x.approval=false;
    return x;
}
 public static int adminlogin(ArrayList<Admin> x){
        int val=-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter password : ");
        String password = sc.next();
        for(int i=0;i<x.size();i++){
            if((x.get(i).name.equals(name))&&(x.get(i).password.equals(password))){
                val=i;
            }
        }
        return val;
    } 
    public static int merchantlogin(ArrayList<Merchant> x){
        int val=-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter password : ");
        String password = sc.next();
        for(int i=0;i<x.size();i++){
            if((x.get(i).name.equals(name))&&(x.get(i).password.equals(password))){
                val=i;
                }
            }
        return val;
        
    } 
   public static int userlogin(ArrayList<User> x){
        int val=-1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name : ");
        String name = sc.next();
        System.out.println("Enter password : ");
        String password = sc.next();
        for(int i=0;i<x.size();i++){
            if((x.get(i).name.equals(name))&&(x.get(i).password.equals(password))){
                val=i;
            }
        }
        return val;
    } 

    public static void main(String[] args) {
        ArrayList<String> category = new ArrayList<>();
        category.add("Electronics");
        category.add("Books");
        Scanner sc = new Scanner(System.in);
        Merchant m1 = new Merchant();
        Merchant m2 =new Merchant();
        Admin a1 = new Admin();
        Admin a2 = new Admin();
        ArrayList<Admin> admins= new ArrayList<>();
        a1.name="admin1";
        a1.password="111";
        a2.name="admin2";
        a2.password="222";
        admins.add(a1);
        admins.add(a2);
        ArrayList<Merchant> merchant_list = new ArrayList<>();
        merchant_list.add(m1);
        merchant_list.add(m2);
        m1.name="apple";
        m1.password="aaaa";                //merchant apple is approved by default but merchant samsung is not approved by default.
        m1.approval=true;
        m2.name="samsung";
        m2.password="ssss";
        HashMap<String,String> x = new HashMap<>();
        x.put("name", "rog");
        x.put("price","20000");
        x.put("category", "Electronics");
        x.put("Merchant","apple");
        HashMap<String,String> y = new HashMap<>();
        y.put("name", "vivobook");
        y.put("price","15000");
        y.put("category", "Electronics");
        y.put("Merchant","samsung");
        m1.products.add(x);
        m2.products.add(y);
        ArrayList<String> categ =new ArrayList<>();
        ArrayList<User> users =new ArrayList<>();
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        u1.name = "usera";
        u1.password = "aaaa";
        users.add(u1);
        u2.name = "userb";
        u2.password = "bbbb";
        users.add(u2);
        u3.name = "userc";
        u3.password = "cccc";
        users.add(u3);

        Boolean whole_exit_status=false;
        while(!whole_exit_status){
            System.out.println("1-Admin");
            System.out.println("2-Merchant");
            System.out.println("3-User");
            System.out.println("4-Exit");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                int i=adminlogin(admins);
                if(i!=-1){
                    Boolean admin_exit_status=false;
                    while(!admin_exit_status){
                        System.out.println("1-Approve merchants");
                        System.out.println("2-Remove merchants");
                        System.out.println("3-View Products");
                        System.out.println("4-Add category");
                        System.out.println("5-Exit");
                        System.out.println("Enter Your Choice : ");
                        int ch=sc.nextInt();
                        switch(ch){
                            case 1:int apm =admins.get(i).approvemerchant(merchant_list,"Approve");
                        if((apm!=-1)&&(!merchant_list.get(apm).approval)){
                            merchant_list.get(apm).approval=true;
                        }
                        else{
                            System.out.println("Merchant Already Approved or Invalid Option");
                        }
                    
                            break;
                            case 2: int merrem=admins.get(i).findingmerchant(merchant_list,"Removed");
                            if(merrem!=-1){
                                merchant_list.remove(merrem);
                            } 
                            break;
                            case 3: for(int p=0;p<merchant_list.size();p++){
                                System.out.println(merchant_list.get(p).products);
                            }
                            break;
                            case 4:
                            System.out.println(admins.get(i).viewcat(category));
                            break;

                            case 5: admin_exit_status=true;
                            break;
                            default:System.out.println("Enter valid choice");
                        }
                    }
                }
                else{
                    System.out.println("Enter valid choice");
                }
                break;
                case 2:
                System.out.println("1-New Merchant");
                System.out.println("2-Existing Merchant");
                System.out.println("3-Exit");
                System.out.println("Enter Your Choice : ");
                int mo =sc.nextInt();
                switch(mo){
                    
                    case 1:merchant_list.add(createmerchant());
                    System.out.println("Registered Successfully");
                    System.out.println("--Waiting For Approval--");
                    break;
                    case 2:int m =merchantlogin(merchant_list);
                    if(m!=-1){
                    Boolean merchant_exit_status = false;
                    while(!merchant_exit_status){
                        System.out.println("1-Add products");
                        System.out.println("2-Update products");
                        System.out.println("3-View Most Sold Products");
                        System.out.println("4-View sales report");
                        System.out.println("5-Exit");
                        System.out.println("Enter Your Choice : ");
                        int ch=sc.nextInt();
                        switch(ch){
                            case 1:
                            HashMap<String,String> np = merchant_list.get(m).addprod(category,merchant_list.get(m).name);
                            merchant_list.get(m).products.add(np);
                            System.out.println("product approved");
                            break;
                            case 2:ArrayList<String> updp = merchant_list.get(m).updprod(merchant_list.get(m).products);
                            if(updp.get(0)!=null){
                                merchant_list.get(m).products.get(Integer.parseInt(updp.get(0))).replace(updp.get(1),updp.get(2));
                            } 
                            break;
                            case 3:System.out.println(merchant_list.get(m).products);
                            break;
                            case 4:System.out.println(merchant_list.get(m).SalesReport);
                            break;
                            case 5:merchant_exit_status=true;
                            break;
                            default:System.out.println("Enter valid choice");
                        }
                    }
                }
            }
            break;
                case 3:
                System.out.println("1-New User");
                System.out.println("2-Existing User");
                System.out.println("3-Exit");
                System.out.println("Enter Your Choice : ");
                int ch =sc.nextInt();
                switch(ch){
                    case 1:
                    users.add(createuser());
                    System.out.println("Registered Successfully");
                    case 2:int u = userlogin(users);
                    if(u!=-1){
                    Boolean user_exit_status = false;
                    while(!user_exit_status){
                        System.out.println("1-View products");
                        System.out.println("2-Add to cart");
                        System.out.println("3-Buy From cart");
                        System.out.println("4-My Orders");
                        System.out.println("5-Exit");
                        System.out.println("Enter Your Choice : ");
                        int cho = sc.nextInt(); 
                        switch(cho){
                            case 1:for(int j =0;j<merchant_list.size();j++){
                                
                                if(merchant_list.get(j).approval){
                                
                                    System.out.println(merchant_list.get(j).products);
                                }
                            }
                            break;
                            case 2:ArrayList<String> atoc = users.get(u).addtocart(merchant_list);
                            if(atoc.get(0)!=null){
                                users.get(u).cart.add(merchant_list.get(Integer.parseInt(atoc.get(0))).products.get(Integer.parseInt(atoc.get(1))));
                            }
                            break;
                            case 3:ArrayList<String> buyfromcart = users.get(u).buyfromcart(users.get(u).cart);
                            if(buyfromcart!=null){
                                users.get(u).Orders.add(users.get(u).cart.get(Integer.parseInt(buyfromcart.get(0))));
                                int tm=-1;
                                for(int fm =0;fm<merchant_list.size();fm++){
                                    if (users.get(u).Orders.get(users.get(u).Orders.size()-1).get("Merchant")==merchant_list.get(fm).name){
                                        tm=fm;
                                    }
                                }
                                HashMap<String,String> cv = users.get(u).Orders.get(users.get(u).Orders.size()-1);
                                HashMap<HashMap<String,String>,String> sr = new HashMap<>();
                                sr.put(cv,users.get(u).name);
                                merchant_list.get(tm).SalesReport.add(sr);
                            }
                            break;
                            case 4:System.out.println(users.get(u).Orders);
                            break;
                            case 5:user_exit_status=true;
                            break;
                            default:System.out.println("Enter valid choice");
                        }

                }
            }
        }
        break;
                case 4: whole_exit_status=true;
                break;
                default:System.out.println("Enter a valid choice");
            }
        }
    }
}
