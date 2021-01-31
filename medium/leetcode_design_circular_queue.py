# https://leetcode.com/problems/design-circular-queue/

class MyCircularQueue:

    def __init__(self, k: int):
        self.q = [None] * k
        self.h = 0
        self.t = 0
        self.k = k

    def enQueue(self, value: int) -> bool:
        if self.isFull():
            return False
        self.q[self.t] = value
        self.t = (self.t + 1) % self.k
        return True

    def deQueue(self) -> bool:
        if self.isEmpty():
            return False
        self.q[self.h] = None
        self.h = (self.h + 1) % self.k
        return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        return self.q[self.h]

    def Rear(self) -> int:
        print(self.q, self.h, self.t)
        if self.isEmpty():
            return -1
        i = self.t - 1
        if i < 0:
            i += self.k
        return self.q[i]

    def isEmpty(self) -> bool:
        return self.h == self.t and self.q[self.h] is None

    def isFull(self) -> bool:
        return self.h == self.t and self.q[self.h] is not None


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()
