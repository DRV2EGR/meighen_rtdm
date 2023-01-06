package io.meighen.presenter.mapper;

import io.meighen.presenter.entity.Module;
import io.meighen.presenter.entity.Script;
import io.meighen.presenter.entity.dto.ModuleDto;
import io.meighen.presenter.entity.dto.ScriptDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

// @Mapper(componentModel = "spring", imports = UUID.class)
@Mapper(componentModel = "spring")
public interface ObjectMapper {

    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

//    @Mapping(source = "commerce.promotionCode", target = "code")
        // @Mapping(target = "refId", expression = "java(UUID.randomUUID().toString())")
    ModuleDto modelToDto(Module commerce);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModuleFromDto(ModuleDto dto, @MappingTarget Module entity);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateScriptFromDto(ScriptDto moduleDto, @MappingTarget Script script);

//    List<CommerceDto> modelsToDtos(List<Commerce> commerces);
//
//    @InheritInverseConfiguration
//    Commerce dtoToModel(CommerceDto commerceDto);
}
