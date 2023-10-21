package io.meighen.service_bulder.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="ext_modules")
@Data
public class ExtModule extends BaseObjEntity {
    protected String callType;
    protected String callUrl;

}
