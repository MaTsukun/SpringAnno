package com.elead.bai.controller;

import com.elead.bai.pojo.ResultBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class AdviceController
{
	@ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBean<String> errorHandler(Exception ex) {
		return ResultBean.getFaild(ex.getMessage(), null);
    }
}
