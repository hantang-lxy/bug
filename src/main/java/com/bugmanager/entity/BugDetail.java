package com.bugmanager.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/22  21:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BugDetail implements Serializable {
    private static final long serialVersionUID = 6621265085772434434L;
    /**
     * 编号
     */
    private Integer id;
    /**
     * 对应项目表的主键
     */
    private Integer projectId;

    /**
     * 严重性
     * 10：文字错误
     * 20：次要错误
     * 30：严重错误
     */
    private Integer severity;
    /**
     * 标题
     */
    private String title;
    /**
     * 报告人
     */
    private String reportUser;
    /**
     * 创建时间
     * JSONField:打印到页面时间显示的格式
     * DateTimeFormat：从页面上字符串返回到服务器需要转换为时间类型的格式
     */
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;


}
