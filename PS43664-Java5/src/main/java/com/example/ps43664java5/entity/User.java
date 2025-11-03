package com.example.ps43664java5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @NotBlank(message = "ID không được để trống")
    private String id;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 3, max = 100, message = "Họ tên phải từ 3–100 ký tự")
    private String fullname;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ") //là annotation của Bean Validation (Jakarta Validation)
    //@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$\n", message="Email không hợp lệ" )
    private String email;

    @NotBlank(message = "Password không được để trống")
    @Size(min = 3, max = 20, message = "Password phải từ 3–20 ký tự")
    private String password;

    @Column(name = "Admin")
    private Boolean admin;
}
