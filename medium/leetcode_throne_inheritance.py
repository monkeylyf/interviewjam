# https://leetcode.com/problems/throne-inheritance/
# Input
# ["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"]
# [["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
# Output
# [null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"], null, ["king", "andy", "matthew", "alex", "asha", "catherine"]]

# Explanation
# ThroneInheritance t= new ThroneInheritance("king"); // order: king
# t.birth("king", "andy"); // order: king > andy
# t.birth("king", "bob"); // order: king > andy > bob
# t.birth("king", "catherine"); // order: king > andy > bob > catherine
# t.birth("andy", "matthew"); // order: king > andy > matthew > bob > catherine
# t.birth("bob", "alex"); // order: king > andy > matthew > bob > alex > catherine
# t.birth("bob", "asha"); // order: king > andy > matthew > bob > alex > asha > catherine
# t.getInheritanceOrder(); // return ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
# t.death("bob"); // order: king > andy > matthew > bob > alex > asha > catherine
# t.getInheritanceOrder(); // return ["king", "andy", "matthew", "alex", "asha", "catherine"]

from typing import List

class ThroneInheritance:

    def __init__(self, kingName: str):
        self.name = kingName
        self.inheritance = {kingName: [False, []]}

    def birth(self, parentName: str, childName: str) -> None:
        self.inheritance[parentName][1].append(childName)
        self.inheritance[childName] = [False, []]

    def death(self, name: str) -> None:
        self.inheritance[name][0] = True

    def getInheritanceOrder(self) -> List[str]:
        def preorder(node, acc, inheritance):
            is_dead, children = inheritance[node]
            if not is_dead:
                acc.append(node)

            for c in children:
                preorder(c, acc, inheritance)

        order = []
        preorder(self.name, order, self.inheritance)
        return order


# Your ThroneInheritance object will be instantiated and called as such:
t = ThroneInheritance("king")
t.birth("king", "andy")
t.birth("king", "bob")
t.birth("king", "catherine")
t.birth("andy", "matthew")
t.birth("bob", "alex")
t.birth("bob", "asha")
t.death('bob')
print(t.getInheritanceOrder())
