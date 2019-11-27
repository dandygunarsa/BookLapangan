package com.example.booklapangan;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_categories")
public class Categories {
    @PrimaryKey( autoGenerate = true)
    int id;
    @ColumnInfo(name = "nama_category")
    String nama_category;

    public Categories(String nama_category) {
        this.nama_category = nama_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_category() {
        return nama_category;
    }

    public void setNama_category(String nama_category) {
        this.nama_category = nama_category;
    }

    public static Categories[] populateData() {
        return new Categories[]{
                new Categories("Bulutangkis"),
                new Categories("Sepak Bola"),
                new Categories("Futsal"),
                new Categories("Basket"),
                new Categories("Renang"),
                new Categories("Tenis")
        };
    }
}
