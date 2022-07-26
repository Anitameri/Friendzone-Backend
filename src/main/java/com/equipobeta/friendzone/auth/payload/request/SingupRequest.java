package com.equipobeta.friendzone.auth.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SingupRequest {
    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
