package Bank;

public class Transfer {
    String date;
    Double amount;
    String description;
    String sender;
    String recipient;

    public Transfer(String date, double amount, String description, String sender, String recipient) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Transfer(Transfer transfer) {
        this(   transfer.date, transfer.amount, transfer.description, transfer.sender, transfer.recipient);
    }


    String getDate() {return date;}
    void setDate(String d) {date = d;}

    Double getAmount() {return amount;}
    void setAmount(Double a) {amount = a;}

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
