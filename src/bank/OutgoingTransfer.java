package bank;

public class OutgoingTransfer extends Transfer{
    public OutgoingTransfer(Transfer transfer){
        super(transfer);
    }
    @Override
    public double calculate() {
        return -1 * getAmount();
    }
}