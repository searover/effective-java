package io.effective.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.effective.model.AmsAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(fluent = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends AmsAccount {
    private String opsUserId;
    private String opsUserName;
    private List<Engineer> engineers;
}
