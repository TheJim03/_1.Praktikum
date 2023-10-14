package Bank;

public class Payment {
    private String date;
    private Double amount;
    private String description;
    private double incomingInterest;
    private double outgoingInterest;

    public Payment(String date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Payment(String date, double amount, String description, double incomingInterest, double outgoingInterest) {
        this(date, amount, description);
        this.incomingInterest = incomingInterest;
        this.outgoingInterest = outgoingInterest;
    }

    public Payment(Payment copy) {
        this.date = copy.date;
        this.amount = copy.amount;
        this.description = copy.description;
        this.incomingInterest = copy.incomingInterest;
        this.outgoingInterest = copy.outgoingInterest;
    }

    public String getDate() {return date;}
    public void setDate(String d) {date = d;}

    public Double getAmount() {return amount;}
    public void setAmount(Double a) {amount = a;}

    public String getDescription() {return description;}
    public void setDescription(String d) {description = d;}

    public double getIncomingInterest() {return incomingInterest;}
    public void setIncomingInterest(double incomingInterest) {
        if (incomingInterest >= 0 && incomingInterest <= 1) {
            this.incomingInterest = incomingInterest;
        } else {
            System.out.println("Ungültiger Eingangszinssatz");
        }
    }

    public double getOutgoingInterest() {return outgoingInterest;}
    public void setOutgoingInterest(double outgoingInterest) {
        if (outgoingInterest >= 0 && outgoingInterest <= 1) {
            this.outgoingInterest = outgoingInterest;
        } else {
            System.out.println("Ungültiger Ausgangszinssatz");
        }
    }

    public void printObject() {
        System.out.println("Date: " + date);
        System.out.println("Amount: " + amount);
        System.out.println("Description: " + description);
        System.out.println("Incoming Interest: " + incomingInterest);
        System.out.println("Outgoing Interest: " + outgoingInterest);
    }
}
