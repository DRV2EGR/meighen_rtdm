package io.meighen.presenter.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="modules_info")
@Data
public class ModuleInfo extends BaseEntity{
    protected String status;
    protected int state;
}
