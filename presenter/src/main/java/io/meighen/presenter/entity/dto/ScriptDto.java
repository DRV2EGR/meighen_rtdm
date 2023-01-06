package io.meighen.presenter.entity.dto;

import java.time.LocalDateTime;

import javax.persistence.OneToOne;
import io.meighen.presenter.entity.User;
import lombok.Data;

@Data
public class ScriptDto {
    public String uuid;
    protected String name;
    protected String mainMethod;
    protected String topicName;
    protected String body;

    protected LocalDateTime dateCreation;
    protected LocalDateTime dateModification;

    protected UserDto lastModifier;
}
