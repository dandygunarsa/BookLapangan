package com.example.booklapangan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoriesDao {
    @Query("SELECT * FROM tb_categories")
    List<Categories> getAll();

    @Insert
    void insertAll(Categories... categories);

    @Delete
    void delete(Categories categories);

    @Update
    void update(Categories categories);
}
