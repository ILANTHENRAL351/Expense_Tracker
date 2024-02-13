package com.isquare.expensetracker;

public class ExpenseModel {
    private String exenseID;
    private String note;
    private String category;
    private long amount;
    private long Time;
    private String type;
    private String uid;

    public ExpenseModel(String exenseID, String note, String category, long amount, long time, String type, String uid) {
        this.exenseID = exenseID;
        this.note = note;
        this.category = category;
        this.amount = amount;
        Time = time;
        this.type = type;
        this.uid = uid;
    }
    public ExpenseModel(){}

    public String getExenseID() {
        return exenseID;
    }

    public void setExenseID(String exenseID) {
        this.exenseID = exenseID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTime() {
        return Time;
    }

    public void setTime(long time) {
        Time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}




