package org.piva.fisdtest26042025.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.piva.fisdtest26042025.entity.Role;
import org.piva.fisdtest26042025.entity.User;
import org.piva.fisdtest26042025.security.CustomUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "authorities", expression = "java(mapRoles(user.getRoles()))")
    @Mapping(target = "isEnabled", source = "enabled")
    CustomUserDetails toCustomUserDetails(User user);

    default List<GrantedAuthority> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
