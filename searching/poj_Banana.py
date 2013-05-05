# py version of poj_banana.
# 
# sorting with key in py is way too convinient than in java

class Cell:
    def __init__(self, x, y, index):
        self.x = x
        self.y = y
        self.index = index

    def __repr__(self):
        return repr((self.x, self.y))


def solve(trees, n, k):
    def find(parents, i):
        if parents[i] != i:
            parents[i] = find(parents, parents[i])
        return parents[i]

    def union(parents, size, x, y):
        i = find(parents, x)
        j = find(parents, y)
        if i == j:
            return
        if (size[i] < size[j]):
            parents[i] = j
            size[j] += size[i]
        else:
            parents[j] = i;
            size[i] += size[j]
        
    cells = [ Cell(trees[i][0], trees[i][1], i) for i in range(n) ]
    size = [ 1 for _ in range(n)]
    parents = [i for i in range(n) ]

    cells = sorted(sorted(cells, key=lambda cell: cell.y), key= lambda cell: cell.x)
    for i in range(1, n):
        if cells[i].x == cells[i - 1].x and cells[i].y - cells[i - 1].y == 1:
            union(parents, size, cells[i].index, cells[i - 1].index)

    cells = sorted(sorted(cells, key=lambda cell: cell.x), key= lambda cell: cell.y)
    for i in range(1, n):
        if cells[i].y == cells[i - 1].y and cells[i].x - cells[i - 1].x == 1:
            union(parents, size, cells[i].index, cells[i - 1].index)

    size.sort()
    print sum(size[-k:])


if __name__ == '__main__':
    trees = [[ 7, 10 ], [ 1, 1 ], [ 101, 1 ], [ 2, 2 ], [ 102, 1 ], [ 7, 11 ],
             [ 200, 202 ], [ 2, 1 ], [ 3, 2 ], [ 103, 1 ] ]
    solve(trees, 10, 3)
