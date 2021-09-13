package com.hahahey.transformer

import org.apache.spark.{SparkConf, SparkContext}

object DemoGroupBy {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName("Group")
      .setMaster("local[2]")

    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(1, 2, 3, 4), 2)
    rdd.groupBy(_ * 1)
      .foreach(println(_))

  }
}
