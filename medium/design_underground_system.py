# https://leetcode.com/problems/design-underground-system/

class UndergroundSystem:

    def __init__(self):
        self.duration = 0
        self.by_id = {}
        self.by_s = {}

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.by_id[id] = [stationName, t]

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        [ss, t1] = self.by_id[id]
        self.by_id[id] = [ss, t, stationName, t]

        group_by_e = self.by_s.get(ss)
        if group_by_e is None:
            group_by_e = {}
            self.by_s[ss] = group_by_e
        group_by_time = group_by_e.get(stationName)
        if group_by_time is None:
            group_by_time = []
            group_by_e[stationName] = group_by_time
        group_by_time.append(t - t1)

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        acc = self.by_s[startStation][endStation]
        return sum(acc) / len(acc)


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)
