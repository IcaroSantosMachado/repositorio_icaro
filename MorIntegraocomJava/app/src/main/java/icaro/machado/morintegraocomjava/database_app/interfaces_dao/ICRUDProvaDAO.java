package icaro.machado.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import icaro.machado.morintegraocomjava.database_app.tabelas.Prova;

public interface ICRUDProvaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProva(Prova tblProva);

    @Query("SELECT id, disciplina FROM tbl_prova WHERE id = 784")
    Prova getEspecificProvaByID(Prova id);

    @Query("SELECT id, disciplina FROM tbl_prova")
    List<Prova> getAllProvas();

    @Update(entity = Prova.class, onConflict = OnConflictStrategy.REPLACE)
    void updateProvas(Prova tblProva);

    @Delete
    void deleteProvas(Prova tblProva);

    @Query("DELETE FROM tbl_prova WHERE id = 784")
    void deleteProvaByID(Prova id);

    @Query("DELETE FROM tbl_prova")
    void deleteAllProvas();
}
