package entity;


import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private long accountId;
    private String transactionType;
    private float amount;
    private LocalDateTime transactionDate;
    private String description;

    public Transaction() {
        this.transactionDate = LocalDateTime.now();
    }

    public Transaction(long transactionId, long accountId, String transactionType, float amount, String description) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
        this.transactionDate = LocalDateTime.now();
    }

    // Getters & Setters (no typos here)

    public long getTransactionId() { return transactionId; }
    public void setTransactionId(long transactionId) { this.transactionId = transactionId; }

    public long getAccountId() { return accountId; }
    public void setAccountId(long accountId) { this.accountId = accountId; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Account ID: " + accountId);
        System.out.println("Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + transactionDate);
        System.out.println("Description: " + description);
    }
}