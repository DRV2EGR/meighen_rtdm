package io.meighen.presenter.mapper;

import io.meighen.presenter.entity.Module;
import io.meighen.presenter.entity.Role;
import io.meighen.presenter.entity.Script;
import io.meighen.presenter.entity.Variable;
import io.meighen.presenter.entity.dto.ModuleDto;
import io.meighen.presenter.entity.dto.ScriptDto;
import io.meighen.presenter.entity.dto.VariableDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

// @Mapper(componentModel = "spring", imports = UUID.class)
@Mapper(componentModel = "spring")
public interface ObjectMapper {

    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

//    @Mapping(source = "commerce.promotionCode", target = "code")
        // @Mapping(target = "refId", expression = "java(UUID.randomUUID().toString())")
    ModuleDto modelToDto(Module module);
    ScriptDto modelToDto(Script module);
    VariableDto modelToDto(Variable module);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModuleFromDto(ModuleDto dto, @MappingTarget Module entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateScriptFromDto(ScriptDto moduleDto, @MappingTarget Script script);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateVariableFromDto(VariableDto variableDto, @MappingTarget Variable variable);

//    List<CommerceDto> modelsToDtos(List<Commerce> commerces);
//
//    @InheritInverseConfiguration
//    Commerce dtoToModel(CommerceDto commerceDto);
}
