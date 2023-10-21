package io.meighen.presenter.entity;

import java.util.List;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name ="modules")
@Data
public class Module extends BaseObjEntity {
    protected String name;
    public boolean iinternal;
    @OneToOne
    protected ExtModule extModule;
    @OneToMany
    protected List<Object> objects;
    @OneToOne
    protected Script firstScript;
    @Column(columnDefinition="text")
    protected String body;

    @OneToOne
    ModuleInfo moduleInfo;
}
