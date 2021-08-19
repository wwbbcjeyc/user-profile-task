package com.zjtd.userprofile

import com.zjtd.userprofile.bean.{TagInfo, TaskInfo, TaskTagRule}
import com.zjtd.userprofile.dao.{TagInfoDAO, TaskInfoDAO, TaskTagRuleDAO}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


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

  def main(args: Array[String]): Unit = {

    val sparkConf: SparkConf = new SparkConf().setAppName("task_tag_sql_app")
    .setMaster("local[*]")
    val sparkSession: SparkSession = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()


    //1、 根据TaskID 读取 任务的定义、规则、SQL    读取标签  名称
    // 1.1  taskId   //spark-submit结尾处 会带俩个参数  第一个参数是taskId  第二个参数是业务日期 ，一般是前一天的日期
    // spark-submit   --master ..xxxx.xx.     xxxxx.jar  1 2021-06-08
    val taskId: String = args(0)
    val taskDate: String = args(1)

    //  1.2  根据TaskID 读取tag_info
    val tagInfo: TagInfo = TagInfoDAO.getTagInfoByTaskId(taskId)
    // 1.3   根据TaskID    读取task_info
    val taskInfo: TaskInfo = TaskInfoDAO.getTaskInfo(taskId)
    //1.4  根据TaskID 读取task_tag_info
    val taskTagRuleList: List[TaskTagRule] = TaskTagRuleDAO.getTaskTagRuleListByTaskId(taskId)

    println(tagInfo)
    println(taskInfo)
    println(taskTagRuleList)

  }

}
