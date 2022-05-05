package com.example.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expId;

    @Column(length = 15 , nullable = false)
    private String expDate;

    @Column(length = 150 , nullable = false)
    private String description;

    @Column(length = 15 , nullable = false)
    private String location;

    @Column(length = 15 , nullable = false)
    private String category;

    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    public String  getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expId=" + expId +
                ", expDate=" + expDate +
                ", desc='" + description + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                '}';
    }


}
