package com.hahahey.arithmetic

import org.apache.spark.{SparkConf, SparkContext}

object MapPartitionsTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("mapPartitions").setMaster("local[2]")
    val context = new SparkContext(conf)

    val rdd = context.makeRDD(List(1,2,3,4,5,6),3)
    val mapRdd = rdd.mapPartitions(par => {
      par.map(_*2)
    })

    val mapParIndexRdd = rdd.mapPartitionsWithIndex((index,par) => {
      (index,par) match {
        case (1,par) => par.map(_*2)
        case _ => par
      }

    })
    mapParIndexRdd.collect().foreach(println(_))
  }
}
