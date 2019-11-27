package com.example.booklapangan;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

@Database(entities = {User.class, Categories.class},version = 1, exportSchema = false)

public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase INSTANCE;

    public abstract UserDao userDao();

    public abstract CategoriesDao categoriesDao();

    public synchronized static MyDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static MyDatabase buildDatabase(final Context context) {

        return Room.databaseBuilder(context,
                MyDatabase.class,
                "booking_lapangan")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getInstance(context).categoriesDao().insertAll(Categories.populateData());
                            }
                        });
                    }
                })
                .allowMainThreadQueries()
                .build();
    }
}
