package io.meighen.presenter.entity.objects;

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
    @OneToMany
    protected List<Object> objects;

    @OneToOne
    protected Script firstScript;
    protected String body;

}
