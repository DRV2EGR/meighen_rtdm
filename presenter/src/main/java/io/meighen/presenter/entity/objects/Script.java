package io.meighen.presenter.entity.objects;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import io.meighen.presenter.entity.User;
import lombok.Data;

@Entity
@Table(name ="scripts")
@Data
public class Script extends BaseObjEntity {
    protected String name;
    protected String mainMethod;
    protected String topicName;
    protected String body;

    protected LocalDateTime dateCreation;
    protected LocalDateTime dateModification;
    @OneToOne
    protected User lastModifier;

}
