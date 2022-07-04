 package  BankingSystem;
 import  BankingSystem.user;
 import java.util.*;
 import java.io.*;

 /**
  * *Create Acount
  *send money
  *Add Balence
  *Check Balence
  *Withdraw Money
  *Delete Account
  **/
public class Bank{
    private HashMap<Integer,user> users;
    Bank(){
        users = new HashMap<>();

    }
    public boolean adduser(int id,String password){
     user newuser= new user(id,password);
     if(users.containsKey(id)){
          System.out.println("user already exist");
          return false;
     }
     else{
          users.put(id,newuser);
          return true;
     }

    }
    public void sendMoney( int senderId, int receiverId,double amount){
     if(users.containsKey(senderId)){
        user sender=users.get(senderId);
        if(sender.getBalance()>=amount){
           System.out.print("tansfering money......");
           user receiver = users.get(receiverId);
           sender.setBalance(sender.getBalance()-amount);
           receiver.setBalance(receiver.getBalance()+amount);

           System.out.println("Transeferred money Successfully");
           System.out.printf("Your new balance is : %d\n", sender.getBalance());
        }
        else 
        System.out.print("Doesn't have enough amount");
     }
     else
       System.out.print("account doesn't exist.");
    }
    public void addMoney(int id,double amount){
        if(users.containsKey(id)){
            user user=users.get(id);
            user.addMoney(amount);
            System.out.println(amount+ " "+ "rs. deposite to your account");
            System.out.println("now your balance is"+user.getBalance());
            System.out.println();
        }
        else
          System.out.println("user doesn't exist");
    }
    public void withdrawMoney(int id,int amount){
        if(users.containsKey(id)){
            user user=users.get(id);
           if(user.getBalance()>=  amount){
           user.setBalance(user.getBalance()-amount);
            System.out.println(amount+" Rs. withdraw from your account");;
            System.out.println("Now your current balance is"+user.getBalance());}
            else
            System.out.println("doesn't have enough amount");
        }
        else
          System.out.println("user doesn't exist");

    }
    public boolean verifyCredentials(int id,String password){
        user user=users.get(id);
        return user.verifyPassword(password);
    }
    public void checkBalance(int id){
        user user=users.get(id);
        System.out.println("Your current balance is " + user.getBalance());
    }
    public void deleteaccount(int id){
        users.remove(id);
    }
    
}