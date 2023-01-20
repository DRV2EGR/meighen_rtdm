package io.meighen.presenter.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="variables")
@Data
public class Variable extends BaseObjEntity {
    public String name;
    public String value;
    public String type;
}
