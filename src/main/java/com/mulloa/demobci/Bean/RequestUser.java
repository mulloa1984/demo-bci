package com.mulloa.demobci.Bean;

import java.util.List;

import com.mulloa.demobci.Model.Phone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestUser {
	String name;
    String email;
    String password;
    List<Phone> phones;
}
