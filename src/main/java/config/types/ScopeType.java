package config.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ScopeType {
    @JsonProperty("local")
    local,
    @JsonProperty("global")
    global,
}
