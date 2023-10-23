package Bank;

public class Payment extends Transaction
{
    private double incomingInterest;
    private double outgoingInterest;


    public Payment(String date, double amount, String description)
    {
        super(date, amount, description);
    }

    public Payment(String date, double amount, String description, double incomingInterest, double outgoingInterest) {
        this(date, amount, description);
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    //copy
    public Payment(Payment copy) {
        this(copy.getDate(), copy.getAmount(), copy.getDescription(), copy.getIncomingInterest(), copy.getOutgoingInterest());
    }

    //getter/setter

    public double getIncomingInterest() {return incomingInterest;}
    public void setIncomingInterest(double incomingInterest) {
        if (incomingInterest >= 0 && incomingInterest <= 1) {
            this.incomingInterest = incomingInterest;
        } else {
            System.out.println("Ungültiger Eingangszinssatz");
        }
    }

    public double getOutgoingInterest() {return outgoingInterest;}
    public void setOutgoingInterest(double outgoingInterest)
    {
        if (outgoingInterest >= 0 && outgoingInterest <= 1)
        {
            this.outgoingInterest = outgoingInterest;
        }
        else
        {
            System.out.println("Ungültiger Ausgangszinssatz");
        }
    }

    public void printObject()
    {
        System.out.println("Date: " + getDate());
        System.out.println("Amount: " + getAmount());
        System.out.println("Description: " + getDescription());
        System.out.println("Incoming Interest: " + incomingInterest);
        System.out.println("Outgoing Interest: " + outgoingInterest);
    }
}
