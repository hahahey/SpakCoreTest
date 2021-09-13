package com.hahahey.framework.application

import com.hahahey.framework.common.TApplication
import com.hahahey.framework.controller.WordCountController

object WordCountApp extends App with TApplication {
  start() {
    val controller = new WordCountController
    controller.dispatcher()
  }
}
