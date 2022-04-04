/* Abednego Njike, Zachary Bazzle, & David Blaine */
import java.util.ArrayList;
public class Accounts
{
 private ArrayList<Account> _accounts = new ArrayList<Account>();

 public Accounts(ArrayList<Account> _accounts)
 {
   this._accounts = _accounts;
 }

 public boolean has(String CreditCardNum)
 {
   for(Account item : _accounts)
   {
     if(item.getCreditCardNum() == CreditCardNum)
     return true;
   }
   return false;
 }

 public Account getAccount(String CreditCardNum)
 {
   for(Account item : _accounts)
   if(item.getCreditCardNum() == CreditCardNum)
   return item;
   else
   {
   System.out.println("Account not found");
   }
   return null;
 }
 public void addAccount(Account item)
 {
   _accounts.add(item);
 }
}