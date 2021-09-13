package com.hahahey.arithmetic

import org.apache.spark.{SparkConf, SparkContext}

/**
 * JavaSerializer 方式对transient 注解标注的对象起作用，会对该字段不进行序列化
 * Kryo 序列化方式对 transient 注解标注的字段不起作用，也就是依然对该字段进行序列化
 * 使用Kryo序列化方式进行序列化的时候，需要在conf中注册需要序列化的对象
 *
 *
 */

object SerialTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("SerialTest")
    //使用Kryo序列化方式
//    conf.set("spark.serializer","org.apache.spark.serializer.KryoSerializer")
//      //将User对象注册到Kryo序列化中
//      .registerKryoClasses(Array(classOf[User]))

    val sc = new SparkContext(conf)
    val value = sc.makeRDD(Seq(1, 2, 3, 4, 5, 6), 3).map((_, 1)).reduceByKey(_ + _)
    value.collect()
    value.foreach(println)

    Thread.sleep(1000000)
  }
}


