package com.hahahey.spark

class Task extends Serializable {
  val list = List(1, 2, 3, 4)
  //val logic = (num: Int) => {num * 2}
  val logic: (Int => Int) = _ * 2

  def compute = {
    list.map(logic)
  }

}
