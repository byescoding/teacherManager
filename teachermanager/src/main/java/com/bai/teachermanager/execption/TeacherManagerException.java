package com.bai.teachermanager.execption;

import com.bai.teachermanager.utils.ResultCode;
import lombok.Data;

@Data
public class TeacherManagerException extends RuntimeException{

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public TeacherManagerException(Integer code, String message) {
        super(message);
        this.setCode(code);
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public TeacherManagerException(ResultCode resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.setCode(resultCodeEnum.getCode());
    }

    @Override
    public String toString() {
        return "CollegeException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
