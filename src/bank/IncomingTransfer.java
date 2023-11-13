package bank;

public class IncomingTransfer extends Transfer{
    public IncomingTransfer(Transfer transfer){
        super(transfer);
    }
    @Override
    public double calculate() {
        return getAmount();
    }
}