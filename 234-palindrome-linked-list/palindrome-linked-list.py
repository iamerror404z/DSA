# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # Step 1: Use a fast and slow pointer to find the middle of the linked list
        fast = slow = head
        stack = []

        while fast and fast.next:
            stack.append(slow.val)
            slow = slow.next
            fast = fast.next.next

        # Step 2: If the linked list has an odd number of elements, skip the middle element
        if fast:
            slow = slow.next

        # Step 3: Compare the second half of the linked list with the stack
        while slow:
            top = stack.pop()
            if slow.val != top:
                return False
            slow = slow.next

        return True
