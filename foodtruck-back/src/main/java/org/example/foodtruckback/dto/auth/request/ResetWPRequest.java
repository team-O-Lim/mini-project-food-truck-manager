package org.example.foodtruckback.dto.auth.request;

import jakarta.validation.constraints.NotBlank;

public record ResetWPRequest(
        @NotBlank(message = "아이디는 필수입니다.")
        String loginId,

        @NotBlank(message = "이메일은 필수입니다.")
        String email,

        @NotBlank(message = "비밀번호는 필수입니다.")
        String password,

        @NotBlank(message = "비밀번호 확인은 필수입니다.")
        String confirmPassword
) {}
