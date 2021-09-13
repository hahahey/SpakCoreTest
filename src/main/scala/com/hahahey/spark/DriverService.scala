package com.hahahey.spark

import java.io.ObjectOutputStream
import java.net.{ServerSocket, Socket}


//Driver端
object DriverService {
  def main(args: Array[String]): Unit = {
    val driver = new Socket("localhost", 9999)

    val out = driver.getOutputStream
    //out.write(1)
    val stream = new ObjectOutputStream(out)
    val task = new Task()
    stream.writeObject(task)
    stream.flush()
    stream.close()

    out.close()
    driver.close()
    println("客户端数据发送完毕")
  }
}
