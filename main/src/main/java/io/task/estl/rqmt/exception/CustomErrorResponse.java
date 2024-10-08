package io.task.estl.rqmt.exception;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CustomErrorResponse {
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}