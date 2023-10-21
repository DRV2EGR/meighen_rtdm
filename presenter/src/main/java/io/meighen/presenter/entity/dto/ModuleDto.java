package io.meighen.presenter.entity.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import io.meighen.presenter.entity.*;
import io.meighen.presenter.entity.Object;
import lombok.Data;

@Data
public class ModuleDto {
    public String uuid;
    public String name;

    public boolean iinternal;

    public ExtModule extModule;

    public List<Object> objects;

    public ScriptDto firstScript;
    public String body;

    public LocalDateTime dateCreation;
    public LocalDateTime dateModification;

    public UserDto lastModifier;
    public ModuleInfo moduleInfo;
}
