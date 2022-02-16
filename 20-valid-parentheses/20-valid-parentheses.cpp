class Solution {
public:
    bool isValid(string s) {
        stack<char> tokens;
        for (int i = 0; i < s.length(); i++) {
            char c = s[i] ;
            if (c == '(') {
                tokens.push(')');
            }
            else if (c == '{') {
                tokens.push('}');
            }
            else if (c == '[') {
                tokens.push(']');
            }
            else if (tokens.empty() || tokens.top() != c) {
                return false;
            } 
            else {
                tokens.pop();
            }
        }
        return tokens.empty();
    }
    
};