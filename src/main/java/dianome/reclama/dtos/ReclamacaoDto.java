package dianome.reclama.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReclamacaoDto( @NotBlank String nome,
		@NotNull int telefone,
		@NotBlank String descricao,
		@NotBlank String codRastreamento,
		@NotBlank String descSolucao ) {

}
