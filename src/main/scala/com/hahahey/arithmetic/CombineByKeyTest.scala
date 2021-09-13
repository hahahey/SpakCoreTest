package com.hahahey.arithmetic

import org.apache.spark.{SparkConf, SparkContext}

object CombineByKeyTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CombineByKeyTest").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(("tom", 98), ("jerry", 60), ("tom", 99), ("jerry", 61), ("tom", 100), ("jerry", 62)), 2)

    //    createCombiner: V => C, (key,value) 中 value 的处理函数
    //    mergeValue: (C, V) => C,  (V,value) 经处理后的 V和 value 处理函数
    //    mergeCombiners: (C, C) => C, 分区间 V 的处理函数
    rdd.combineByKey(
      (_, 1),
      (t1: (Int, Int), t2) => {
        (t1._1 + t2, t1._2 + 1)
      },
      (t1: (Int, Int), t2: (Int, Int)) => {
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    ).map( a => {
      (a._1,a._2._1/a._2._2)
    }).foreach(println)

  }
}
