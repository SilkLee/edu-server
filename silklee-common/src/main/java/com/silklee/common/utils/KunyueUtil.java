package com.silklee.common.utils;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 昆岳通用工具类
 *
 * @author Administrator
 * @date 2020-04-23 10:41
 */
public class KunyueUtil {

    /**
     * 按秒计算周期
     */
    static final List<BeautifyTime> periods = new ArrayList<BeautifyTime>() {
        {
            add(new BeautifyTime(1, "刚刚", 1L, 60L, false));
            add(new BeautifyTime(2, "{}分钟前", 60L, 3600L, true));
            add(new BeautifyTime(3, "{}小时前", 3600L, 86400L, true));
            add(new BeautifyTime(4, "{}天前", 86400L, 592200L, true));
            add(new BeautifyTime(5, "{}周前", 592200L, 2592000L, true));
            add(new BeautifyTime(5, "{}月前", 2592000L, 31536000L, true));
            add(new BeautifyTime(5, "{}年前", 31536000L, Long.MAX_VALUE, true));
        }
    };

    /**
     * 时间美化（用于发布时间美化）
     *
     * @param dateTime 需要美化时间
     */
    public static String getBeautifyTime(LocalDateTime dateTime) {
        // 时间差
        long diffSecond = Duration.between(dateTime, LocalDateTime.now()).getSeconds();
        // 结果默认为空
        String result = "";
        // 遍历时间周期
        for (BeautifyTime period : periods) {
            if (diffSecond < period.getMax()) {
                result = period.isNum ? StrUtil.format(period.suffix, diffSecond / period.getStep()) : period.suffix;
                break;
            }
        }
        return result;
    }

    /**
     * 美化时间
     */
    @Data
    @AllArgsConstructor
    public static class BeautifyTime {
        /**
         * 排序
         */
        private int sort;
        /**
         * 后缀
         */
        private String suffix;
        /**
         * 计算步长
         */
        private Long step;
        /**
         * 区间上线
         */
        private Long max;
        /**
         * 是否追加数字
         */
        private boolean isNum;
    }
}
