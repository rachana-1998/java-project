package BankingSystem;

public class user {
  private int id;
  private String password;
  private  String Mobilenum;
  private double balance;
  user(int id,String password){
    this.id=id;
    this.password=password;
    this.balance=500;
  }   
  public int getid(){
    return this.id;
  }
  public String getpassword(){
    return this.password;
  }
  public void setMobilenum(String Mobilenum){
    this.Mobilenum=Mobilenum;
  }
  public String getMobilenum(){
    return this.Mobilenum;
  }
  public void setBalance(double balance){
    this.balance=balance;
  }
  public double getBalance(){
    return this.balance;
  }
  public boolean verifyPassword(String password){
    return this.password.equals(password);
  }
  public void addMoney(double amount){
    this.balance+=amount;
  }
   
}
