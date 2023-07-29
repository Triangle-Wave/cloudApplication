package org.twave.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.twave.entity.Task;

import java.util.List;

/**
 * 操作数据库的Mapper接口
 *
 * @author TWAVE
 * @description 针对表【task】的数据库操作Mapper
 * @createDate 2023-07-28 15:33:07
 * @Entity org.twave.entity.Task
 */
@Mapper
public interface TaskMapper {
    // 获取所有任务
    List<Task> getAllTask();
}




