package com.hahahey.framework.controller

import com.hahahey.framework.common.TController
import com.hahahey.framework.service.WordCountService

/**
 * 控制层
 */
class WordCountController extends TController {

  private val service = new WordCountService()

  //调度
  def dispatcher(): Unit = {
    val array = service.dataAnalysis()
    array.foreach(println)
  }
}
