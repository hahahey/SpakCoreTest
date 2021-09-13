package com.hahahey.transformer

import com.hahahey.spark.SparkUtils

object MapPartitionsDemo {
  def main(args: Array[String]): Unit = {

    val context = SparkUtils.getContext
    val rdd = context.makeRDD(List(1, 2, 3, 4), 2)

    rdd.mapPartitions(iter => {
      iter.map(_ * 2)
    }).collect().foreach(println)


  }
}
