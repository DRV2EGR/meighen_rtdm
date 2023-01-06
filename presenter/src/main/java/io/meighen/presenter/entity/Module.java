package io.meighen.presenter.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    protected String body;
}
