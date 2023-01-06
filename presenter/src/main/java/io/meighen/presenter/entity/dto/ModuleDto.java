package io.meighen.presenter.entity.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import io.meighen.presenter.entity.User;
import io.meighen.presenter.entity.ExtModule;
import io.meighen.presenter.entity.Object;
import io.meighen.presenter.entity.Script;
import lombok.Data;

@Data
public class ModuleDto {
    protected String name;

    public boolean iinternal;

    @OneToOne
    public ExtModule extModule;

    @OneToMany
    public List<Object> objects;

    @OneToOne
    public Script firstScript;
    public String body;

    public LocalDateTime dateCreation;
    public LocalDateTime dateModification;
    @OneToOne
    public User lastModifier;
}
