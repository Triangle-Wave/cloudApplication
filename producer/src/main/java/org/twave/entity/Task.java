package org.twave.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 任务实体类<p>
 * 每个任务的内容是在屏幕上打印指定字符，有打印的间隔时间和打印总量
 *
 * @author TWAVE
 * @TableName task
 */
@Data
public class Task implements Serializable {
    /**
     * 任务ID
     */
    private Integer taskId;

    /**
     * 要打印的字符
     */
    private String printCharacters;

    /**
     * 要打印的数量
     */
    private Integer num;

    /**
     * 打印字符的间隔时间
     */
    private Integer intervalTime;
}