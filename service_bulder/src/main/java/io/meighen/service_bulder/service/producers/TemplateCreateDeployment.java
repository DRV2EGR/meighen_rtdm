package io.meighen.service_bulder.service.producers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateCreateDeployment {
    String app_name;
    String registry_host;
    String image;
    String port;
}
