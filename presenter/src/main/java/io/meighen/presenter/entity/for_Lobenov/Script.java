package io.meighen.presenter.entity.for_Lobenov;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="scripts")
@Data
public class Script extends BaseObjEntity {
    protected String mainMethod;
    protected String topicName;
    protected String body;

}
