-- 创建数据库
CREATE DATABASE seckill;

-- 使用数据库
USE seckill;

-- 创建秒杀商品表单，
-- 这里需要注意的是，对数据库字段的引用需要使用反引号``（也就是键盘 esc 下面的那个，不然会报语法错误），COMMENT 注释用 '' 平常的单引号
-- 在创建完毕表单过后可以使用 show create table table_name 来查看具体创建表单的 sql 语句是什么

CREATE TABLE seckill
(
    `seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `name` VARCHAR(120) NOT NULL COMMENT '商品名',
    `number` BIGINT NOT NULL COMMENT '商品数量',
    `start_time` TIMESTAMP NOT NULL COMMENT '开始时间',
    `end_time` TIMESTAMP NOT NULL COMMENT '结束时间',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', -- 当 TIMESTAMP 类型设置了 DEFAULT CURRENT_TIMESTAMP 属性过后，如果不指定值，则会用当前时间进行填充
    PRIMARY KEY (seckill_id),
    KEY idx_start_time (start_time),
    KEY idx_end_time (end_time),
    KEY idx_create_time (create_time)
)ENGINE = InnoDB
AUTO_INCREMENT = 1000 -- 让表中的自增字段从 1000 开始自增
DEFAULT CHARSET = utf8 COMMENT = '秒杀库存表'; -- 注意：字符编码格式是 utf8 不是 utf-8

-- 初始化数据
-- create_time 是自动填充，所以我们这里就不管了
INSERT INTO seckill (name,number,start_time,end_time)
values ('1000元秒杀IPhone 12', 100, '2021-01-18 00:00:00', '2021-01-19 00:00:00'),
       ('10元秒杀垃圾袋', 1000, '2021-01-16 00:40:00', '2021-01-19 00:00:00'),
       ('36元秒杀大米', 10000, '2021-01-17 08:00:00', '2021-01-20 00:00:00'),
       ('500元秒杀大会员', 999, '2021-01-18 10:00:00', '2021-01-25 00:00:00');


-- 创建秒杀成功明细表，记录用户的相关信息
CREATE TABLE success_killed
(
    `seckill_id` BIGINT NOT NULL COMMENT '商品 ID ', -- 这里不设置自增是因为后面的 ID 值都是记录传过来的值，所以不需要自增
    `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
    `state` TINYINT NOT NULL DEFAULT 0 COMMENT '秒杀单状态', -- 这里设计了一个状态标识码，用来识别秒杀单的状态，具体状态值后面通过枚举类来设计，先写个0占位
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', -- 跟上面一样，自动填充
    PRIMARY KEY (seckill_id,user_phone), -- 联合主键，保证秒杀信息的唯一性
    KEY idx_create_time (create_time)
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8 COMMENT = '秒杀成功明细表';