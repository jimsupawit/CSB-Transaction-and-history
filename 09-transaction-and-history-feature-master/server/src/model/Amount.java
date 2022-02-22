package model;
import java.sql.ResultSet;
public class Amount {
    double amount;

    public Amount(ResultSet result) {
        try {
            this.amount = result.getDouble("amount");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }

    public double getAmount() {
        return amount;
    }
}
