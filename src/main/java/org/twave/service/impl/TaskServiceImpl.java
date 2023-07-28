package org.twave.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.twave.entity.Task;
import org.twave.service.TaskService;
import org.twave.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author TWAVE
* @description 针对表【task】的数据库操作Service实现
* @createDate 2023-07-28 15:32:20
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

}




