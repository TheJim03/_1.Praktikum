package Bank;

public class Transfer
{
    private String date;
    private Double amount;
    private String description;
    private String sender;
    private String recipient;

    public Transfer(String date, double amount, String description, String sender, String recipient)
    {
        setDate(date);
        setAmount(amount);
        setDescription(description);
        setSender(sender);
        setRecipient(recipient);
    }

    public Transfer(Transfer copy)
    {
        this(copy.getDate(), copy.getAmount(), copy.getDescription(), copy.getSender(), copy.getRecipient());

    }

    //getter/setter
    String getDate() {return date;}
    void setDate(String d) {date = d;}

    Double getAmount() {return amount;}
    void setAmount(Double a)
    {
        if(a <= 0) System.out.println("Negative Transfer?");
        else amount = a;
    }

    String getDescription() {return description;}
    void setDescription(String d) {description = d;}

    String getSender() {return sender;}
    void setSender(String s) {sender = s;}

    String getRecipient() {return recipient;}
    void setRecipient(String r) {recipient = r;}


    public void printObject() {
        System.out.println("Date: " + date);
        System.out.println("Amount: " + amount);
        System.out.println("Description: " + description);
        System.out.println("Sender: " + sender);
        System.out.println("Recipient: " + recipient);
    }
}
