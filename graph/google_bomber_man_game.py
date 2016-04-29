"""Bomber man game
google

Given a 2D map,
"""

import unittest
from operator import itemgetter


def max_kill_with_one_bomb(maze):
    """Calculate max possible kills with one bomb.

    Bomb explodes in either vertical or horizontal direction.
    Bomb blast has infinite radius.
    Wall is solid enough so the blast cannot go through a wall.
    Any creatures die within a bomb blast.

    'x' -> wall
    'o' -> creature
    ' ' -> cell/path

    :param maze: list, of str
    :param return: int, max possible kills
    """
    rows = []
    columns = []
    for i, row in enumerate(maze):
        start = None
        creature = 0
        for j, char in enumerate(row):
            if char == 'x':
                if start is not None and creature != 0:
                    rows.append((creature, start, (i, j - 1)))
                start = None
                creature = 0
                continue
            # Set start
            if start is None:
                start = (i, j)

            if char == 'o':
                creature += 1
            elif char == ' ':
                pass
            else:
                raise ValueError('Invalid cell: {}'.format(char))

    if start is not None and creature != 0:
        rows.append((creature, start, (i, j - 1)))

    rows.sort(key=itemgetter(0), reverse=True)

    for j in xrange(len(maze[0])):
        start = None
        creature = 0
        for i in xrange(len(maze)):
            char = maze[i][j]
            if char == 'x':
                if start is not None and creature != 0:
                    columns.append((creature, start, (i - 1, j)))
                start = None
                creature = 0
                continue
            # Set start.
            if start is None:
                start = (i, j)

            if char == 'o':
                creature += 1
            elif char == ' ':
                pass
            else:
                raise ValueError('Invalid cell: {}'.format(char))

    if start is not None and creature != 0:
        columns.append((creature, start, (i - 1, j)))

    columns.sort(key=itemgetter(0), reverse=True)

    row_max = rows[0][0] if rows else 0
    column_max = columns[0][0] if columns else 0
    non_crossed_max = max(row_max, column_max)
    crossed_max = 0

    for i, row in enumerate(rows):
        if row[1] == row[2]:
            continue

        for j, column in enumerate(columns):
            if column[1] == column[2]:
                continue

            if row[0] + column[0] <= non_crossed_max:
                # If less than know max, it's not a candidate.
                continue

            if is_crossed(row[1], row[2], column[1], column[2]):
                x_intersection = row[1][0]
                y_intersection = column[1][1]
                if maze[x_intersection][y_intersection] == 'o':
                    # Creature standing at intersection counts twice.
                    local_max = row[0] + column[0] - 1
                else:
                    local_max = row[0] + column[0]
                if local_max > crossed_max:
                    crossed_max = local_max
                    ii = i
                    jj = j

            j += 1
        i += 1

    max_kill = max(row_max, column_max, crossed_max)

    if max_kill == row_max:
        print 'In row', rows[0][1], rows[0][2]
    elif max_kill == column_max:
        print 'In column', columns[0][1], columns[0][2]
    else:
        print 'In crossed row', rows[ii][1], rows[ii][2], \
            'column', columns[jj][1], columns[jj][2]

    return max_kill


def is_crossed(row_start, row_end, column_start, column_end):
    """Return whether a vertical and horitontal line are intersected."""
    return row_start[1] <= column_start[1] and column_start[1] <= row_end[1] and \
        column_start[0] <= row_start[0] and row_start[0] <= column_end[0]


class TestSuite(unittest.TestCase):

    """Bomber man test suite."""

    def test_map1(self):
        """"""
        maze = [            #
            'xxxxxxxxxxxxxxxxxxxxxxxxx',
            'x x x x x x x x x x x x x',
            'x         o o  o        x',
            'x x x x x x x x x x x x x',
            'x       x      o        x',
            'x x x x x x x x x x x x x',
            'x x o   o   o  o        x', #
            'x x x x x x x x x x x x x',
            'x       o      o        x',
            'x x x x x x x x x x x x x',
            'x       x               x',
            'x x x x x x x x x x x x x',
            'x  o     o     o        x',
            'xxxxxxxxxxxxxxxxxxxxxxxxx',
        ]
        self.assertEqual(8, max_kill_with_one_bomb(maze))

    def test_map2(self):
        """"""
        maze = [            #
            'xxxxxxxxxxxxxxxxxxxxxxxxx',
            'x x x x x x x x x x x x x',
            'x o o o o o    o        x', #
            'x x x x x x x x x x x x x',
            'x       x      o        x',
            'x x x x x x x x x x x x x',
            'x x o   o   o  o        x',
            'x x x x x x x x x x x x x',
            'x       o      o        x',
            'x x x x x x x x x x x x x',
            'x       x               x',
            'x x x x x x x x x x x x x',
            'x  o     o     o        x',
            'xxxxxxxxxxxxxxxxxxxxxxxxx',
        ]
        self.assertEqual(10, max_kill_with_one_bomb(maze))

    def test_map3(self):
        """"""
        maze = [            #
            'xxxxxxxxxxxxxxxxxxxxxxxxx',
            'x x x x x x x x x x x x x',
            'x o o o o o    o        x', #
            'x x x x x x x x x x x x x',
            'x       x      o        x',
            'x x x x x x x x x x x x x',
            'x x o   o   o  o        x',
            'x x x x x x x x x x x x x',
            'x       o      o        x',
            'x x x x x x x x x x x x x',
            'x       x               x',
            'x x x x x x x x x x x x x',
            'x  o     o     o        x',
            'xxxxxxxxxxxxxxxxxxxxxxxxx',
        ]
        self.assertEqual(10, max_kill_with_one_bomb(maze))

if __name__ == '__main__':
    unittest.main()
