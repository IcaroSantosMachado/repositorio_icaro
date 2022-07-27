package icaro.machado.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import icaro.machado.morintegraocomjava.database_app.tabelas.Pergunta;



@Dao
public interface ICRUDPerguntaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPergunta(Pergunta tblPergunta);

    @Query("SELECT id, pergunta, provaId FROM tbl_pergunta WHERE id = :id")
    Pergunta getEspecificPerguntaByID(int id);

    @Query("SELECT id, pergunta, provaId FROM tbl_pergunta")
    List<Pergunta> getAllPerguntas();

    @Update(entity = Pergunta.class, onConflict = OnConflictStrategy.REPLACE)
    void updatePerguntas(Pergunta tblPergunta);

    @Delete
    void deletePerguntas(Pergunta tblPergunta);

    @Query("DELETE FROM tbl_pergunta WHERE id = :id")
    void deletePerguntaByID(int id);

    @Query("DElETE FROM tbl_pergunta")
    void deleteAllPerguntas();
}
