def hanoi(number,start,end,between):
    if number==1:
        print("{0} {1}".format(start,end))
    else:
        hanoi(number-1,start,between,end)
        print(f'{start} {end}')
        hanoi(number-1,between,end,start)
    
N=int(input())
count=1

for i in range(N-1):
    count=count*2+1
print(count)
hanoi(N,1,3,2)