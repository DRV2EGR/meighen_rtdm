package io.meighen.presenter.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="backups")
@Data
public class Backup extends BaseObjEntity {
    public String body;
    public String type;
}
