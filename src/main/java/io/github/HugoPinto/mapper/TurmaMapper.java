package io.github.HugoPinto.mapper;

import io.github.HugoPinto.dto.TurmaResumoDto;
import io.github.HugoPinto.model.turmamodel.TurmaModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = "cdi",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)

public interface TurmaMapper {

    @Mapping(source = "professor.nome", target = "professor")
    @Mapping(source = "disciplina.nome", target = "disciplina")
    TurmaResumoDto toResumoDto(TurmaModel model);

    List<TurmaResumoDto> toResumoDtoList(List<TurmaModel> models);

    List<TurmaResumoDto> toResumoDtoList(Set<TurmaModel> models);

    // Remova esses métodos daqui (eles não pertencem a esse mapper)
    // turmaModel toModel(Turmadto turmadto);
    // AlunoRequestDto toDto(AlunoModel model);
}