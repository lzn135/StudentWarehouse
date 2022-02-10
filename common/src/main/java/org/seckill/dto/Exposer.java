package org.seckill.dto;

import lombok.Data;

/**
 * 暴露秒杀接口 DTO
 */
@Data
public class Exposer {
	// 秒杀开启标识
	private boolean exposed;

	// md5 加密
	private String md5;

	// 商品 id
	private long seckillId;

	// 系统时间（毫秒）
	private long now;

	// 开始时间
	private long start;

	// 结束时间
	private long end;

	public Exposer(boolean exposed, String md5, long seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposed, long seckillId) {
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

}