package com.mulloa.demobci.Bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUser {
	String id;
	String createdAt;
	String updatedAt;
    String token; 
    String isActive;
}

