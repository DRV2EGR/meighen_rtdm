package io.meighen.presenter.entity.for_Lobenov;

import javax.persistence.Entity;
import javax.persistence.Table;
import io.meighen.presenter.entity.BaseEntity;
import lombok.Data;

@Entity
@Table(name ="variables")
@Data
public class Variablle extends BaseEntity {
    protected String name;
    protected String value;
    protected String type;
}
