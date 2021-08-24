package com.zjtd.userprofile.bean



/**
 * @Author wangwenbo
 * @Date 2021/7/5 11:24 下午
 * @Version 1.0
 */
import java.util.Date
import java.lang.Long
case class TagInfo(var id:java.lang.Long,
                   var tagCode:String,
                   var tagName:String,
                   var tagLevel:java.lang.Long,
                   var parentTagId:java.lang.Long,
                   var tagType:String,
                   var tagValueType:String,
                   var  tagValueLimit:java.lang.Long,
                   var  tagValueStep:java.lang.Long,
                   var  tagTaskId:java.lang.Long,
                   var  tagComment:String,
                   var  createTime:Date,
                   var  updateTime:Date
                  ) {
  def this()  ={
    this(null,null,null,null,null,null,null,null,null,null,null,null,null)
  }
}

