package io.meighen.service_bulder.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="builds_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateCreateDeployment extends BaseObjEntity {
    String app_name;
    String registry_host;
    String image;
    String port;
}
