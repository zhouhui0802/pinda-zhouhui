package com.zh.controller.user;

import com.zh.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "user controller")
public class UserController {

    @GetMapping("/getUsers")
    @ApiOperation(value = "query all the users", notes = "query the information of the all users")
    public List<User> getAllUsers(){
        User user = new User();
        user.setId(100);
        user.setName("zhouhui");
        user.setAge(20);
        user.setAddress("beijing");
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }

    @PostMapping("/save")
    @ApiOperation(value = "add the user", notes = "add the information of the user")
    public String save(@RequestBody User user){
        return "OK";
    }

    @PutMapping("/update")
    @ApiOperation(value = "update the user", notes = "update the information of the user")
    public String update(@RequestBody User user){
        return "OK";
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "delete the user", notes = "delete the information of the user")
    public String delete(int id){
        return "OK";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "pageNum",
                    required = true, type = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "itmes of every page",
                    required = true, type = "Integer"),
    })
    @ApiOperation(value = "query the information of the selected user")
    @GetMapping(value = "page/{pageNum}/{pageSize}")
    public String findByPage(@PathVariable Integer pageNum,
                             @PathVariable Integer pageSize) {
        return "OK";
    }
}
