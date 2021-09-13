package com.hahahey.framework.service

import com.hahahey.framework.common.TService
import com.hahahey.framework.dao.WordCountDao

/**
 * 服务层
 */
class WordCountService extends TService {

  private val wordCountDao = new WordCountDao()

  def dataAnalysis(): Array[(String, Int)] = {
    val lines = wordCountDao.readFile("F:\\aaa.txt")
    lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect()
  }
}
