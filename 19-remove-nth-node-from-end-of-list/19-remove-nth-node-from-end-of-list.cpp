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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        vector<ListNode*> nodes = {};    
        ListNode* current = head;
        while (current) {
            nodes.push_back(current);
            current = current->next;    
        }
        
        auto idx = nodes.size() - n; 
        
        auto to_remove = nodes[idx];
        if (to_remove == head) {
            return head->next;
        }
        
        auto prev = nodes[idx - 1];
        prev->next = prev->next->next;
        
        return head;
    }
};