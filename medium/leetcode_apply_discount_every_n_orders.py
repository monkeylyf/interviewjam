# https://leetcode.com/problems/apply-discount-every-n-orders/

class Cashier:

    def __init__(self, n: int, discount: int, products: List[int], prices: List[int]):
        self.n = n
        self.discount = 1- discount / 100
        self.by_product = {products[i]: prices[i] for i in range(len(products))}
        self.i = 0

    def getBill(self, product: List[int], amount: List[int]) -> float:
        acc = 0
        n = len(product)
        for i in range(n):
            amo = amount[i]
            price = self.by_product[product[i]]
            acc += amo * price
        self.i += 1
        if self.i % self.n == 0:
            self.i = 0
            acc = acc * self.discount
        return acc


# Your Cashier object will be instantiated and called as such:
# obj = Cashier(n, discount, products, prices)
# param_1 = obj.getBill(product,amount)
