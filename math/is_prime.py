import time

def is_prime(n, known_primes):
    if n <= 1:
        return False
    elif n == 2:
        return True
    elif n % 2 == 0:
        return False
    else:
        sq = int(n ** 0.5)
        for i in known_primes:
            if i > sq:
                break
            if n % i == 0:
                return False
        return True


def main():
    start = time.time()
    known_primes = []
    for i in range(100):
        if is_prime(i, known_primes):
            print(i)
            known_primes.append(i)
    print(time.time() - start)


if __name__ == '__main__':
    main()
