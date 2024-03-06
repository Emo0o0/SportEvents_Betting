package com.example.sportevents_betting.api.inputoutput.bettinguser.create;

import com.example.sportevents_betting.api.base.OperationInput;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBettingUserInput implements OperationInput {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    @Email
    private String email;
    @NotBlank(message = "Password cannot be blank")
    private String password;

}
