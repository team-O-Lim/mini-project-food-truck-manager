package org.example.foodtruckback.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.example.foodtruckback.common.enums.RoleType;
import org.example.foodtruckback.dto.ResponseDto;
import org.example.foodtruckback.dto.role.request.RoleAddRequestDto;
import org.example.foodtruckback.dto.role.response.RoleAddResponseDto;
import org.example.foodtruckback.dto.user.request.UserUpdateRequestDto;
import org.example.foodtruckback.dto.user.response.UserDetaileResponseDto;
import org.example.foodtruckback.dto.user.response.UserListResponseDto;
import org.example.foodtruckback.security.user.UserPrincipal;
import org.example.foodtruckback.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Override
    public ResponseDto<UserDetaileResponseDto> getMyInfo(UserPrincipal principal) {
        return null;
    }

    @Override
    public ResponseDto<UserDetaileResponseDto> updateMyInfo(UserPrincipal principal, UserUpdateRequestDto request) {
        return null;
    }

    @Override
    public ResponseDto<List<UserListResponseDto>> getAllUsers() {
        return null;
    }

    @Override
    public ResponseDto<UserDetaileResponseDto> getByUserId(UserPrincipal principal) {
        return null;
    }

    @Override
    public ResponseDto<UserDetaileResponseDto> updateByUserId(UserPrincipal principal, UserUpdateRequestDto request) {
        return null;
    }

    @Override
    public ResponseDto<RoleAddResponseDto> addRoles(UserPrincipal principal, RoleAddRequestDto request) {
        return null;
    }

    @Override
    public ResponseDto<Void> deleteRoles(UserPrincipal principal, RoleType roleName) {
        return null;
    }
}
