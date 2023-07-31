package org.twave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.twave.entity.Task;
import org.twave.service.impl.TaskServiceImpl;
import org.twave.util.JSONResult;

import static org.twave.constants.StatusCode.REQUEST_SUCCESS;

/**
 * @author : twave
 * @date : 2023/7/31 9:22
 */
@RestController
@RequestMapping("task")
public class AddTaskController {
    @Autowired
    TaskServiceImpl taskService;

    @PostMapping("/addtask")
    JSONResult<String> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new JSONResult<>(REQUEST_SUCCESS, "添加任务成功");
    }
}
