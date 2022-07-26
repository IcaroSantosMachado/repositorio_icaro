package icaro.machado.morintegraocomjava.database_app;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import icaro.machado.morintegraocomjava.database_app.converter.Converters;
import icaro.machado.morintegraocomjava.database_app.interfaces_dao.ICRUDAlunoDAO;
import icaro.machado.morintegraocomjava.database_app.interfaces_dao.ICRUDAlunoProvaDAO;
import icaro.machado.morintegraocomjava.database_app.interfaces_dao.ICRUDPerguntaDAO;
import icaro.machado.morintegraocomjava.database_app.interfaces_dao.ICRUDProvaDAO;
import icaro.machado.morintegraocomjava.database_app.interfaces_dao.ICRUDRespostaDAO;
import icaro.machado.morintegraocomjava.database_app.tabelas.Aluno;
import icaro.machado.morintegraocomjava.database_app.tabelas.AlunoProva;
import icaro.machado.morintegraocomjava.database_app.tabelas.Pergunta;
import icaro.machado.morintegraocomjava.database_app.tabelas.Prova;
import icaro.machado.morintegraocomjava.database_app.tabelas.Resposta;

@Database(entities = {Aluno.class, AlunoProva.class, Prova.class
        ,   Pergunta.class, Resposta.class}
        , exportSchema = false
        , version = 1)

@TypeConverters(Converters.class)
public abstract class DatabaseApp extends RoomDatabase {

    private static final String DB_NAME = "db_app.db";
    private static final String TAG = "DATABASE";
    private static volatile DatabaseApp sInstance;

    //interface DAO;

    public abstract ICRUDAlunoDAO alunosDAO();
    public abstract ICRUDAlunoProvaDAO alunoProvaDAO();
    public abstract ICRUDProvaDAO provasDAO();
    public abstract ICRUDPerguntaDAO perguntasDAO();
    public abstract ICRUDRespostaDAO respostasDAO();

    public DatabaseApp(){}

    public static synchronized DatabaseApp getInstance(Context context){
        if(sInstance == null){

            sInstance = getConnection(context);

        }

        return sInstance;
    }


    private static DatabaseApp getConnection(Context activityContext){
        DatabaseApp db = Room.databaseBuilder(activityContext, DatabaseApp.class, DB_NAME)
                .addCallback(initDB)
                .build();

        return db;
    }


    static RoomDatabase.Callback initDB = new RoomDatabase.Callback(){
        public void oncreate (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            Executors.newSingleThreadScheduledExecutor().execute(() ->{
                Log.d(TAG, "Banco executado com sucesso! Executar rotinas posteriores");
            });
        }

        public void onOpen (SupportSQLiteDatabase db) {}
    };

}
