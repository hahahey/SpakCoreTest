package com.hahahey.arithmetic

import org.apache.spark.{SparkConf, SparkContext}

object GlomTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("GlomTest").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(List(1, 2), List(3, 4), List(5, 6)), 3)
    rdd.mapPartitionsWithIndex(
      (index, datas) => {
        println(index + "  " + datas.next().mkString(","))
        datas
      }
    ).collect()

    val value = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 1, 2, 3), 2)
    value.glom().foreach(f => {
      println(f.mkString(","))
      f
    })
    println("------")
    value.map((_, null)).reduceByKey((x, y) => x, 2).map(_._1).collect().foreach(println)

  }
}
