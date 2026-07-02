package io.github.HugoPinto.mapper;

import io.github.HugoPinto.dto.alunodto.AlunoRequestDto;
import io.github.HugoPinto.dto.alunodto.AlunoResponseDto;
import io.github.HugoPinto.model.alunomodel.AlunoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(
        componentModel = "cdi",
        uses = TurmaMapper.class,
        injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR
)
public interface AlunoMapper {

    @Mapping(target = "turmas", ignore = true)
    AlunoModel toModel(AlunoRequestDto dto);

    // Ignora turmas quando for de Model para RequestDto
    @Mapping(target = "turmas", ignore = true)
    AlunoRequestDto toDto(AlunoModel model);

    AlunoResponseDto toResponseDto(AlunoModel model);

    List<AlunoResponseDto> toResponseDtoList(List<AlunoModel> models);

    @Mapping(target = "turmas", ignore = true)
    void updateModelFromDto(AlunoRequestDto dto, @MappingTarget AlunoModel model);

    // Outros métodos (se precisar)
    List<AlunoRequestDto> toDtoList(List<AlunoModel> models);
    List<AlunoModel> toModelList(List<AlunoRequestDto> dtos);
}