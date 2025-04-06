package com.example.sosbackend.util;

import com.example.sosbackend.response.ApiResponse;

public class ResponseUtil {

  public static <T> ApiResponse<T> response(T data, String message, String path) {
    ApiResponse<T> response = new ApiResponse<>();
    response.setSuccess(true);
    response.setMessage(message);
    response.setData(data);
    return response;
  }

}
