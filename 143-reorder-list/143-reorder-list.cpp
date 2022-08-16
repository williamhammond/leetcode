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
    void reorderList(ListNode* head) {
        if ((!head) || (!head->next) || (!head->next->next)) {
            return;
        }
        
        std::stack<ListNode*> node_stack;
        ListNode* current = head;
        while (current) {
            node_stack.push(current);
            current = current->next;
        }
        
        current = head;
        auto size = node_stack.size();
        for (int i = 0; i < size / 2; i++) {
            ListNode* top = node_stack.top();    
            node_stack.pop();
            top->next = current->next;
            current->next = top;
            current = current->next->next;
        }
        current->next = nullptr;
    }
    
};