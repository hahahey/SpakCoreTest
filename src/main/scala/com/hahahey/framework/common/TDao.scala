package com.hahahey.framework.common

import com.hahahey.framework.util.EnvUtil
import org.apache.spark.rdd.RDD

trait TDao {
  def readFile(path: String): RDD[String] = {
    EnvUtil.take().textFile(path)
  }
}
