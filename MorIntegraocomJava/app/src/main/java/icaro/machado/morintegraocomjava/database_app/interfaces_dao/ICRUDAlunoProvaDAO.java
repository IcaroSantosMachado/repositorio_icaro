package icaro.machado.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import icaro.machado.morintegraocomjava.database_app.tabelas.AlunoProva;

@Dao
public interface ICRUDAlunoProvaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlunoProva(AlunoProva tblAlunoProva);

    @Query("SELECT alunoid, provaid FROM tbl_alunoprova WHERE alunoid = :id")
    AlunoProva getEspecificAlunoProvaByID(int id);

    @Query("SELECT alunoid, provaid FROM tbl_alunoprova")
    List<AlunoProva> getAllAlunosProvas();

    @Update(entity = AlunoProva.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAlunoProvas(AlunoProva tblAlunoProva);

    @Delete
    void deleteAlunoProvas(AlunoProva tblAlunoProva);

    @Query("DELETE FROM tbl_alunoprova WHERE alunoid = :id")
    void deleteAlunoProvaByID(int id);

    @Query("DELETE FROM tbl_alunoprova")
    void deleteAllAlunosProvas();

}
