package com.nanjing.controller;

import com.mysql.jdbc.StringUtils;
import com.nanjing.entity.User;
import com.nanjing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //根据name和phoneCode模糊查询
    @GetMapping("findLike")
    public List<User> findLike(String name,String phoneCode){
        return userService.findLike(name,phoneCode);
    }

    //根据id查询用户
    @GetMapping("findOne")
    public User findOne(String id){
        return userService.findOne(id);
    }

    //删除用户
    @GetMapping("delete")
    public Map<String,Object> delete(String id){
        Map<String, Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "删除用户失败");
        }
        return map;
    }

    //保存用户
    @PostMapping("save")
    public Map<String,Object> save(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        if(StringUtils.isNullOrEmpty(user.getId())){
            //id为空，则保存用户
            try {
                userService.save(user);
                map.put("success", true);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("message", "保存用户失败");
            }
        }else {
            //id不为空，则更新用户
            try {
                userService.update(user);
                map.put("success", true);
            } catch (Exception e) {
                e.printStackTrace();
                map.put("success", false);
                map.put("message", "更新用户失败");
            }
        }
        return map;
    }

    //查询所有
    @GetMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

}
