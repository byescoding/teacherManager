package com.bai.teachermanager.controller;

import com.bai.teachermanager.service.impl.AdminServiceImpl;
import com.bai.teachermanager.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("登录接口")
public class LoginController {
    @Autowired
    private AdminServiceImpl adminService;

     @ApiOperation("登录")
    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }
    @GetMapping("/info")
    public R info(){
        return    R.ok().data("name","admin").data("roles","[admin]")
                .data("avatar","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600707715038&di=8288669b559017cd99f1583adbc88964&imgtype=0&src=http%3A%2F%2Ft7.baidu.com%2Fit%2Fu%3D3616242789%2C1098670747%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D900%26h%3D1350");
    }
    @ApiOperation("登出")
    @PostMapping("/logout")
    public R logout(){
        return R.ok();
    }


}
