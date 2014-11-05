"""hackerrank_xml1_find_the_score

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/xml-1-find-the-score
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

    count = 0
    root = ET.fromstring(content)

    queue = [root]
    while queue:
        node = queue.pop()
        count += len(node.attrib)
        for child in node:
            queue.append(child)

    print count


if __name__ == '__main__':
    main()
