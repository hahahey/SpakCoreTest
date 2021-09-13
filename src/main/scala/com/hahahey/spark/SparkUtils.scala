package com.hahahey.spark

import org.apache.spark.{SparkConf, SparkContext}

object SparkUtils {

  def getContext: SparkContext = {
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("Demo")
    val sc = new SparkContext(conf)
    sc
  }


}
