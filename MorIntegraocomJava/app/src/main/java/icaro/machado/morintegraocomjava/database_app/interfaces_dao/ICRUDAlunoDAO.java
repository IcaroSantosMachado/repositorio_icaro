package icaro.machado.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import icaro.machado.morintegraocomjava.database_app.tabelas.Aluno;

public interface ICRUDAlunoDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAluno(Aluno tblAluno);

    @Query("SELECT id, nome, email, celular, gitHubUsuario FROM tbl_aluno WHERE id = 1")
    Aluno getEspecificAlunoByID(Aluno id);

    @Query("SELECT id, nome, email, celular, gitHubUsuario FROM tbl_aluno")
    List<Aluno> getAllAlunos();

    @Update(entity = Aluno.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAlunos(Aluno tblAluno);

    @Delete
    void deleteAlunos(Aluno tblAluno);

    @Query("DELETE FROM tbl_aluno WHERE id = 1")
    void deleteAlunosByID(Aluno id);

    @Query("DELETE FROM tbl_aluno")
    void deleteAllAlunos();

}
