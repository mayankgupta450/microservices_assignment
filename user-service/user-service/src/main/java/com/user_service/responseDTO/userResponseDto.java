package com.user_service.responseDTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class userResponseDto {
	private LocalDateTime timestamp;
	private int status;
	private String error;
}
