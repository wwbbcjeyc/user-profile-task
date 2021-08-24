package com.zjtd.userprofile.bean

/**
 * @Author wangwenbo
 * @Date 2021/7/5 11:27 下午
 * @Version 1.0
 */
import java.lang.Long

case class TaskTagRule(var id:java.lang.Long,
                       var tagId:java.lang.Long,
                       var  taskId:java.lang.Long,
                       var  queryValue:String,
                       var  subTagId:java.lang.Long,
                       var   subTagValue:String) {
  def this()  ={
    this(null,null,null,null,null,null  )
  }

}

