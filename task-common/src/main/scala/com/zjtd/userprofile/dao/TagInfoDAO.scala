package com.zjtd.userprofile.dao

import com.zjtd.userprofile.bean.TagInfo
import com.zjtd.userprofile.util.MySqlUtil

/**
 * @Author wangwenbo
 * @Date 2021/8/18 10:41 下午
 * @Version 1.0
 */
object TagInfoDAO {

  def getTagInfoByTaskId(taskId:String): TagInfo ={
    val tagInfoOpt: Option[TagInfo] = MySqlUtil.queryOne[TagInfo](s"select * from tag_info where tag_task_id='$taskId'" ,classOf[TagInfo], true )
    if(tagInfoOpt==None){
      throw  new RuntimeException(s" no this taskId $taskId for tag !")
    }
     tagInfoOpt.get
  }
  //git remote set-url origin https://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@github.com/wwbbcjeyc/user-profile-task.git
  // 查询所有启用中的标签
  def getTagInfoListOnTask(): List[TagInfo] ={
    val tagInfoList: List[TagInfo] = MySqlUtil.queryList[TagInfo](s"select tg.* from tag_info tg join task_info tk on tg.tag_task_id = tk.id where  tk.task_status='1'   " ,classOf[TagInfo], true )
    tagInfoList
  }

}
