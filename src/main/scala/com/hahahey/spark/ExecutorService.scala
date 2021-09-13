package com.hahahey.spark

import java.io.ObjectInputStream
import java.net.{ServerSocket, Socket}

object ExecutorService {
  def main(args: Array[String]): Unit = {
    val server = new ServerSocket(9999)
    println("服务器启动，等待接收数据")

    //等待客户端的连接
    val client = server.accept()
    val stream = client.getInputStream
    //val i = stream.read()

    val objInp = new ObjectInputStream(stream)
    val value = objInp.readObject().asInstanceOf[Task]
    val compute = value.compute
    println("接收到客户端发送的数据  " + compute)

    objInp.close()
    stream.close()
    client.close()
    server.close()

  }

}
