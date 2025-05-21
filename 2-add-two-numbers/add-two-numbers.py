# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1, l2):
        dummy = ListNode(0)  # Dummy node to act as the head of the result linked list
        current = dummy
        carry = 0

        while l1 or l2 or carry:
            val1 = l1.val if l1 else 0  # Value from l1 or 0 if l1 is None
            val2 = l2.val if l2 else 0  # Value from l2 or 0 if l2 is None

            # Calculate the sum and carry
            total = val1 + val2 + carry
            carry = total // 10
            new_val = total % 10

            # Create a new node for the current digit and attach it to the result
            current.next = ListNode(new_val)
            current = current.next

            # Move to the next nodes
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

        return dummy.next  # Return the result list starting from the next node to dummy
