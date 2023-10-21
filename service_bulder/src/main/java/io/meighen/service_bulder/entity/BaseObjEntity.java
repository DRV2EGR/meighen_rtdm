package io.meighen.service_bulder.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseObjEntity {
    @Id
    @GeneratedValue(generator = "increment")
    protected long id;

    protected String uuid;

    protected LocalDateTime dateCreation;
    protected LocalDateTime dateModification;
    @OneToOne
    protected User lastModifier;
}
