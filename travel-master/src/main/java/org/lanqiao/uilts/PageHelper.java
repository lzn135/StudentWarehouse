package org.lanqiao.uilts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: TravelDream
 * @BelongsPackage: com.travel.utils
 * @CreateTime: 2021-05-18 09:40
 * @Description: 分页工具类(封装数据)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
 public class PageHelper<T> {
	private Long currentPage;
	//当前页码
	private Long pageSize;
	//页面大小
	private Long pageTotal;
	//总页数
	private Long countTotal;
	//总条数
	private List<T> records;
	//查询的数据
}
