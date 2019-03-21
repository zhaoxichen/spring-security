package com.galen.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "权限controller", tags = {"权限操作接口"})
@RestController
@RequestMapping("permission")
public class PermissionController {
}
