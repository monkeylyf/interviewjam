# https://leetcode.com/problems/design-browser-history/

class BrowserHistory:

    def __init__(self, homepage: str):
        self.history = [homepage]
        self.cur = 0

    def visit(self, url: str) -> None:
        while self.cur != len(self.history) - 1:
            self.history.pop()
        self.history.append(url)
        self.cur += 1

    def back(self, steps: int) -> str:
        if self.cur < steps:
            self.cur = 0
        else:
            self.cur = self.cur - steps
        return self.history [self.cur]


    def forward(self, steps: int) -> str:
        if self.cur + steps >= len(self.history):
            self.cur = len(self.history) - 1
        else:
            self.cur += steps
        return self.history[self.cur]


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)
