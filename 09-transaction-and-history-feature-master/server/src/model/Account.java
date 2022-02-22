package model;

import java.sql.ResultSet;

public class Account {
    String id,owner_id,account_type,name,balance;

    public Account(String id, String owner_id, String account_type, String name, String balance) {

        this.id = id;
        this.owner_id = owner_id;
        this.account_type = account_type;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", owner_id='" + owner_id + '\'' +
                ", account_type='" + account_type + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public String getName() {
        return name;
    }

    public String getBalance() {
        return balance;
    }

}
