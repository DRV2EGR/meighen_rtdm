package io.meighen.presenter.entity.objects;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import io.meighen.presenter.entity.User;
import lombok.Data;

@Entity
@Table(name ="modules")
@Data
public class Module extends BaseObjEntity {
    protected String name;

    @OneToMany
    protected List<Object> objects;

    @OneToOne
    protected Script firstScript;
    protected String body;

    protected LocalDateTime dateCreation;
    protected LocalDateTime dateModification;
    @OneToOne
    protected User lastModifier;

}
