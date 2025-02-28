package com.nowcoder;

/**
 * 复杂链表的复制
 * @author Administrator
 *
 *解题思路：遍历链表，复制每个节点插入到原节点的后面，
 *		重新遍历链表，将原节点的随机指针复制给新节点
 *		将链表拆分为原链表和新链表
 */
public class Test25 {
	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        
        RandomListNode currentNode = pHead;
        while(currentNode != null) {
        	RandomListNode cloneNode = new RandomListNode(currentNode.label);
        	cloneNode.next = currentNode.next;
        	currentNode.next = cloneNode;
        	currentNode = cloneNode.next;
        	
        }
        
        currentNode = pHead;
        while(currentNode != null) {
        	currentNode.next.random = (currentNode.random == null) ? null : currentNode.random.next;
        	currentNode = currentNode.next.next;
        }
        
        currentNode = pHead;
        RandomListNode pCloneHead = currentNode.next;
        while(currentNode != null) {
        	RandomListNode cloneNode = currentNode.next;
        	currentNode.next = cloneNode.next;
        	cloneNode.next = (cloneNode.next == null) ? null : cloneNode.next.next;
        	currentNode = currentNode.next;
        }
        
        return pCloneHead;
        
    }
}

