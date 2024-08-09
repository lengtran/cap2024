package com.lengper.cap2024.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountFormBean {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

}