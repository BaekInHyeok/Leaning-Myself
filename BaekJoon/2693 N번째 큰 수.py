T=int(input())

for i in range(T):
    numbers=list(map(int,input().split(' ')))
    numbers.sort()
    numbers.reverse()
    
    print(numbers[2])