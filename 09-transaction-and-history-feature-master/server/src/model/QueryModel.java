package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class QueryModel {
    Connection conn;


    PreparedStatement preparedStatement;

    public QueryModel() throws Exception {

        conn = DBconnection.getMSSQLConnection();

    }
//    public ArrayList<Transaction> getTransactionHistory (int from, int to) {
////        ArrayList<Transaction> tran = new ArrayList<>();
////        try {
////            String query = String.format("SELECT * FROM CSC105_project.dbo.[transaction]\n" +
////                    "WHERE id >= '%s' AND id <= '%s'", from, to);
////            preparedStatement = conn.prepareStatement(query);
////            ResultSet result = preparedStatement.executeQuery();
////            while (result.next()) {
////                tran.add(new Transaction(result));
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return tran;
////    }
    public String getCurrency (String account_id){
        String cur = "";
        try{
            String query = String.format("SELECT currency FROM CSC105_project.dbo.[transaction] WHERE account_id='%s'",account_id);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                String currency = result.getString("currency");
                cur = currency;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cur;

    }
public ArrayList<Transaction> getTransactionHistory (int num) {
    ArrayList<Transaction> tran = new ArrayList<>();
    try {
        String query = String.format("SELECT * FROM CSC105_project.dbo.[transaction]\n" +
                "INNER JOIN account ON [transaction].account_id = account.id\n" +
                "AND account.owner_id = '%s'\n" +
                "ORDER BY [transaction].created_at DESC ",num);
        preparedStatement = conn.prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            tran.add(new Transaction(result));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }   
    return tran;
}
    public ArrayList<Account> getSessionID(int owner_id){
        ArrayList<Account> acc = new ArrayList<>();
        try {
            String query = String.format("SELECT * FROM CSC105_project.dbo.account\n" +
                    "WHERE owner_id = '%d' ",owner_id);
            preparedStatement = conn.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String OwnerId = result.getString("owner_id");
                String Account = result.getString("account_type");
                String Name = result.getString("name");
                String balance = result.getString("balance");

                acc.add(new Account(id,OwnerId,Account,Name,balance));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return acc;


    }
    public Double getAmountWithdrawJan(String accid) {
        ArrayList<Amount> jan = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-01-01' and '2020-01-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                jan.add(new Amount(result));
            }
            for (int i =0; i < jan.size();i++){
                sum += (jan.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawFeb(String accid) {
        ArrayList<Amount> feb = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-02-01' and '2020-02-29'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                feb.add(new Amount(result));
            }
            for (int i =0; i < feb.size();i++){
                sum += (feb.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawMarch(String accid) {
        ArrayList<Amount> march = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-03-01' and '2020-03-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                march.add(new Amount(result));
            }
            for (int i =0; i < march.size();i++){
                sum += (march.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawApril(String accid) {
        ArrayList<Amount> april = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "AND created_at between '2020-04-01' and '2020-04-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                april.add(new Amount(result));
            }
            for (int i =0; i < april.size();i++){
                sum += (april.get(i).amount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawMay(String accid) {
        ArrayList<Amount> may = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-05-01' and '2020-05-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                may.add(new Amount(result));
            }
            for (int i =0; i < may.size();i++){
                sum += (may.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawJune(String accid) {
        ArrayList<Amount> june = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-06-01' and '2020-06-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                june.add(new Amount(result));
            }
            for (int i =0; i < june.size();i++){
                sum += (june.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawJuly(String accid) {
        ArrayList<Amount> july = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-07-01' and '2020-07-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                july.add(new Amount(result));
            }
            for (int i =0; i < july.size();i++){
                sum += (july.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawAugust(String accid) {
        ArrayList<Amount> aug = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-08-01' and '2020-08-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                aug.add(new Amount(result));
            }
            for (int i =0; i < aug.size();i++){
                sum += (aug.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawSeptember(String accid) {
        ArrayList<Amount> sep = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-09-01' and '2020-09-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                sep.add(new Amount(result));
            }
            for (int i =0; i < sep.size();i++){
                sum += (sep.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawOctober(String accid) {
        ArrayList<Amount> oct = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-10-01' and '2020-10-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                oct.add(new Amount(result));
            }
            for (int i =0; i < oct.size();i++){
                sum += (oct.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawNovember(String accid) {
        ArrayList<Amount> nov = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-11-01' and '2020-1-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                nov.add(new Amount(result));
            }
            for (int i =0; i < nov.size();i++){
                sum += (nov.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountWithdrawDecember(String accid) {
        ArrayList<Amount> dec = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Withdraw'\n" +
                    "  AND created_at between '2020-12-01' and '2020-12-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                dec.add(new Amount(result));
            }
            for (int i =0; i < dec.size();i++){
                sum += (dec.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    // Get deposit amount of that month
    public Double getAmountDepositJan(String accid) {
        ArrayList<Amount> jan = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-01-01' and '2020-01-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                jan.add(new Amount(result));
            }
            for (int i =0; i < jan.size();i++){
                sum += (jan.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositFeb(String accid) {
        ArrayList<Amount> feb = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-02-01' and '2020-02-29'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                feb.add(new Amount(result));
            }
            for (int i =0; i < feb.size();i++){
                sum += (feb.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositMarch(String accid) {
        ArrayList<Amount> march = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-03-01' and '2020-03-30'",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                march.add(new Amount(result));
            }
            for (int i =0; i < march.size();i++){
                sum += (march.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositApril(String accid) {
        ArrayList<Amount> april = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-04-01' and '2020-04-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                april.add(new Amount(result));
            }
            for (int i =0; i < april.size();i++){
                sum += (april.get(i).amount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositMay(String accid) {
        ArrayList<Amount> may = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-05-01' and '2020-05-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                may.add(new Amount(result));
            }
            for (int i =0; i < may.size();i++){
                sum += (may.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositJune(String accid) {
        ArrayList<Amount> june = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-06-01' and '2020-06-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                june.add(new Amount(result));
            }
            for (int i =0; i < june.size();i++){
                sum += (june.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositJuly(String accid) {
        ArrayList<Amount> july = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-07-01' and '2020-07-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                july.add(new Amount(result));
            }
            for (int i =0; i < july.size();i++){
                sum += (july.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositAugust(String accid) {
        ArrayList<Amount> aug = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-08-01' and '2020-08-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                aug.add(new Amount(result));
            }
            for (int i =0; i < aug.size();i++){
                sum += (aug.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositSeptember(String accid) {
        ArrayList<Amount> sep = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-09-01' and '2020-09-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                sep.add(new Amount(result));
            }
            for (int i =0; i < sep.size();i++){
                sum += (sep.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositOctober(String  accid) {
        ArrayList<Amount> oct = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-10-01' and '2020-10-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                oct.add(new Amount(result));
            }
            for (int i =0; i < oct.size();i++){
                sum += (oct.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositNovember(String accid) {
        ArrayList<Amount> nov = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-11-01' and '2020-11-30'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                nov.add(new Amount(result));
            }
            for (int i =0; i < nov.size();i++){
                sum += (nov.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public Double getAmountDepositDecember(String accid) {
        ArrayList<Amount> dec = new ArrayList<>();
        double sum = 0;
        try {
            String q = String.format("SELECT amount from CSC105_project.dbo.[transaction]\n" +
                    "WHERE account_id = '%s' AND transaction_type = 'Deposit'\n" +
                    "AND created_at between '2020-12-01' and '2020-12-31'\n",accid);
            preparedStatement = conn.prepareStatement(q);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                dec.add(new Amount(result));
            }
            for (int i =0; i < dec.size();i++){
                sum += (dec.get(i).amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }


}
