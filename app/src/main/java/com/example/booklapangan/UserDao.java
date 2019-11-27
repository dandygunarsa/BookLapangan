package com.example.booklapangan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM tb_user")
    List<User> getAll();

    @Insert
    void insertAll(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
