package com.parking.parkinglot.common;

public class UserDto {
    String email;
    String password;
    String username;
    Long id;

    public UserDto(String email, String password, String username, Long id) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }
}