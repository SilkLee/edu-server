package com.silklee.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@ApiModel("分页数据")
public class PageVO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总记录数
     */
    @ApiModelProperty("总记录数")
    private int totalCount;
    /**
     * 每页记录数
     */
    @ApiModelProperty("每页记录数")
    private int pageSize;
    /**
     * 总页数
     */
    @ApiModelProperty("总页数")
    private int totalPage;
    /**
     * 当前页数
     */
    @ApiModelProperty("当前页数")
    private int currPage;
    /**
     * 列表数据
     */
    @ApiModelProperty("列表数据")
    private List<T> list;

    public PageVO() {
    }

    /**
     * 分页
     *
     * @param list       列表数据
     * @param totalCount 总记录数
     * @param pageSize   每页记录数
     * @param currPage   当前页数
     */
    public PageVO(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

//    /**
//     * 分页
//     */
//    public PageVO(IPage<T> page) {
//        this.list = page.getRecords();
//        this.totalCount = (int) page.getTotal();
//        this.pageSize = (int) page.getSize();
//        this.currPage = (int) page.getCurrent();
//        this.totalPage = (int) page.getPages();
//    }
//
//    public PageVO(IPage<T> page, List<T> list) {
//        this.list = list;
//        this.totalCount = (int) page.getTotal();
//        this.pageSize = (int) page.getSize();
//        this.currPage = (int) page.getCurrent();
//        this.totalPage = (int) page.getPages();
//    }


}
