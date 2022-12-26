package io.meighen.presenter.entity.objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseObjEntity {
    @Id
    @GeneratedValue(generator = "increment")
    protected long id;

    protected String uuid;
}
