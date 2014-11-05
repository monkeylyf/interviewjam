"""hackerrank_leibniz.py

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/leibniz
"""

r=raw_input;x=xrange
for _ in x(int(r())): print reduce(lambda a,b:a+pow(-1,b)/float(2*b+1),x(1,int(r())),1)
