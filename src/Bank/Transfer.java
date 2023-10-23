package Bank;

public class Transfer extends Transaction
{
    private String sender;
    private String recipient;

    public Transfer(String date, double amount, String description, String sender, String recipient)
    {
        super(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }

    public Transfer(Transfer copy)
    {
        this(copy.getDate(), copy.getAmount(), copy.getDescription(), copy.getSender(), copy.getRecipient());
    }

    //getter/setter

   public void setAmount(Double a)
    {
        if(a <= 0) System.out.println("Negative Transfer?");
        else super.setAmount(a);
    }

    String getSender() {return sender;}
    void setSender(String s) {sender = s;}

    String getRecipient() {return recipient;}
    void setRecipient(String r) {recipient = r;}


    public void printObject() {
        System.out.println("Date: " + getDate());
        System.out.println("Amount: " + getAmount());
        System.out.println("Description: " + getDescription());
        System.out.println("Sender: " + sender);
        System.out.println("Recipient: " + recipient);
    }
}
