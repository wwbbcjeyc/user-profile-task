package com.zjtd.userprofile.util

import java.io.InputStreamReader
import java.util.Properties

/**
 * @Author wangwenbo
 * @Date 2021/7/4 11:16 下午
 * @Version 1.0
 */
object MyPropertiesUtil {


  def main(args: Array[String]): Unit = {
    val properties: Properties =  MyPropertiesUtil.load("config.properties")
    println(properties.getProperty("data-warehouse.dbname"))
  }

  def load(propertieName:String): Properties ={
    val prop=new Properties();
    prop.load(new InputStreamReader(Thread.currentThread().getContextClassLoader.
      getResourceAsStream(propertieName) , "UTF-8"))
    prop
  }

}

