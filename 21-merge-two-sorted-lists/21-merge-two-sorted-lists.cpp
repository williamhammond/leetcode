/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* a, ListNode* b) {
        if (!a) {
            return b;
        }
        if (!b) {
            return a;
        }
        ListNode* head =  new ListNode();
        ListNode* current = head;
        while (a && b)  {
            if (a->val < b->val) {
                current->next = a;
                current = current->next;
                a = a->next;
            } else {
                current->next = b;
                current = current->next;
                b = b->next;
            }
        }
        
        if (a) {
            current->next = a;
        }
        if (b) {
            current->next = b;
        }
        
        return head->next;
    }
};