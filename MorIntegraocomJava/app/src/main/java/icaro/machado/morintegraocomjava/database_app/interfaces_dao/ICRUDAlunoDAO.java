package icaro.machado.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import icaro.machado.morintegraocomjava.database_app.tabelas.Aluno;

@Dao
public interface ICRUDAlunoDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAluno(Aluno tblAluno);

    @Query("SELECT id, nome, email, celular, gitHubUsuario FROM tbl_aluno WHERE id = :id")
    Aluno getEspecificAlunoByID(int id);

    @Query("SELECT id, nome, email, celular, gitHubUsuario FROM tbl_aluno")
    List<Aluno> getAllAlunos();

    @Transaction
    @Update(entity = Aluno.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAlunos(Aluno tblAluno);

    @Transaction
    @Delete
    void deleteAlunos(Aluno tblAluno);

    @Transaction
    @Query("DELETE FROM tbl_aluno WHERE id = :id")
    void deleteAlunosByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_aluno")
    void deleteAllAlunos();

}
