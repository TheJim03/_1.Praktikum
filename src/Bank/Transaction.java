package Bank;

public class Transaction
{
    private String date;
    private Double amount;
    private String description;

    protected Transaction(String date, double amount, String description)
    {
        setDate(date);
        setAmount(amount);
        setDescription(description);
    }

    public String getDate() {return date;}
    public void setDate(String d) {date = d;}

    public Double getAmount() {return amount;}
    public void setAmount(Double a) {amount = a;}

    public String getDescription() {return description;}
    public void setDescription(String d) {description = d;}
}
