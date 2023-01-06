package io.meighen.presenter.entity.dto;

import java.time.LocalDateTime;

import javax.persistence.OneToOne;
import io.meighen.presenter.entity.User;
import lombok.Data;

@Data
public class VariableDto {
    public String name;
    public String value;
    public String type;

    public LocalDateTime dateCreation;
    public LocalDateTime dateModification;

    public UserDto lastModifier;
}
