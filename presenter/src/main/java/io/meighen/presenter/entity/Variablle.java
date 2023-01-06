package io.meighen.presenter.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="variables")
@Data
public class Variablle extends BaseObjEntity {
    protected String name;
    protected String value;
    protected String type;
}
