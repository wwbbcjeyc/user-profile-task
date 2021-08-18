package com.zjtd.userprofile.bean

/**
 * @Author wangwenbo
 * @Date 2021/7/5 11:27 下午
 * @Version 1.0
 */
case class TaskTagRule(var id:Long,
                       var tagId:Long,
                       var  taskId:Long,
                       var  queryValue:String,
                       var  subTagId:Long,
                       var   subTagValue:String
                      ) {
  def this()  ={
    this(null,null,null,null,null,null  )
  }

}

