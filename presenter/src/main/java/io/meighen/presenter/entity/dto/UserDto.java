package io.meighen.presenter.entity.dto;


import io.meighen.presenter.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type User dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public long id;
    public String firstName;
    public String secondName;
    public String lastName;
    public String username;
    public String email;
    public String phoneNumber;
    public RoleDto role;
}
