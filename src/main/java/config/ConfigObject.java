package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import config.types.ConfigTypes;
import config.types.ScopeType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ConfigObject {
    @JsonProperty
    private String name;
    @JsonProperty
    private ConfigTypes type;
    @JsonProperty
    private String data;
    @JsonProperty
    private List<ConfigObject> values;
    @JsonProperty
    private ScopeType scope;



}
