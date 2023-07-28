package org.twave.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
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

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Task other = (Task) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getPrintCharacters() == null ? other.getPrintCharacters() == null : this.getPrintCharacters().equals(other.getPrintCharacters()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getIntervalTime() == null ? other.getIntervalTime() == null : this.getIntervalTime().equals(other.getIntervalTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getPrintCharacters() == null) ? 0 : getPrintCharacters().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getIntervalTime() == null) ? 0 : getIntervalTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", printCharacters=").append(printCharacters);
        sb.append(", num=").append(num);
        sb.append(", intervalTime=").append(intervalTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}