package top.ruandb.leetcode

object LeetCode2 {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var L1 = l1
    var L2 = l2
    //进位数
    var carry = 0
    var current = new ListNode(0)
    var head = current
    while (L1 != null || L2 != null || carry != 0) {
      var t1, t2 = 0
      if (L1 != null) {
        t1 = L1._x
        L1 = L1.next
      }
      if (L2 != null) {
        t2 = L2._x
        L2 = L2.next
      }
      var cur = new ListNode((t1 + t2 + carry) % 10)
      carry = (t1 + t2 + carry) / 10
      current.next = cur
      current = current.next
    }
    head.next
  }
}
