package com.hahahey.framework.common

import com.hahahey.framework.util.EnvUtil
import org.apache.spark.{SparkConf, SparkContext}

trait TApplication {
  def start(master: String = "local[*]", name: String = "applicaiton")(op: => Unit) = {
    val conf = new SparkConf().setAppName(name).setMaster(master)
    val sc = new SparkContext(conf)
    EnvUtil.put(sc)
    try {
      op
    } catch {
      case e => println(e.getMessage)
    }
    sc.stop()
    EnvUtil.clear()
  }
}
