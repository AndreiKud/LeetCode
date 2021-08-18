/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * class ImmutableListNode {
 *     fun getNext(): ImmutableListNode? {} // return the next node.
 *     fun printValue() {} // print the value of this node.
 * };
 */

class Solution {
    fun printRec(node: ImmutableListNode?) {
        if (node == null) {
            return            
        }
        
        printRec(node!!.getNext())
        node!!.printValue()
    }
    
	fun printLinkedListInReverse(head: ImmutableListNode?) {
        printRec(head)
    }
}