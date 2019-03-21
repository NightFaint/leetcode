#coding:utf-8
__author__ = 'NightFaint'
__date__ = '2018/7/20 20:24'

import heapq


class Solution:
    def minRefuelStops(self, target, startFuel, stations):
        """
        :type target: int
        :type startFuel: int
        :type stations: List[List[int]]
        :rtype: int
        """
        stations.append([target, 0])
        self.tank = startFuel
        self.pq_passed = []  # 最小优先队列，记录我们经过的加油站的汽油量
        self.visit = 0  # 停靠加油次数
        for mile, gas in stations:
            # 如果现有的油不够到达当前加油站，我们应该在此之前加油
            if self.tank < mile:
                self.fill_tank_until_enough_to_cur_stations(mile)
                # 如果从之前经过的加油站加油后仍不能到达当前加油站，则返回-1
                if self.tank < mile:
                    return -1
            # 我们能够经过这个加油站，负号是因为最小优先队列
            heapq.heappush(self.pq_passed, -gas)
        return self.visit

    # 从之前经过的加油站中最大储油量的加油，直到没有加油站可以加或者现有油量足够到达当前加油站
    def fill_tank_until_enough_to_cur_stations(self, cur_sta_miles):
        while self.pq_passed and self.tank < cur_sta_miles:
            self.tank -= heapq.heappop(self.pq_passed)
            self.visit += 1
