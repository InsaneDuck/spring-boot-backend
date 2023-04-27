package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "expense_item", schema = "data")
public class ExpenseItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "amount")
    private Integer amount;
    @Basic
    @Column(name = "date")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseItem that = (ExpenseItem) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(amount, that.amount) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, amount, date);
    }
}
