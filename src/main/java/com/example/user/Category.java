package com.example.user;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CatId;
    @Column(nullable = false,length = 40)
    private String catName;


    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CatId=" + CatId +
                ", catName='" + catName + '\'' +
                '}';
    }
}
