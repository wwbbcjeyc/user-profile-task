package com.zjtd.userprofile

/**
 * @Author wangwenbo
 * @Date 2021/7/4 11:38 下午
 * @Version 1.0
 *1、 根据TaskID 读取 任务的定义、规则、SQL    读取标签  名称
 *2、 每个标签都保存在对应的标志  一个标签对应一张表   根据定义 建立标签表（如果新标签）
 *3、 通过sql查询数据仓库中的数据 ，写入到标签表中
 *insert overwrite  table xxx  select xxx
 *根据定义规则进行拼接完成
 */

object TaskTagSqlApp {

}
