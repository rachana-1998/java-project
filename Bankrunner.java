package BankingSystem;
import java.util.*;
import java.io.*;
public class Bankrunner {
   
    public static void main(String[] args) {
        Bank bank=new Bank();
        System.out.println("welcome to my Bank");
        int optionnumber;
        do{
            System.out.println("choose the option");
        System.out.println("1. Create an account");
        System.out.println("2. Send Money");
        System.out.println("3. Add Balance");
        System.out.println("4. check Balance");
        System.out.println("5. Delete account");
        System.out.println("8. Exit");

        Scanner sc=new Scanner(System.in);
        int id;
        String password;
        optionnumber=sc.nextInt();
        switch(optionnumber){
            case 1:
             System.out.print("Enter Your Id:");
              id=sc.nextInt();
             System.out.print("Enter password:");
             password=sc.next();
                bank.adduser(id,password);
                break;
            case 2:
             System.out.print("Enter Your Id:");
            int senderId=sc.nextInt();
             System.out.print("Enter Password:");
               password=sc.next();
              boolean loggedIn=bank.verifyCredentials(senderId,password);
            if(loggedIn){
               int receiverId=sc.nextInt();
               double amountTotransfer=sc.nextDouble();
               bank.sendMoney(senderId, receiverId, amountTotransfer);
               System.out.println("Transferred");
            }
            else{
                System.out.println("Bad Credentials :(");
            }
             break;
            case 3:
            System.out.print("Enter Your Id:");
             id=sc.nextInt();
             System.out.print("Enter Password:");
               password=sc.next();
                loggedIn=bank.verifyCredentials (id,password);
               
                if(loggedIn){
                    System.out.println("Enter amount to deposite");
                    double amount=sc.nextDouble();
                    bank.addMoney(id,amount);
                }
                else{
                   
                    System.out.println("Bad Credentials");
                }
                break;
            case 4:
            System.out.print("Enter Your Id:");
          id=sc.nextInt();
             System.out.print("Enter Password:");
               password=sc.next();
               loggedIn=bank.verifyCredentials( id,password);
               if(loggedIn){
                bank.checkBalance(id);
               }
               else{
                   
                System.out.println("Bad Credentials");
            }
                break;  
             case  5:
             System.out.print("Enter your ID");
             id=sc.nextInt();
             System.out.print("Enter your password");
             password=sc.next();
             System.out.print("Enter amount to withdraw");
             int amount=sc.nextInt();
             loggedIn=bank.verifyCredentials( id,password);
             if(loggedIn){
                bank. withdrawMoney(id,amount);
               }
               else{   
                System.out.println("Bad Credentials");
            }
            break;
            case 6:
            System.out.print("Enter ID to be Deleted");
            id=sc.nextInt();
             bank.deleteaccount(id);
             break;
            case 8:
                 System.out.println("BYE ):");
                 break;
            default:
                    break;
        }
        }
        while(optionnumber!=8);
        
           
        }
}
