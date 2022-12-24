package io.meighen.presenter.entity.for_Lobenov;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import io.meighen.presenter.entity.BaseEntity;
import io.meighen.presenter.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="objects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Object extends BaseEntity {
    protected String type;
    protected Long objId;

    @ManyToMany
    protected List<User> allowedUsers;

}
