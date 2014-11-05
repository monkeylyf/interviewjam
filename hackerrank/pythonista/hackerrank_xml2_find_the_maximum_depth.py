"""hackerrank_xml2_find_the_maximum_depth

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/xml2-find-the-maximum-depth
"""

try:
    from lxml import etree as ET
except ImportError:
    import xml.etree.ElementTree as ET


def main():
    n = int(raw_input())

    xml = []
    for _ in xrange(n):
        xml.append(raw_input())
    content = '\n'.join(xml)

    root = ET.fromstring(content)

    depth = 0
    queue = [root]
    nex_lvl = []
    while queue:
        node = queue.pop()
        for child in node:
            nex_lvl.append(child)
        if not queue:
            queue = nex_lvl
            nex_lvl = []
            if queue:
                depth += 1

    print depth


if __name__ == '__main__':
    main()
