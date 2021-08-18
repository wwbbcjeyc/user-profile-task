package com.zjtd.userprofile.dao

import com.zjtd.userprofile.bean.TaskInfo
import com.zjtd.userprofile.util.MySqlUtil

/**
 * @Author wangwenbo
 * @Date 2021/8/18 10:42 下午
 * @Version 1.0
 */
object TaskInfoDAO {

  def getTaskInfo( taskId:String): TaskInfo ={
    val taskInfoSql: String =
      s"""select id,task_name,
         | task_status,task_comment,task_time ,
         | task_type,exec_type,main_class,file_id,
         | task_args,task_sql,task_exec_level,create_time
         | from task_info where id=$taskId""".stripMargin
    val taskInfoOpt: Option[TaskInfo] =
      MySqlUtil.queryOne(taskInfoSql, classOf[TaskInfo], true)
    var taskInfo: TaskInfo = null;
    if (taskInfoOpt != None) {
      taskInfo = taskInfoOpt.get
    } else {
      throw new RuntimeException("no task  for task_id  : "+taskId)
    }
    taskInfo
  }

}
