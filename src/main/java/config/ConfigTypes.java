package config;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ConfigTypes {
        @JsonProperty("string")
        string,
        @JsonProperty("integer")
        integer,
        @JsonProperty("NULL")
        NULL,
        @JsonProperty("bol")
        bol
}




