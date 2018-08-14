package top.ruandb.leetcode
object LeetCode1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.Map[Int, Int] ()
    var count = 0;
    for(num <- nums){
      val comp = target-num
      //匹配comp
      map.get(comp) match {
        case None => {map.put(num,count)}
        case Some(index) => return Array(index,count)
      }
      count = count+1
    }
    Array(0,0)
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(2, 7, 11, 15)
    twoSum(nums,9).foreach(print)
  }



}
