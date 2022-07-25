package icaro.machado.morintegraocomjava.database_app;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

public abstract class DatabaseApp extends RoomDatabase {

    private static final String DB_NAME = "db_app.db";
    private static final String TAG = "DATABASE";
    private static volatile DatabaseApp sInstance;

    public DatabaseApp(){}

    public static synchronized DatabaseApp getInstance(Context context){return null;}


    private static DatabaseApp getConnection(Context contextActivity){return null;}


    static RoomDatabase.Callback initDB = new RoomDatabase.Callback(){
        public void oncreate (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            Executors.newSingleThreadScheduledExecutor().execute(() ->{
                Log.d(TAG, "Banco executado com sucesso! Executar rotinas posteriores");
            });
        }

        public void onOpen (SupportSQLiteDatabase db) {



        }
    };


}
