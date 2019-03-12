package io.effective.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.effective.model.AmsUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Engineer extends AmsUser {
    private Boolean isPrimary;

    public Engineer(AmsUser user, Boolean isPrimary) {
        this.isPrimary = isPrimary;
        super.setId(user.getId());
        super.setName(user.getName());
    }
}
