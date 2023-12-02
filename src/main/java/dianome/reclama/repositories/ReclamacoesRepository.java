package dianome.reclama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dianome.reclama.models.ReclamacaoModel;

@Repository
public interface ReclamacoesRepository extends JpaRepository<ReclamacaoModel, Integer> {

}
