package dev.ai4j.openai4j.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

/**
 * Controls thinking/reasoning mode for models that support it (e.g. DeepSeek).
 * Serializes to: {"thinking": {"type": "enabled"}} or {"thinking": {"type": "disabled"}}
 */
@JsonDeserialize(builder = Thinking.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public final class Thinking {

    public static final Thinking ENABLED = Thinking.builder().type("enabled").build();
    public static final Thinking DISABLED = Thinking.builder().type("disabled").build();

    @JsonProperty
    private final String type;

    private Thinking(Builder builder) {
        this.type = builder.type;
    }

    public String type() {
        return type;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof Thinking && equalTo((Thinking) another);
    }

    private boolean equalTo(Thinking another) {
        return Objects.equals(type, another.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type);
    }

    @Override
    public String toString() {
        return "Thinking{type=" + type + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static final class Builder {

        private String type;

        private Builder() {
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Thinking build() {
            return new Thinking(this);
        }
    }
}
