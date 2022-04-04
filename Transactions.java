/* Abednego Njike, Zachary Bazzle, & David Blaine */
import java.util.ArrayList;
public class Transactions{

 private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

public Transactions(ArrayList<Transaction> transactions){
this.transactions = transactions;
}

public void add(Transaction tran){
transactions.add(tran);
}
 
public void reset(){
transactions.get(0);
}

public boolean has(String CreditCardNum){
for(Transaction item : transactions)
{
  if(item.getCCN() == CreditCardNum)
  return true;
}
return false;
}

public Transaction get(String CreditCardNum){
for(Transaction item : transactions)
{
  if(item.getCCN() == CreditCardNum)
  {
    return item;
  }
}
return null;
}

}