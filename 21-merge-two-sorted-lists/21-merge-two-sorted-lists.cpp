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
        ListNode* current = nullptr;
        ListNode* head = nullptr;
        while (a && b)  {
            if (a->val < b->val) {
                if (!head) {
                    head= a;
                    current = head;
                } else {
                    current -> next = a;
                    current = current -> next;
                }
                a = a->next;
            } else {
                if (!head) {
                    head = b;
                    current = head;
                } else {
                    current -> next = b;
                    current = current -> next;
                }
                b = b->next;
            }
        }
        
        while (a) {
            current->next = a;    
            current = current->next;
            a = a -> next;
        }
        
        while (b) {
            current->next = b;
            current = current->next;
            b = b -> next;
            
        }
        return head;
    }
};