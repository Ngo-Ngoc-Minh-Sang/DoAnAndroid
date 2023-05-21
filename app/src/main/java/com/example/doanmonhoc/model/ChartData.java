package com.example.doanmonhoc.model;

public class ChartData {
    private int month;
    private int year;
    private int totalIncome;
    private int totalExpense;

    public ChartData(int month, int year, int totalIncome, int totalExpense) {
        this.month = month;
        this.year = year;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(int totalExpense) {
        this.totalExpense = totalExpense;
    }
}
