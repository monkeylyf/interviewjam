"""facebook_Implement_Second_Minute_Hour_Day_Counters
facebook/google

Given a server that has tons of requests coming in. Design a data structure such
that you can fetch the count of the number requests in the last second, minute,
hour and day.
"""


class Counters(object):

    """Counters class.

    Using array to store the last minute/hour/day counts with one second granuarity.

    The challenge is how to handle the concurrency with huge incoming traffic.

    Using lock to handle concurrency. Say 10,000 requests to update the counter
    every second, lock and unlock but it will bring poor performance.

    I am thinking to have a buffer lay to accumulate the requests first with .5 second
    granularity and the counters get updates from the buffer lay instead of from servers
    directly that generate (timestamp, counter)

    And think about the performance request? Do you really need the real-time counts? Is
    a few second latency is allowed? Or even a few minutes latency is allowed?
    """

    minute_capacity = 60
    hour_capacity = 60 * 60
    day_capacity = 24 * 60 * 60
    
    def __init__(self):
        """Init circular array."""
        self.minute_circle = [ 0 ] * self.minute_circle
        self.hour_circle = [ 0 ] * self.hour_capacity
        self.day_circle = [ 0 ] * self.day_capacity

        self._last_minute_count = 0
        self._last_hour_count = 0
        self._last_day_count = 0
        
    def update(ts, count):
        """Update circular array and counts. O(1)."""
        # Update minute circle
        minute_idx = ts % self.minute_capacity
        self._last_minute_count -= self.minute_capacity[minute_idx]
        self.minute_circle[minute_idx] = count
        self._last_minute_count += count

        # Update hour circle
        hour_idx = ts % self.hour_capacity
        self._last_hour_count -= self.hour_capacity[hour_idx]
        self.hour_circle[hour_idx] = count
        self._last_hour_count += count

        # Update day circle
        day_idx = ts % self.day_capacity
        self._last_day_count -= self.hour_capacity[day_idx]
        self.day_circle[day_idx] = count
        self._last_day_count += count

    def get_last_min():
        """Get method for minute count. O(1)"""
        return self._last_minute_count

    def get_last_hour():
        """Get method for hour count. O(1)"""
        return self._last_hour_count

    def get_last_day():
        """Get method for day count. O(1)"""
        return self._last_day_count


def main():
    counter = Counters()


if __name__ == '__main__':
    main()
