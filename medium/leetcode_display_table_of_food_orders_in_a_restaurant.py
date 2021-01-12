# https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/

from typing import List

class Solution:
    def displayTable(self, orders: List[List[str]]) -> List[List[str]]:
        head = set()
        by_table = {}
        for who, table, food in orders:
            head.add(food)
            food_count = by_table.get(table)
            if food_count is None:
                by_table[table] = food_count = {}
            count = food_count.get(food, 0)
            food_count[food] = count + 1
        tables = list(by_table.keys())
        tables.sort(key=int)

        header = ["Table"]
        res = [header]
        header.extend(sorted(list(head)))
        for table in tables:
            per_table = [table]
            mapping = by_table[table]
            for (i, food) in enumerate(header):
                if i > 0:
                    count = mapping.get(food, 0)
                    per_table.append(f'{count}')
            res.append(per_table)
        return res

