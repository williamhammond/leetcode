class StreamChecker:
    def __init__(self, words: List[str]):
        self.trie = self.make_trie(words)
        self.current_stream = []
        print(self.trie)
        

    def query(self, letter: str) -> bool:
        _end = '_end_'
        
        stream = []
        if letter in self.trie:
            stream.append(self.trie[letter])
        for item in self.current_stream:
            if letter in item:
                stream.append(item[letter])
                
        self.current_stream = stream 
        return any(_end in item for item in self.current_stream)

    
    def make_trie(self, words):
        _end = '_end_'
        root = dict()
        for word in words:
            current_dict = root
            for letter in word:
                current_dict = current_dict.setdefault(letter, dict()) 
            current_dict[_end] = _end
        return root
    
        


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)